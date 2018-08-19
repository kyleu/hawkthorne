package util

case class Polygon(points: Seq[DoublePoint]) {
  def corners = points.size
  def horizontalCoordinates = points.map(_.x)
  def verticalCoordinates = points.map(_.y)
}

object PolygonUtils {
  @scala.annotation.tailrec
  def precalc(
    polyCorners: Int, i: Int, j: Int, polyX: Array[Double], polyY: Array[Double], constant: List[Double], multiple: List[Double]
  ): (List[Double], List[Double]) = i match {
    case _ if i == polyCorners => (constant, multiple)
    case _ if polyY(j) == polyY(i) => precalc(polyCorners, i + 1, i, polyX, polyY, polyX(i) :: constant, 0d :: multiple)
    case i: Int =>
      val k = polyX(i) - (polyY(i) * polyX(j)) / (polyY(j) - polyY(i)) + (polyY(i) * polyX(i)) / (polyY(j) - polyY(i))
      val m = (polyX(j) - polyX(i)) / (polyY(j) - polyY(i))
      precalc(polyCorners, i + 1, i, polyX, polyY, k :: constant, m :: multiple)
  }

  @scala.annotation.tailrec
  def isInside(
    point: DoublePoint, polyCorners: Int, i: Int, j: Int, poly: (Array[Double], Array[Double]),
    constant: Array[Double], multiple: Array[Double], oddNodes: Boolean
  ): Boolean = i match {
    case _ if i == polyCorners => oddNodes
    case _ if poly._2(i) < point.y && poly._2(j) >= point.y || poly._2(j) < point.y && poly._2(i) >= point.y =>
      isInside(point, polyCorners, i + 1, i, poly, constant, multiple, oddNodes ^ (point.y * multiple(i) + constant(i) < point.x))
    case i: Int => isInside(point, polyCorners, i + 1, i, poly, constant, multiple, oddNodes)
  }

  def pointInPolygon(point: DoublePoint, polygon: Polygon): Boolean = {
    val polyX = polygon.horizontalCoordinates.toArray
    val polyY = polygon.verticalCoordinates.toArray

    val tuple = precalc(polygon.corners, 0, polygon.corners - 1, polyX, polyY, List(), List())

    isInside(point, polygon.corners, 0, polygon.corners - 1, polyX -> polyY, tuple._1.toArray, tuple._2.toArray, oddNodes = false)
  }
}
