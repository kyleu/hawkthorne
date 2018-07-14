package services

import com.definitelyscala.datgui.{GUI, GUIParams}
import com.definitelyscala.phaserce.Game
import models.data.map.TiledMap
import models.phaser.{NodeLoader, SplashComponent}
import models.player.{Player, PlayerSprite}
import services.input.{InputHandler, InputService}
import services.map.MapService
import util.{DatGuiUtils, JavaScriptUtils, Logging}

import scala.util.Random

class GameplayService(game: Game, map: TiledMap, player: Player) {
  private[this] var started = false
  private[this] var elapsed = 0.0

  private[this] val splash = new SplashComponent(game)

  private[this] val mapService = new MapService(game, map, playMusic = false)

  private[this] val playerSprite = new PlayerSprite(game, mapService.group, player, 100, 100)
  private[this] val input = new InputService(game, playerSprite.sprite, new InputHandler(IndexedSeq(playerSprite)))
  private[this] val loader = new NodeLoader(game, mapService.group).load(nodes = mapService.nodes, onComplete = sprites => {
    splash.hide()
    playerSprite.sprite.bringToTop()
    started = true
  })

  splash.show()
  initGui()
  println("Hawkthore started.")

  def update() = if (started) {
    val dt = game.time.physicsElapsed
    elapsed += dt

    input.update(dt)
    playerSprite.update(dt)
  }

  private[this] def initGui() = {
    val params = JavaScriptUtils.as[GUIParams](scalajs.js.Dynamic.literal())
    val gui = new GUI(params)
    val f = gui.addFolder("Player 0")
    val anims = PlayerSprite.animations.keys.toSeq.sorted
    DatGuiUtils.addChoices(f, "Animation", "No Animation", "No Animation" +: anims, v => playerSprite.setAnimation(Some(v)))
    DatGuiUtils.addFunction(f, "Random Anim", () => {
      val anim = anims(Random.nextInt(anims.size))
      Logging.info(s"Random animation: [$anim]")
      playerSprite.setAnimation(Some(anim))
    })
  }
}
