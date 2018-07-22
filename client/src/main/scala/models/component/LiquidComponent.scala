package models.component

import com.definitelyscala.phaserce.{Game, Group, Image}

case class LiquidComponent(
    override val game: Game,
    group: Group,
    override val name: String,
    key: String,
    override val x: Int,
    override val y: Int,
    opacity: Double,
    width: Int,
    height: Int
) extends BaseComponent {
  val liquidGroup = new Group(game, group, name)
  liquidGroup.x = x.toDouble
  liquidGroup.y = y.toDouble

  val frameCount = game.cache.getFrameCount(key).toInt / 2

  val images = (0 until height).flatMap { yIdx =>
    (0 until width).map { xIdx =>
      val nf = if (yIdx == 0) { xIdx % frameCount } else { (xIdx % frameCount) + frameCount }

      val image = new Image(game = game, x = xIdx * 24.0, y = yIdx * 24.0, key = key, frame = nf)
      image.name = name
      image.alpha = opacity
      liquidGroup.add(image)
      image
    }
  }

  override def update(deltaMs: Double) = {

  }
}
