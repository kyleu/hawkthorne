package util

import util.JsonSerializers._

object Polygon {
  implicit val jsonEncoder: Encoder[Polygon] = deriveEncoder
  implicit val jsonDecoder: Decoder[Polygon] = deriveDecoder
}

case class Polygon(points: Seq[DoublePoint]) {
  private[this] val corners = points.size
  private[this] val horizontal = points.map(_.x).toArray
  private[this] val vertical = points.map(_.y).toArray

  @scala.annotation.tailrec
  private[this] final def precalc(
    i: Int, j: Int, constant: List[Double], multiple: List[Double]
  ): (List[Double], List[Double]) = i match {
    case _ if i == corners => (constant, multiple)
    case _ if vertical(j) == vertical(i) => precalc(i + 1, i, horizontal(i) :: constant, 0d :: multiple)
    case i: Int =>
      val k = horizontal(i) - (vertical(i) * horizontal(j)) / (vertical(j) - vertical(i)) + (vertical(i) * horizontal(i)) / (vertical(j) - vertical(i))
      val m = (horizontal(j) - horizontal(i)) / (vertical(j) - vertical(i))
      precalc(i + 1, i, k :: constant, m :: multiple)
  }

  @scala.annotation.tailrec
  private[this] final def isInside(
    point: DoublePoint, i: Int, j: Int, constant: Array[Double], multiple: Array[Double], oddNodes: Boolean
  ): Boolean = i match {
    case _ if i == corners => oddNodes
    case _ if vertical(i) < point.y && vertical(j) >= point.y || vertical(j) < point.y && vertical(i) >= point.y =>
      isInside(point, i + 1, i, constant, multiple, oddNodes ^ (point.y * multiple(i) + constant(i) < point.x))
    case i: Int => isInside(point, i + 1, i, constant, multiple, oddNodes)
  }

  def pointIn(point: DoublePoint): Boolean = {
    val tuple = precalc(0, corners - 1, List(), List())
    isInside(point, 0, corners - 1, tuple._1.toArray, tuple._2.toArray, oddNodes = false)
  }

  override def toString = s"Polygon[${points.map(p => p.x + "/" + p.y).mkString(", ")}]"
}
