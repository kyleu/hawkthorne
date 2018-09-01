package services.map

import com.definitelyscala.phaserce.Game
import models.data.map.TiledMap
import models.node.Node
import models.options.GameOptions
import services.collision.CollisionService

object MapNodeCache {
  private[this] val cache = collection.mutable.HashMap.empty[TiledMap, (Seq[Node], CollisionService.Collision)]

  def get(game: Game, options: GameOptions) = cache.getOrElseUpdate(options.map, load(game, options))

  def load(game: Game, options: GameOptions) = {
    MapNodeParser.parse(options.map, game.cache.getTilemapData("map." + options.map.value))
  }
}
