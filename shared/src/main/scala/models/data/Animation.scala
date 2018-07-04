/* Generated File */
package models.data

import enumeratum.values.{StringEnum, StringEnumEntry}

sealed abstract class Animation(
    override val value: String
) extends StringEnumEntry

object Animation extends StringEnum[Animation] {
  case object Acquire extends Animation(
    value = "acquire"
  )
  case object Attack extends Animation(
    value = "attack"
  )
  case object Attackjump extends Animation(
    value = "attackjump"
  )
  case object Attackwalk extends Animation(
    value = "attackwalk"
  )
  case object Crawlcrouchwalk extends Animation(
    value = "crawlcrouchwalk"
  )
  case object Crawlgazewalk extends Animation(
    value = "crawlgazewalk"
  )
  case object Crawlidle extends Animation(
    value = "crawlidle"
  )
  case object Crawlwalk extends Animation(
    value = "crawlwalk"
  )
  case object Crouch extends Animation(
    value = "crouch"
  )
  case object Crouchhold extends Animation(
    value = "crouchhold"
  )
  case object Crouchholdwalk extends Animation(
    value = "crouchholdwalk"
  )
  case object Crouchwalk extends Animation(
    value = "crouchwalk"
  )
  case object Dance extends Animation(
    value = "dance"
  )
  case object Dead extends Animation(
    value = "dead"
  )
  case object Depressed extends Animation(
    value = "depressed"
  )
  case object Dig extends Animation(
    value = "dig"
  )
  case object Digidle extends Animation(
    value = "digidle"
  )
  case object Digthrow extends Animation(
    value = "digthrow"
  )
  case object Drop extends Animation(
    value = "drop"
  )
  case object Dropjump extends Animation(
    value = "dropjump"
  )
  case object Dropwalk extends Animation(
    value = "dropwalk"
  )
  case object Flyin extends Animation(
    value = "flyin"
  )
  case object Gaze extends Animation(
    value = "gaze"
  )
  case object Gazehold extends Animation(
    value = "gazehold"
  )
  case object Gazeholdwalk extends Animation(
    value = "gazeholdwalk"
  )
  case object Gazeidle extends Animation(
    value = "gazeidle"
  )
  case object Gazewalk extends Animation(
    value = "gazewalk"
  )
  case object Hold extends Animation(
    value = "hold"
  )
  case object Holdjump extends Animation(
    value = "holdjump"
  )
  case object Holdwalk extends Animation(
    value = "holdwalk"
  )
  case object Hurt extends Animation(
    value = "hurt"
  )
  case object Idle extends Animation(
    value = "idle"
  )
  case object Interact extends Animation(
    value = "interact"
  )
  case object Jump extends Animation(
    value = "jump"
  )
  case object Kick extends Animation(
    value = "kick"
  )
  case object Kneel extends Animation(
    value = "kneel"
  )
  case object Profile extends Animation(
    value = "profile"
  )
  case object Profileaway extends Animation(
    value = "profileaway"
  )
  case object Pull extends Animation(
    value = "pull"
  )
  case object Punch extends Animation(
    value = "punch"
  )
  case object Push extends Animation(
    value = "push"
  )
  case object Shootarrow extends Animation(
    value = "shootarrow"
  )
  case object Shootarrowwalk extends Animation(
    value = "shootarrowwalk"
  )
  case object Shootarrowjump extends Animation(
    value = "shootarrowjump"
  )
  case object Laserpistol extends Animation(
    value = "laserpistol"
  )
  case object Laserpistolwalk extends Animation(
    value = "laserpistolwalk"
  )
  case object Laserpistoljump extends Animation(
    value = "laserpistoljump"
  )
  case object Slide extends Animation(
    value = "slide"
  )
  case object Throw extends Animation(
    value = "throw"
  )
  case object Throwjump extends Animation(
    value = "throwjump"
  )
  case object Throwwalk extends Animation(
    value = "throwwalk"
  )
  case object Towards extends Animation(
    value = "towards"
  )
  case object Walk extends Animation(
    value = "walk"
  )
  case object Warp extends Animation(
    value = "warp"
  )
  case object Wieldaction extends Animation(
    value = "wieldaction"
  )
  case object Wieldaction2 extends Animation(
    value = "wieldaction2"
  )
  case object Wieldaction3 extends Animation(
    value = "wieldaction3"
  )
  case object Wieldaction4 extends Animation(
    value = "wieldaction4"
  )
  case object Wieldaction5 extends Animation(
    value = "wieldaction5"
  )
  case object Wieldidle extends Animation(
    value = "wieldidle"
  )
  case object Wieldjump extends Animation(
    value = "wieldjump"
  )
  case object Rest extends Animation(
    value = "rest"
  )
  case object Wieldwalk extends Animation(
    value = "wieldwalk"
  )

  override val values = findValues
}
