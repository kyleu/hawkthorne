package models.animation

object AnimationCoords {
  def fromString(s: String) = s.split('|').map(_.trim).filter(_.nonEmpty).foldLeft(IndexedSeq.empty[(Int, Int)]) { (ret, c) =>
    val newCoords = c.split(',').toList match {
      case x :: y :: Nil if x.contains('-') => x.split('-').toList match {
        case start :: end :: Nil => (start.toInt to end.toInt).map(subX => subX -> y.toInt)
        case _ => throw new IllegalStateException(s"Illegal range [$x].")
      }
      case x :: y :: Nil => Seq(x.toInt -> y.toInt)
      case x => throw new IllegalStateException(s"Illegal coords [${x.mkString(",")}].")
    }
    ret ++ newCoords
  }.map(x => (x._1 - 1) -> (x._2 - 1))
}
