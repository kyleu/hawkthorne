package models.game.obj

import models.game.msg.GameMessage
import models.template.npc.NpcTemplate
import util.JsonSerializers._

object Npc {
  implicit val jsonEncoder: Encoder[Npc] = deriveEncoder
  implicit val jsonDecoder: Decoder[Npc] = deriveDecoder

  val key = "npc"
}

final case class Npc(
    override val id: Int,
    override val n: String,
    override val loc: util.Rectangle,
    override val vis: Boolean,
    template: NpcTemplate
) extends GameObject(Npc.key) {
  override def onSelect(playerIdx: Int) = Seq(GameMessage.Notify(Some(playerIdx), "dialog", Seq(template.greeting.getOrElse("..."))))
}
