package util

import org.scalatest._

class PolygonTests extends FlatSpec with Matchers {
  val originPoint = DoublePoint(0, 0)
  val centerPoint = DoublePoint(5, 5)

  "Invalid polygons" should "throw exception on creation" in {
    a[IllegalStateException] should be thrownBy { util.Polygon(Seq()) }
    a[IllegalStateException] should be thrownBy { util.Polygon(Seq(originPoint)) }
    a[IllegalStateException] should be thrownBy { util.Polygon(Seq(originPoint, originPoint)) }
  }

  "A simple polygon" should "construct and intersect correctly" in {
    val p = util.Polygon(Seq(originPoint, DoublePoint(10, 0), DoublePoint(10, 10), DoublePoint(0, 10)))
    // p.pointIn(originPoint) should be(true)
    p.pointIn(centerPoint) should be(true)
  }
}
