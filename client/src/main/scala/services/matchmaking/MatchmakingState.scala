package services.matchmaking

import java.util.UUID

import com.definitelyscala.phaserce.Game
import models.RequestMessage.StartGame
import models.asset.Asset
import models.font.Font
import models.input.{MenuAction, PointerAction}
import models.options.GameOptions
import services.audio.SoundEffectService
import services.input.InputService
import services.socket.{NetworkMessage, UserManager}
import services.state.{GameState, LoadingState}

object MatchmakingState {
  val assets = Font.assets ++ SoundEffectService.menuAssets ++ Seq(Asset.music("daybreak"))

  def load(phaser: Game, inputService: InputService, debug: Boolean, skipToHost: Boolean = false) = new LoadingState(
    next = new MatchmakingState(phaser = phaser, inputService = inputService, debug = debug, skipToHost = skipToHost), phaser = phaser, assets = assets
  )
}

class MatchmakingState(phaser: Game, inputService: InputService, debug: Boolean, skipToHost: Boolean) extends GameState("test", phaser) {
  override def create(game: Game) = {
    inputService.setPointerEventCallback(Some(pointerAct))
    inputService.menuHandler.setCallback(Some(x => onMenuAction(x)))
    resize(game.width, game.height)
    UserManager.awaitSystemReady(() => {
      NetworkMessage.sendMessage(StartGame(UUID.randomUUID, GameOptions(maxPlayers = 64, offline = false, debug = debug)))
    })
  }

  private[this] def pointerAct(pointerAction: PointerAction) = util.Logging.info(s"Matchmaking pointer action [$pointerAction]")

  private[this] def onMenuAction(acts: Seq[MenuAction]) = util.Logging.info(s"Matchmaking menu actions [${acts.mkString(", ")}]")
}
