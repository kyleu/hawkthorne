package models.component

import com.definitelyscala.phaserce.{Game, Group, Image}

final case class Liquid(
    override val game: Game,
    group: Group,
    override val name: String,
    key: String,
    override val x: Int,
    override val y: Int,
    opacity: Double,
    speed: Double,
    width: Int,
    height: Int
) extends BaseComponent {
  private[this] var currFrameTime = 0.0

  val liquidGroup = new Group(game, group, name)
  liquidGroup.name = s"liquid.$name"
  liquidGroup.x = x.toDouble
  liquidGroup.y = y.toDouble

  val frameCount = game.cache.getFrameCount(key).toInt / 2

  val images = (0 until height).flatMap { yIdx =>
    (0 until width).map { xIdx =>
      // val nf = if (yIdx == 0) { Random.nextInt(frameCount) } else { Random.nextInt(frameCount) + frameCount }
      val nf = if (yIdx == 0) { xIdx % frameCount } else { ((xIdx + yIdx) % frameCount) + frameCount }

      val image = new Image(game = game, x = xIdx * 24.0, y = yIdx * 24.0, key = key, frame = nf)
      image.name = s"liquid.$name.$xIdx.$yIdx"
      image.alpha = opacity
      liquidGroup.add(image)
      image
    }
  }

  override def update(deltaMs: Double) = {
    currFrameTime += deltaMs
    if (currFrameTime > speed) {
      currFrameTime = currFrameTime % speed
      images.foreach { i =>
        val currFrame = i.frame.asInstanceOf[Double].toInt
        val buffer = if (currFrame >= frameCount) { frameCount } else { 0 }
        i.frame = ((currFrame + 1) % frameCount) + buffer
      }
    }

  }
}
