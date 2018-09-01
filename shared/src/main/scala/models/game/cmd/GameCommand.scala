package models.game.cmd

import java.util.UUID

import models.input.InputCommand
import models.player.Player
import util.JsonSerializers._

sealed abstract class GameCommand(val t: String)

object GameCommand {
  object AddPlayer {
    implicit val jsonEncoder: Encoder[AddPlayer] = deriveEncoder
    implicit val jsonDecoder: Decoder[AddPlayer] = deriveDecoder
    val key = "addPlayer"
  }
  final case class AddPlayer(player: Player, spawn: String) extends GameCommand(AddPlayer.key)

  object RemovePlayer {
    implicit val jsonEncoder: Encoder[RemovePlayer] = deriveEncoder
    implicit val jsonDecoder: Decoder[RemovePlayer] = deriveDecoder
    val key = "removePlayer"
  }
  final case class RemovePlayer(id: UUID) extends GameCommand(RemovePlayer.key)

  sealed abstract class PlayerMessage(t: String) extends GameCommand(t) { def idx: Int }

  object PlayerInput {
    implicit val jsonEncoder: Encoder[PlayerInput] = deriveEncoder
    implicit val jsonDecoder: Decoder[PlayerInput] = deriveDecoder
    val key = "playerInput"
  }
  final case class PlayerInput(override val idx: Int, x: Double, y: Double, commands: Seq[InputCommand]) extends PlayerMessage(PlayerInput.key)

  object Debug {
    implicit val jsonEncoder: Encoder[Debug] = deriveEncoder
    implicit val jsonDecoder: Decoder[Debug] = deriveDecoder
    val key = "debug"
  }
  final case class Debug(id: UUID = UUID.randomUUID, category: String = "debug", msg: String = "") extends GameCommand(Debug.key)

  implicit val jsonEncoder: Encoder[GameCommand] = GameCommandEncoder.jsonEncoder
  implicit val jsonDecoder: Decoder[GameCommand] = GameCommandDecoder.jsonDecoder
}
