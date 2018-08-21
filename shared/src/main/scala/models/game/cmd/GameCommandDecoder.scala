package models.game.cmd

import io.circe.HCursor
import models.game.cmd.GameCommand._
import util.JsonSerializers._

object GameCommandDecoder {
  implicit val jsonDecoder: Decoder[GameCommand] = (c: HCursor) => c.downField("type").as[String] match {
    case Left(x) => throw new IllegalStateException(s"Unable to find [type] among [${c.keys.mkString(", ")}].", x)
    case Right(t) => t match {
      case AddPlayer.key => c.as[AddPlayer]
      case RemovePlayer.key => c.as[RemovePlayer]
      case PlayerInput.key => c.as[PlayerInput]
      case Debug.key => c.as[Debug]
    }
  }
}
