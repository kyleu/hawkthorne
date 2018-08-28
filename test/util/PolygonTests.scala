package util

import org.scalatest._

class PolygonTests extends FlatSpec with Matchers {
  val originPoint = DoublePoint(0, 0)

  "Invalid polygons" should "throw exception on creation" in {
    a[IllegalStateException] should be thrownBy { util.Polygon(Seq()) }
    a[IllegalStateException] should be thrownBy { util.Polygon(Seq(originPoint)) }
    a[IllegalStateException] should be thrownBy { util.Polygon(Seq(originPoint, originPoint)) }
  }

  "A simple polygon" should "construct and intersect correctly" in {
    val p = util.Polygon(Seq(originPoint, DoublePoint(10, 0), DoublePoint(10, 10), DoublePoint(0, 10)))

    p.pointIn(DoublePoint(0.1, 0.1)) should be(true)
    p.pointIn(DoublePoint(1.0, 1.0)) should be(true)
    p.pointIn(DoublePoint(5, 5)) should be(true)
    p.pointIn(DoublePoint(9.9, 9.9)) should be(true)

    p.pointIn(DoublePoint(-0.1, -0.1)) should be(false)
  }

  "The study room polygon" should "construct and intersect correctly" in {
    val points = Seq(DoublePoint(0, 0), DoublePoint(48, -48), DoublePoint(576, -48), DoublePoint(600, -24), DoublePoint(624, -24), DoublePoint(648, 0))
    val p = util.Polygon(points)

    p.pointIn(DoublePoint(0.1, -0.2)) should be(true)
    p.pointIn(DoublePoint(1.0, -1.0)) should be(true)
    p.pointIn(DoublePoint(5, -5)) should be(true)
    p.pointIn(DoublePoint(9.9, -9.9)) should be(true)

    p.pointIn(DoublePoint(-0.1, -0.1)) should be(false)
  }
}
