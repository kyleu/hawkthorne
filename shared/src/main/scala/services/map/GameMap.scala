package services.map

import java.util.UUID

import models.data.map.TiledMap
import models.game.obj.GameObject
import models.options.SystemOptions
import services.collision.CollisionService
import util.{IntPoint, Rectangle}

object GameMap {
  import util.JsonSerializers._

  implicit val jsonEncoder: Encoder[GameMap] = deriveEncoder
  implicit val jsonDecoder: Decoder[GameMap] = deriveDecoder
}

final case class GameMap(gameId: UUID, map: TiledMap, var objects: IndexedSeq[GameObject]) {
  private[this] var spawns = Map.empty[String, IntPoint]
  private[this] var collision: Option[CollisionService.Collision] = None

  val bounds = (map.width * SystemOptions.tileSize) -> (map.height * SystemOptions.tileSize)

  def setSpawns(m: Map[String, IntPoint]) = spawns = m
  def spawnPoints(p: String) = spawns.getOrElse(p, {
    throw new IllegalStateException(s"No spawn point [$p] for map [$map] among [${spawns.values.mkString(", ")}]")
  })

  def collidingObjects(rect: Rectangle) = objects.collect { case o if o.loc.intersects(rect) => o }

  def setCollision(coll: CollisionService.Collision) = collision = Some(coll)
  def getCollision = collision.getOrElse(throw new IllegalStateException("No collision configured."))

  def collidingBlocks(rect: Rectangle) = IndexedSeq.empty[(Int, Int)]

  def deltaFor(sourceObjects: IndexedSeq[GameObject]) = {
    val added = Nil
    val removed = Nil
    val updated = Nil
    GameMapDelta(gameId = gameId, map = map, added = added, removed = removed, updated = updated)
  }
}
