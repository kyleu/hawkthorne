package services.collision

import models.collision.{CollisionGrid, CollisionPoly}
import models.data.map.TiledMap
import models.options.SystemOptions
import util.Rectangle

case class CollisionService(map: TiledMap, collision: Either[CollisionPoly, CollisionGrid]) {
  val max = (map.width.toDouble * SystemOptions.tileSize, map.height.toDouble * SystemOptions.tileSize)

  private[this] val gridMovementClass = "simple"

  private[this] val movement = collision match {
    case Right(grid) => gridMovementClass match {
      case "noop" => new NoCollisionMovement(max)
      case "simple" => new SimpleMovement(max, grid)
      case "fancy" => new FancyMovement(max, grid)
      case _ => throw new IllegalStateException(s"Unhandled collision engine [$gridMovementClass]")
    }
    // case Right(grid) => new FancyMovement(max, collision)
    case Left(poly) => new PolygonMovement(max, poly)
  }

  def move(current: (Double, Double), bounds: Rectangle, delta: (Double, Double)) = movement.move(current, bounds, delta)
}
