/* Generated File */
package models.data.character

import enumeratum.values.{StringCirceEnum, StringEnum, StringEnumEntry}
import models.animation.Animation

sealed abstract class CharacterAnimation(
    override val value: String, val left: Seq[(Int, Int)], val right: Seq[(Int, Int)], val duration: Double, val loop: Boolean
) extends StringEnumEntry {
  lazy val leftAnim = Animation(value + ".left", left.map(x => (x._1 * 12) + x._2), duration, loop)
  lazy val rightAnim = Animation(value + ".right", right.map(x => (x._1 * 12) + x._2), duration, loop)
}

object CharacterAnimation extends StringEnum[CharacterAnimation] with StringCirceEnum[CharacterAnimation] {
  case object Acquire extends CharacterAnimation(value = "acquire", left = Seq((7, 3)), right = Seq((7, 4)), duration = 1.0, loop = false)
  case object Attack extends CharacterAnimation(value = "attack", left = Seq((1, 9), (5, 9)), right = Seq((1, 10), (5, 10)), duration = 0.1, loop = false)
  case object AttackJump extends CharacterAnimation(value = "attackjump", left = Seq((4, 9), (8, 9)), right = Seq((4, 10), (8, 10)), duration = 0.1, loop = false)
  case object AttackWalk extends CharacterAnimation(value = "attackwalk", left = Seq((2, 9), (7, 9)), right = Seq((2, 10), (7, 10)), duration = 0.1, loop = false)
  case object CrawlcrouchWalk extends CharacterAnimation(value = "crawlcrouchwalk", left = Seq((5, 13), (6, 13), (7, 13), (8, 13)), right = Seq((5, 13), (6, 13), (7, 13), (8, 13)), duration = 0.16, loop = true)
  case object CrawlGazeWalk extends CharacterAnimation(value = "crawlgazewalk", left = Seq((5, 14), (6, 14), (7, 14), (8, 14)), right = Seq((5, 14), (6, 14), (7, 14), (8, 14)), duration = 0.16, loop = true)
  case object CrawlIdle extends CharacterAnimation(value = "crawlidle", left = Seq((1, 13)), right = Seq((1, 14)), duration = 1.0, loop = false)
  case object CrawlWalk extends CharacterAnimation(value = "crawlwalk", left = Seq((1, 13), (2, 13), (3, 13), (4, 13)), right = Seq((1, 14), (2, 14), (3, 14), (4, 14)), duration = 0.16, loop = true)
  case object Crouch extends CharacterAnimation(value = "crouch", left = Seq((10, 5)), right = Seq((10, 6)), duration = 1.0, loop = false)
  case object CrouchHold extends CharacterAnimation(value = "crouchhold", left = Seq((7, 5)), right = Seq((7, 5)), duration = 1.0, loop = false)
  case object CrouchHoldWalk extends CharacterAnimation(value = "crouchholdwalk", left = Seq((8, 5), (9, 5)), right = Seq((8, 5), (9, 5)), duration = 0.16, loop = true)
  case object CrouchWalk extends CharacterAnimation(value = "crouchwalk", left = Seq((9, 1), (10, 1)), right = Seq((9, 1), (10, 1)), duration = 0.16, loop = true)
  case object Dance extends CharacterAnimation(value = "dance", left = Seq((4, 9), (12, 7), (12, 8), (4, 10), (8, 6)), right = Seq((4, 9), (12, 7), (12, 8), (4, 10), (8, 6)), duration = 0.2, loop = true)
  case object Dead extends CharacterAnimation(value = "dead", left = Seq((6, 3)), right = Seq((6, 4)), duration = 1.0, loop = false)
  case object Depressed extends CharacterAnimation(value = "depressed", left = Seq((7, 1)), right = Seq((7, 2)), duration = 1.0, loop = false)
  case object Dig extends CharacterAnimation(value = "dig", left = Seq((9, 13), (10, 13)), right = Seq((9, 14), (10, 14)), duration = 0.16, loop = true)
  case object DigIdle extends CharacterAnimation(value = "digidle", left = Seq((9, 13)), right = Seq((9, 14)), duration = 1.0, loop = false)
  case object DigThrow extends CharacterAnimation(value = "digthrow", left = Seq((11, 13)), right = Seq((11, 14)), duration = 0.16, loop = true)
  case object Drop extends CharacterAnimation(value = "drop", left = Seq((7, 7)), right = Seq((7, 8)), duration = 1.0, loop = false)
  case object DropJump extends CharacterAnimation(value = "dropjump", left = Seq((12, 7)), right = Seq((12, 8)), duration = 1.0, loop = false)
  case object DropWalk extends CharacterAnimation(value = "dropwalk", left = Seq((8, 7), (9, 7)), right = Seq((8, 8), (9, 8)), duration = 0.16, loop = true)
  case object Flyin extends CharacterAnimation(value = "flyin", left = Seq((12, 5)), right = Seq((12, 5)), duration = 1.0, loop = false)
  case object Gaze extends CharacterAnimation(value = "gaze", left = Seq((6, 1)), right = Seq((6, 2)), duration = 1.0, loop = false)
  case object GazeHold extends CharacterAnimation(value = "gazehold", left = Seq((7, 6)), right = Seq((7, 6)), duration = 1.0, loop = false)
  case object GazeHoldWalk extends CharacterAnimation(value = "gazeholdwalk", left = Seq((8, 6), (9, 6)), right = Seq((8, 6), (9, 6)), duration = 0.16, loop = true)
  case object GazeIdle extends CharacterAnimation(value = "gazeidle", left = Seq((8, 2)), right = Seq((8, 2)), duration = 1.0, loop = false)
  case object GazeWalk extends CharacterAnimation(value = "gazewalk", left = Seq((9, 2), (10, 2)), right = Seq((9, 2), (10, 2)), duration = 0.16, loop = true)
  case object Hold extends CharacterAnimation(value = "hold", left = Seq((1, 5)), right = Seq((1, 6)), duration = 1.0, loop = false)
  case object HoldJump extends CharacterAnimation(value = "holdjump", left = Seq((6, 5)), right = Seq((6, 6)), duration = 1.0, loop = false)
  case object HoldWalk extends CharacterAnimation(value = "holdwalk", left = Seq((2, 5), (3, 5)), right = Seq((2, 6), (3, 6)), duration = 0.16, loop = true)
  case object Hurt extends CharacterAnimation(value = "hurt", left = Seq((4, 3)), right = Seq((4, 4)), duration = 1.0, loop = false)
  case object Idle extends CharacterAnimation(value = "idle", left = Seq((1, 1)), right = Seq((1, 2)), duration = 1.0, loop = false)
  case object Interact extends CharacterAnimation(value = "interact", left = Seq((11, 3), (12, 3)), right = Seq((11, 4), (12, 4)), duration = 0.16, loop = false)
  case object Jump extends CharacterAnimation(value = "jump", left = Seq((1, 3)), right = Seq((1, 4)), duration = 1.0, loop = false)
  case object Kick extends CharacterAnimation(value = "kick", left = Seq((9, 3)), right = Seq((9, 4)), duration = 1.0, loop = false)
  case object Kneel extends CharacterAnimation(value = "kneel", left = Seq((11, 5)), right = Seq((11, 6)), duration = 1.0, loop = false)
  case object LaserPistol extends CharacterAnimation(value = "laserpistol", left = Seq((9, 9)), right = Seq((9, 10)), duration = 0.12, loop = true)
  case object LaserPistolJump extends CharacterAnimation(value = "laserpistoljump", left = Seq((12, 9)), right = Seq((12, 10)), duration = 0.12, loop = true)
  case object LaserPistolWalk extends CharacterAnimation(value = "laserpistolwalk", left = Seq((10, 9), (11, 9)), right = Seq((10, 10), (11, 10)), duration = 0.12, loop = true)
  case object Profile extends CharacterAnimation(value = "profile", left = Seq((11, 1)), right = Seq((11, 2)), duration = 1.0, loop = false)
  case object ProfileAway extends CharacterAnimation(value = "profileaway", left = Seq((12, 1)), right = Seq((12, 2)), duration = 1.0, loop = false)
  case object Pull extends CharacterAnimation(value = "pull", left = Seq((5, 15), (6, 15), (7, 15), (6, 15)), right = Seq((5, 16), (6, 16), (7, 16), (6, 16)), duration = 0.16, loop = true)
  case object Punch extends CharacterAnimation(value = "punch", left = Seq((10, 3)), right = Seq((10, 4)), duration = 1.0, loop = false)
  case object Push extends CharacterAnimation(value = "push", left = Seq((1, 15), (2, 15), (3, 15), (2, 15)), right = Seq((1, 16), (2, 16), (3, 16), (2, 16)), duration = 0.16, loop = true)
  case object Rest extends CharacterAnimation(value = "rest", left = Seq((4, 13)), right = Seq((4, 14)), duration = 1.0, loop = false)
  case object ShootArrow extends CharacterAnimation(value = "shootarrow", left = Seq((1, 11), (2, 11), (3, 11), (4, 11)), right = Seq((1, 12), (2, 12), (3, 12), (4, 12)), duration = 0.12, loop = true)
  case object ShootArrowJump extends CharacterAnimation(value = "shootarrowjump", left = Seq((9, 11), (10, 11), (11, 11), (12, 11)), right = Seq((9, 12), (10, 12), (11, 12), (12, 12)), duration = 0.12, loop = true)
  case object ShootArrowWalk extends CharacterAnimation(value = "shootarrowwalk", left = Seq((5, 11), (6, 11), (7, 11), (8, 11)), right = Seq((5, 12), (6, 12), (7, 12), (8, 12)), duration = 0.12, loop = true)
  case object Slide extends CharacterAnimation(value = "slide", left = Seq((8, 3)), right = Seq((8, 4)), duration = 1.0, loop = false)
  case object Throw extends CharacterAnimation(value = "throw", left = Seq((1, 7)), right = Seq((1, 8)), duration = 1.0, loop = false)
  case object ThrowJump extends CharacterAnimation(value = "throwjump", left = Seq((6, 7)), right = Seq((6, 8)), duration = 1.0, loop = false)
  case object ThrowWalk extends CharacterAnimation(value = "throwwalk", left = Seq((2, 7), (3, 7)), right = Seq((2, 8), (3, 8)), duration = 0.16, loop = true)
  case object Towards extends CharacterAnimation(value = "towards", left = Seq((8, 1)), right = Seq((8, 1)), duration = 1.0, loop = false)
  case object Walk extends CharacterAnimation(value = "walk", left = Seq((2, 1), (3, 1), (4, 1), (3, 1)), right = Seq((2, 2), (3, 2), (4, 2), (3, 2)), duration = 0.16, loop = true)
  case object Warp extends CharacterAnimation(value = "warp", left = Seq((1, 1), (2, 1), (3, 1), (4, 1)), right = Seq((1, 1), (2, 1), (3, 1), (4, 1)), duration = 0.08, loop = false)
  case object WieldAction extends CharacterAnimation(value = "wieldaction", left = Seq((2, 9), (10, 9), (6, 9), (2, 9)), right = Seq((2, 10), (10, 10), (6, 10), (2, 10)), duration = 0.11, loop = false)
  case object WieldAction2 extends CharacterAnimation(value = "wieldaction2", left = Seq((2, 9), (10, 9), (6, 9), (2, 9)), right = Seq((2, 10), (10, 10), (6, 10), (2, 10)), duration = 0.18, loop = false)
  case object WieldAction3 extends CharacterAnimation(value = "wieldaction3", left = Seq((2, 9), (10, 9), (6, 9), (2, 9)), right = Seq((2, 10), (10, 10), (6, 10), (2, 10)), duration = 0.2, loop = false)
  case object WieldAction4 extends CharacterAnimation(value = "wieldaction4", left = Seq((2, 9), (10, 9), (6, 9), (2, 9)), right = Seq((2, 10), (10, 10), (6, 10), (2, 10)), duration = 0.15, loop = false)
  case object WieldAction5 extends CharacterAnimation(value = "wieldaction5", left = Seq((2, 9), (10, 9), (6, 9), (2, 9)), right = Seq((2, 10), (10, 10), (6, 10), (2, 10)), duration = 0.07, loop = false)
  case object WieldIdle extends CharacterAnimation(value = "wieldidle", left = Seq((9, 9)), right = Seq((9, 10)), duration = 1.0, loop = false)
  case object WieldJump extends CharacterAnimation(value = "wieldjump", left = Seq((4, 9)), right = Seq((4, 10)), duration = 1.0, loop = false)
  case object WieldWalk extends CharacterAnimation(value = "wieldwalk", left = Seq((2, 9), (3, 9)), right = Seq((2, 10), (3, 10)), duration = 0.16, loop = true)

  override val values = findValues
}