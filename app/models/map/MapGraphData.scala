package models.map

import models.data.map.TiledMap
import models.node.DoorNode
import services.map.ServerMapCache

object MapGraphData {
  def clean(s: String) = s.replaceAllLiterally("-", "")

  lazy val chartData = {
    val ret = new StringBuilder("graph TD\n")
    def addLine(l: String) = ret.append("  " + l + "\n")
    TiledMap.values.foreach { m =>
      val url = s"""<a>/play/map/${m.value}</a>"""
      val cols = s"""<cite>${m.details.title}</cite><dt>${m.details.soundtrack} / [${m.width}, ${m.height}]</dt>$url"""
      addLine(s"""${clean(m.value)}["<section><h6>fa:fa-gear <span>${m.value}<span></h6>$cols</section>"]""")
    }
    val exits = ServerMapCache.all.map { m =>
      val doors = m.nodes.collect { case d: DoorNode => d }
      m.key -> doors.flatMap(_.properties.flatMap(_.level)).distinct.filterNot(_ == m.key)
    }
    val encountered = collection.mutable.HashSet.empty[(String, String)]
    exits.foreach { l =>
      l._2.foreach { exit =>
        val path = clean(l._1) -> clean(exit)
        if (encountered(path) || encountered((path._2, path._1))) {
          // noop
        } else {
          encountered += path
          addLine(s"""${clean(l._1)} --> ${clean(exit)}""")
        }
      }
    }
    ret.toString
  }
}
