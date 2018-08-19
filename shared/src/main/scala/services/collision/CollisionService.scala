package services.collision

import models.collision.{CollisionGrid, CollisionPoly}
import models.data.map.TiledMap
import models.options.SystemOptions
import util.Rectangle

case class CollisionService(map: TiledMap, collision: Either[CollisionPoly, CollisionGrid]) {
  val max = (map.width.toDouble * SystemOptions.tileSize, map.height.toDouble * SystemOptions.tileSize)

  private[this] val gridMovementClass = "simple"
  private[this] val polyMovementClass = "poly"

  private[this] val movement = collision match {
    case Right(grid) => gridMovementClass match {
      case "noop" => new NoCollisionMovement(max)
      case "simple" => new SimpleGridMovement(max, grid)
      case "grid" => new GridMovement(max, grid)
      case _ => throw new IllegalStateException(s"Unhandled collision engine [$gridMovementClass]")
    }
    case Left(poly) => gridMovementClass match {
      case "noop" => new NoCollisionMovement(max)
      case "poly" => new PolygonMovement(max, poly)
      case _ => throw new IllegalStateException(s"Unhandled collision engine [$gridMovementClass]")
    }
  }

  def move(current: (Double, Double), bounds: Rectangle, delta: (Double, Double)) = movement.move(current, bounds, delta)
}
