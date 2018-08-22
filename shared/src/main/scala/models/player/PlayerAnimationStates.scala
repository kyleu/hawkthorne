package models.player

import models.data.character.CharacterAnimation
import models.data.character.CharacterAnimation._

object PlayerAnimationStates {
  case class States(
      walkState: CharacterAnimation,
      crouchState: CharacterAnimation,
      crouchMovingState: CharacterAnimation,
      gazeState: CharacterAnimation,
      gazeMovingState: CharacterAnimation,
      jumpState: CharacterAnimation,
      idleState: CharacterAnimation,
      persistence: Boolean
  )

  val wielding = States(
    walkState = WieldWalk,
    crouchState = Crouch,
    crouchMovingState = CrouchWalk,
    gazeState = Idle,
    gazeMovingState = GazeWalk,
    jumpState = WieldJump,
    idleState = WieldIdle,
    persistence = true
  )
  val holding = States(
    walkState = HoldWalk,
    crouchState = Crouch,
    crouchMovingState = CrouchHoldWalk,
    gazeState = Idle,
    gazeMovingState = GazeHoldWalk,
    jumpState = HoldJump,
    idleState = Hold,
    persistence = true
  )
  val attacking = States(
    walkState = AttackWalk,
    crouchState = Dig,
    crouchMovingState = Dig,
    gazeState = Attack,
    gazeMovingState = Attack,
    jumpState = Kick,
    idleState = AttackWalk,
    persistence = true
  )
  val climbing = States(
    walkState = GazeHoldWalk,
    crouchState = GazeHoldWalk,
    crouchMovingState = GazeHoldWalk,
    gazeState = GazeHoldWalk,
    gazeMovingState = GazeHoldWalk,
    jumpState = GazeHoldWalk,
    idleState = GazeHold,
    persistence = true
  )
  val crawling = States(
    walkState = CrawlWalk,
    crouchState = CrawlIdle,
    crouchMovingState = CrawlCrouchWalk,
    gazeState = CrawlIdle,
    gazeMovingState = CrawlGazeWalk,
    jumpState = Jump,
    idleState = CrawlIdle,
    persistence = true
  )
  val resting = States(
    walkState = Rest,
    crouchState = Rest,
    crouchMovingState = Rest,
    gazeState = Rest,
    gazeMovingState = Rest,
    jumpState = Rest,
    idleState = Rest,
    persistence = true
  )
  val default = States(
    walkState = Walk,
    crouchState = Crouch,
    crouchMovingState = CrouchWalk,
    gazeState = Idle,
    gazeMovingState = GazeWalk,
    jumpState = Jump,
    idleState = Idle,
    persistence = true
  )
}
