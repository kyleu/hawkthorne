/* Generated File */
package models.analytics

import enumeratum.values.{StringCirceEnum, StringEnum, StringEnumEntry}

sealed abstract class AnalyticsActionType(override val value: String) extends StringEnumEntry

object AnalyticsActionType extends StringEnum[AnalyticsActionType] with StringCirceEnum[AnalyticsActionType] {
  case object Connect extends AnalyticsActionType("connect")
  case object IntroStart extends AnalyticsActionType("intro.start")
  case object IntroSkip extends AnalyticsActionType("intro.skip")
  case object Menu extends AnalyticsActionType("menu")
  case object OptionsSet extends AnalyticsActionType("options.set")
  case object GameStart extends AnalyticsActionType("game.start")
  case object GamePause extends AnalyticsActionType("game.pause")
  case object GameResume extends AnalyticsActionType("game.resume")
  case object GameComplete extends AnalyticsActionType("game.complete")
  case object GameCheckpoint extends AnalyticsActionType("game.checkpoint")
  case object Error extends AnalyticsActionType("error")
  case object Unknown extends AnalyticsActionType("unknown")
  case object Debug extends AnalyticsActionType("debug")

  override val values = findValues
}
