package models.game.msg

import io.circe.ObjectEncoder
import models.game.msg.GameMessage._
import util.JsonSerializers._

object GameMessageEncoder {
  implicit val jsonEncoder: Encoder[GameMessage] = new ObjectEncoder[GameMessage] {
    override def encodeObject(n: GameMessage) = {
      val ret = n match {
        case o: PlayerAdded => o.asJson.asObject.get
        case o: PlayerRemoved => o.asJson.asObject.get
        case o: PlayerAnimationUpdated => o.asJson.asObject.get
        case o: PlayerLocationUpdated => o.asJson.asObject.get
        case o: LeaveMap => o.asJson.asObject.get
        case o: Notify => o.asJson.asObject.get
        case o: Debug => o.asJson.asObject.get
      }
      ("type" -> n.t.asJson) +: ret
    }
  }
}
