package models.game.cmd

import io.circe.ObjectEncoder
import models.game.cmd.GameCommand._
import util.JsonSerializers._

object GameCommandEncoder {
  implicit val jsonEncoder: Encoder[GameCommand] = new ObjectEncoder[GameCommand] {
    override def encodeObject(n: GameCommand) = {
      val ret = n match {
        case o: AddPlayer => o.asJson.asObject.get
        case o: RemovePlayer => o.asJson.asObject.get
        case o: PlayerInput => o.asJson.asObject.get
        case o: Debug => o.asJson.asObject.get
      }
      ("type" -> n.t.asJson) +: ret
    }
  }
}
