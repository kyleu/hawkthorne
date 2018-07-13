package services.state

import com.definitelyscala.phaserce.Game
import models.data.map.TiledMap
import models.player.{Player, PlayerSprite}
import services.input.{InputHandler, InputService}
import services.map.MapService

object GameplayState {
  def load(phaser: Game, map: TiledMap, player: Player) = new LoadingState(
    next = new GameplayState(phaser, map, player),
    phaser = phaser,
    audio = Seq(s"music.${map.soundtrack}" -> s"audio/music/${map.soundtrack}.ogg"),
    images = map.images.map(i => i -> s"images/tileset/$i.png"),
    spritesheets = Seq(player.spritesheet),
    tilemaps = Seq(s"map.${map.value}" -> s"maps/${map.value}.json")
  )
}

class GameplayState(phaser: Game, map: TiledMap, player: Player) extends GameState(map.value, phaser) {
  private[this] var mapService: Option[MapService] = None
  private[this] var input: Option[InputService] = None

  override def create(game: Game) = {
    println("Hawkthore started.")
    mapService = Some(new MapService(game, map, playMusic = false))
    val playerSprite = new PlayerSprite(player, game.width.toInt / 2, game.height.toInt / 2, game)
    input = Some(new InputService(phaser, playerSprite.sprite, new InputHandler()))
  }

  override def update(game: Game) = {
    input.foreach(_.update(0L))
  }
}
