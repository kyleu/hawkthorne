package models.game.msg

import java.util.UUID

import models.player.Player
import util.JsonSerializers._

sealed abstract class GameMessage(val t: String)

object GameMessage {
  object PlayerAdded {
    implicit val jsonEncoder: Encoder[PlayerAdded] = deriveEncoder
    implicit val jsonDecoder: Decoder[PlayerAdded] = deriveDecoder
    val key = "playerAdded"
  }
  final case class PlayerAdded(player: Player) extends GameMessage(t = PlayerAdded.key)

  object PlayerRemoved {
    implicit val jsonEncoder: Encoder[PlayerRemoved] = deriveEncoder
    implicit val jsonDecoder: Decoder[PlayerRemoved] = deriveDecoder
    val key = "playerRemoved"
  }
  final case class PlayerRemoved(idx: Int, id: UUID) extends GameMessage(t = PlayerRemoved.key)

  sealed abstract class PlayerMessage(t: String) extends GameMessage(t = t) {
    def idx: Int
  }

  object PlayerAnimationUpdated {
    implicit val jsonEncoder: Encoder[PlayerAnimationUpdated] = deriveEncoder
    implicit val jsonDecoder: Decoder[PlayerAnimationUpdated] = deriveDecoder
    val key = "playerAnimationUpdated"
  }
  final case class PlayerAnimationUpdated(override val idx: Int, anim: String) extends PlayerMessage(t = PlayerAnimationUpdated.key)

  object PlayerLocationUpdated {
    implicit val jsonEncoder: Encoder[PlayerLocationUpdated] = deriveEncoder
    implicit val jsonDecoder: Decoder[PlayerLocationUpdated] = deriveDecoder
    val key = "playerLocationUpdated"
  }
  final case class PlayerLocationUpdated(override val idx: Int, x: Double, y: Double) extends PlayerMessage(t = PlayerLocationUpdated.key)

  object LeaveMap {
    implicit val jsonEncoder: Encoder[LeaveMap] = deriveEncoder
    implicit val jsonDecoder: Decoder[LeaveMap] = deriveDecoder
    val key = "leaveMap"
  }
  final case class LeaveMap(idx: Int, src: String, dest: String) extends PlayerMessage(t = LeaveMap.key)

  object Notify {
    implicit val jsonEncoder: Encoder[Notify] = deriveEncoder
    implicit val jsonDecoder: Decoder[Notify] = deriveDecoder
    val key = "notify"
  }
  final case class Notify(player: Option[Int], channel: String, msgs: Seq[String]) extends GameMessage(t = Notify.key)

  object Debug {
    implicit val jsonEncoder: Encoder[Debug] = deriveEncoder
    implicit val jsonDecoder: Decoder[Debug] = deriveDecoder
    val key = "debug"
  }
  final case class Debug(category: String, msg: String) extends GameMessage(t = Debug.key)

  implicit val jsonEncoder: Encoder[GameMessage] = GameMessageEncoder.jsonEncoder
  implicit val jsonDecoder: Decoder[GameMessage] = GameMessageDecoder.jsonDecoder
}

