package services.state

import com.definitelyscala.phaserce.Game
import models.asset._
import models.data.map.TiledMap
import models.player.Player
import services.GameplayService

object GameplayState {
  def load(phaser: Game, map: TiledMap, player: Player) = new LoadingState(
    next = new GameplayState(phaser, map, player),
    phaser = phaser,
    assets = Seq(
      Asset.Audio(s"music.${map.soundtrack}", s"audio/music/${map.soundtrack}.ogg"),
      Asset.Spritesheet(player.spritesheet._1, player.spritesheet._2, player.spritesheet._3, player.spritesheet._4),
      Asset.Tilemap(s"map.${map.value}", s"maps/${map.value}.json")
    ) ++ map.images.map(i => Asset.Image(i, s"images/tileset/$i.png"))
  )
}

class GameplayState(phaser: Game, map: TiledMap, player: Player) extends GameState(map.value, phaser) {
  private[this] var svc: Option[GameplayService] = None
  private[this] def service = svc.getOrElse(throw new IllegalStateException("Not initialized"))

  override def create(game: Game) = {
    svc = Some(new GameplayService(game, map, player))
  }

  override def update(game: Game) = service.update()
}
