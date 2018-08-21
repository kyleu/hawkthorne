package models.game.obj

import models.game.msg.GameMessage
import util.JsonSerializers._

object Door {
  implicit val jsonEncoder: Encoder[Door] = deriveEncoder
  implicit val jsonDecoder: Decoder[Door] = deriveDecoder

  val key = "door"
}

final case class Door(
    override val id: Int,
    override val n: String,
    override val loc: util.Rectangle,
    override val vis: Boolean,
    destination: Option[String]
) extends GameObject(Door.key) {
  override def onSelect(playerIdx: Int) = destination match {
    case Some(dest) => Seq(GameMessage.LeaveMap(idx = playerIdx, src = n, dest = dest))
    case None => Seq(GameMessage.Notify(Some(playerIdx), "console", Seq(s"DOOR, MOTHERFUCKER!!!")))
  }
}
