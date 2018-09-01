package services.map

import java.util.UUID

import models.data.map.TiledMap
import models.game.obj.GameObject
import util.JsonSerializers._

object GameMapDelta {
  implicit val jsonEncoder: Encoder[GameMapDelta] = deriveEncoder
  implicit val jsonDecoder: Decoder[GameMapDelta] = deriveDecoder
}

case class GameMapDelta(
    gameId: UUID,
    map: TiledMap,
    added: Seq[GameObject],
    removed: Seq[Int],
    updated: Seq[GameObject]
) {
  override def toString = {
    val objString = s"[${added.size}] added, [${removed.size}] removed, and [${updated.size}] updated"
    s"Map [$map] delta for gameId [$gameId] with $objString objects."
  }
}
