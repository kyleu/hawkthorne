package models.game.msg

import io.circe.HCursor
import models.game.msg.GameMessage._
import util.JsonSerializers._

object GameMessageDecoder {
  implicit val jsonDecoder: Decoder[GameMessage] = (c: HCursor) => c.downField("type").as[String] match {
    case Left(x) => throw new IllegalStateException(s"Unable to find [type] among [${c.keys.mkString(", ")}].", x)
    case Right(t) => t match {
      case PlayerAdded.key => c.as[PlayerAdded]
      case PlayerRemoved.key => c.as[PlayerRemoved]
      case PlayerAnimationUpdated.key => c.as[PlayerAnimationUpdated]
      case PlayerLocationUpdated.key => c.as[PlayerLocationUpdated]
      case LeaveMap.key => c.as[LeaveMap]
      case Notify.key => c.as[Notify]
      case Debug.key => c.as[Debug]
    }
  }
}
