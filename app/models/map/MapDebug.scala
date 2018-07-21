package models.map

import models.node.Node

object MapDebug {
  private[this] val commonFields = Set("type", "id", "name", "x", "y", "width", "height", "rotation", "visible")

  def nodes(nodes: Seq[Node]) = nodes.groupBy(_.getClass).toSeq.map(x => x._1.getSimpleName.stripSuffix("$") -> x._2).sortBy(_._1)

  def requiredFields(nodes: Seq[Node]) = {
    import util.JsonSerializers._
    val jsons = nodes.map(_.asJson.asObject.get)

    var fields = jsons.flatMap(_.keys.filterNot(commonFields.apply)).toSet

    jsons.foreach { json =>
      json.keys.filterNot(commonFields.apply).foreach { k =>
        json.apply(k) match {
          case None => fields = fields - k
          case Some(v) if v.isNull => fields = fields - k
          case _ => // noop
        }
      }
    }

    fields.toSeq.sorted
  }
}
