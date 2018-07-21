package models.component

import com.definitelyscala.phaserce.{Game, Group, Image}
import services.map.MapService

case class LiquidComponent(
    game: Game, group: Group, override val name: String, key: String, x: Int, y: Int, opacity: Double, width: Int, height: Int
) extends BaseComponent {
  val liquidGroup = new Group(game, group, name)
  liquidGroup.x = x.toDouble
  liquidGroup.y = y.toDouble

  val frameCount = game.cache.getFrameCount(key).toInt / 2

  util.Logging.info(s"Liquid [$name] created at [${width}x$height] with [$frameCount] frames.")

  val images = (0 until height).flatMap { yIdx =>
    (0 until width).map { xIdx =>
      val nx = xIdx * 24 * MapService.scaleInt
      val ny = yIdx * 24 * MapService.scaleInt
      val nf = if (yIdx == 0) { xIdx % frameCount } else { (xIdx % frameCount) + frameCount }

      val image = new Image(game = game, x = nx.toDouble, y = ny.toDouble, key = key, frame = nf)
      image.name = name
      image.scale = MapService.scalePoint
      image.alpha = opacity
      liquidGroup.add(image)
      image
    }
  }

  override def update(deltaMs: Double) = {

  }
}
