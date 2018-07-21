package models.map

import models.node.Node

object MapDebug {
  def nodes(nodes: Seq[Node]) = nodes.groupBy(_.getClass).toSeq.map(x => x._1.getSimpleName.stripSuffix("$") -> x._2.size).sortBy(_._1)
}
