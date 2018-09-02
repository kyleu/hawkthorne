package services.map

import java.util.UUID

import models.data.map.TiledMap
import models.game.obj.GameObject
import util.JsonSerializers._

object GameMapDelta {
  implicit val jsonEncoder: Encoder[GameMapDelta] = deriveEncoder
  implicit val jsonDecoder: Decoder[GameMapDelta] = deriveDecoder

  def forGameObjects(gameId: UUID, map: TiledMap, src: IndexedSeq[GameObject], tgt: IndexedSeq[GameObject]) = {
    val zipped = tgt.map(o => o -> src.find(_.id == o.id))
    val added = zipped.filter(_._2.isEmpty).map(_._1)
    val updated = zipped.flatMap {
      case (s, t) if t.forall(_ == s) => None
      case (s, t) => t
    }
    val removed = src.filterNot(o => tgt.exists(_.id == o.id)).map(_.id)
    GameMapDelta(gameId = gameId, map = map, added = added, removed = removed, updated = updated)
  }
}

case class GameMapDelta(
    gameId: UUID,
    map: TiledMap,
    added: Seq[GameObject],
    updated: Seq[GameObject],
    removed: Seq[Int]
) {
  override def toString = {
    val objString = s"[${added.size}] added, [${updated.size}] updated, and [${removed.size}] removed"
    s"Map [$map] delta for gameId [$gameId] with $objString objects."
  }
}
