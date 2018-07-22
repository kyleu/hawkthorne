package models.animation

object AnimationCoords {
  private[this] def from(start: Int, end: Int) = if (start < end) { start to end } else { end to start }

  def fromString(s: String) = {
    val ret = s.split('|').map(_.trim).filter(_.nonEmpty).foldLeft(IndexedSeq.empty[(Int, Int)]) { (ret, c) =>
      val newCoords = c.split(',').toList match {
        case x :: y :: Nil if x.contains('-') || y.contains('-') =>
          val xs = x.split('-').toList match {
            case start :: end :: Nil => from(start.toInt, end.toInt)
            case solo :: Nil => Seq(solo.toInt)
            case _ => throw new IllegalStateException(s"Illegal x range [$x].")
          }
          val ys = y.split('-').toList match {
            case start :: end :: Nil => from(start.toInt, end.toInt)
            case solo :: Nil => Seq(solo.toInt)
            case _ => throw new IllegalStateException(s"Illegal y range [$y].")
          }
          xs.flatMap(x => ys.map(y => x -> y))
        case x :: y :: Nil => Seq(x.toInt -> y.toInt)
        case x => throw new IllegalStateException(s"Illegal coords [${x.mkString(",")}].")
      }
      ret ++ newCoords
    }.map(x => (x._1 - 1) -> (x._2 - 1))
    if (ret.isEmpty) {
      throw new IllegalStateException(s"Invalid animation string [$s].")
    }
    ret
  }

}
