package services.state

import com.definitelyscala.datgui.{GUI, GUIParams}
import com.definitelyscala.phaserce.{Game, Point}
import models.data.map.TiledMap
import models.phaser.{NodeLoader, SplashComponent}
import models.player.{Player, PlayerSprite}
import services.input.{InputHandler, InputService}
import services.map.MapService
import util.JavaScriptUtils

import scala.scalajs.js

object GameplayState {
  def load(phaser: Game, map: TiledMap, player: Player) = new LoadingState(
    next = new GameplayState(phaser, map, player),
    phaser = phaser,
    assets = LoadingState.Assets(
      audio = Seq(s"music.${map.soundtrack}" -> s"audio/music/${map.soundtrack}.ogg"),
      images = map.images.map(i => i -> s"images/tileset/$i.png"),
      spritesheets = Seq(player.spritesheet),
      tilemaps = Seq(s"map.${map.value}" -> s"maps/${map.value}.json")
    )
  )
}

class GameplayState(phaser: Game, map: TiledMap, player: Player) extends GameState(map.value, phaser) {
  private[this] var mapService: Option[MapService] = None
  private[this] var playerSprite: Option[PlayerSprite] = None
  private[this] var input: Option[InputService] = None
  private[this] var started = false
  private[this] var elapsed = 0.0

  private[this] lazy val splash = new SplashComponent(game)

  override def create(game: Game) = {
    println("Hawkthore started.")
    val mapSvc = new MapService(game, map, playMusic = false)
    mapService = Some(mapSvc)

    playerSprite = Some(new PlayerSprite(game, mapSvc.group, player, 100, 100))
    input = Some(new InputService(phaser, playerSprite.get.sprite, new InputHandler()))

    splash.show()

    new NodeLoader(game, mapSvc.group).load(nodes = mapSvc.nodes, onComplete = sprites => {
      splash.hide()
      playerSprite.get.sprite.bringToTop()
      started = true
    })

    initGui(playerSprite.get)
  }

  override def update(game: Game) = if (started) {
    val dt = game.time.physicsElapsed
    elapsed += dt

    input.foreach(_.update(dt))
    playerSprite.get.update(dt)
  }

  private[this] def initGui(playerSprite: PlayerSprite) = {
    val params = JavaScriptUtils.as[GUIParams](scalajs.js.Dynamic.literal())
    val gui = new GUI(params)
    val f = gui.addFolder("Player 0")

    val methods = js.Dynamic.literal(
      "animation" -> "No Animation"
    )

    val opt = f.add(methods, "animation", items = js.Array("No Animation" +: PlayerSprite.animations.keys.toSeq.sorted: _*))
    opt.asInstanceOf[js.Dynamic].__onFinishChange = (v: js.Any) => playerSprite.setAnimation(Some(v.toString))
  }
}
