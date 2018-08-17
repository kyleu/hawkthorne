package services.game

import java.util.UUID

import models.game.GameStage
import models.options.GameOptions
import models.player.PlayerRecord

object GameInstanceDebug {
  private[this] var isDebug = true

  private[this] var logger: Option[String => Unit] = None
  def log(s: String) = logger.getOrElse(throw new IllegalStateException("Logger not initialized."))(s)
  def debug(s: => String) = if (isDebug) { logger.getOrElse(throw new IllegalStateException("Logger not initialized."))(s) }

  private[this] var notification: Option[String => Unit] = None
  protected[this] def notify(s: String) = notification.getOrElse(throw new IllegalStateException("Notifications not initialized."))(s)

  def setCallbacks(showDebug: Boolean, log: String => Unit, notify: String => Unit) = {
    isDebug = showDebug
    logger = Some(log)
    notification = Some(notify)
  }

  def debugString(gameId: UUID, options: GameOptions, records: Seq[PlayerRecord], stage: GameStage, elapsed: Double) = {
    val playersString = records.map { record =>
      val p = record.player
      s"""${p.id}: { x: ${record.x}, y: ${record.y}, t: "${p.templateKey}/${p.costumeKey}, c: ${p.attributes.connected}" }"""
    }.mkString("\n    ")

    s"""$gameId: {
      |  options: ${util.JsonSerializers.serialize(options).noSpaces},
      |  players: [
      |    $playersString
      |  ],
      |  objects: ${stage.objects.size}
      |}
    """.stripMargin.trim
  }
}
