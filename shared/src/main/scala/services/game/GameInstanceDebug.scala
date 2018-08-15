package services.game

import java.util.UUID

import models.game.GameStage
import models.options.GameOptions
import models.player.Player

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

  def debugString(gameId: UUID, options: GameOptions, records: Seq[GameInstance.PlayerRecord], stage: GameStage, elapsed: Double) = {
    import util.JsonSerializers._

    val playersString = records.map { record =>
      val p = record.player
      val detail = s"Playing as [${p.templateKey}/${p.costumeKey}] (${if (p.attributes.connected) { "Connected" } else { "Disconnected" }})"
      s"""${p.id}: { x: ${record.x}, y: ${record.y}, detail: "$detail" }"""
    }.mkString("\n    ")

    s"""$gameId: {
      |  options: ${options.asJson.noSpaces},
      |  players: [
      |    $playersString
      |  ],
      |  objects: ${stage.objects.size}
      |}
    """.stripMargin.trim
  }
}
