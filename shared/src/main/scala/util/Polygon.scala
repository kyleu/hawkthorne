package util

import util.JsonSerializers._

object Polygon {
  implicit val jsonEncoder: Encoder[Polygon] = deriveEncoder
  implicit val jsonDecoder: Decoder[Polygon] = deriveDecoder
}

case class Polygon(points: Seq[DoublePoint]) {
  if (points.size < 3) { throw new IllegalStateException("Polygons must have at least three points.") }

  private[this] val pairs = (points.last :: points.toList).sliding(2).toSeq

  def pointIn(p: DoublePoint): Boolean = pairs.foldLeft(false) {
    case (c, List(i, j)) =>
      val cond = ((i.x <= p.x && p.x < j.x) || (j.x <= p.x && p.x < i.x)) && (p.y < (j.y - i.y) * (p.x - i.x) / (j.x - i.x) + i.y)
      if (cond) { !c } else { c }
  }

  override def toString = s"Polygon[${points.map(p => p.x + "/" + p.y).mkString(", ")}]"
}
