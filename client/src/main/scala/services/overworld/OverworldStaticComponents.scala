package services.overworld

import com.definitelyscala.phaserce.{Game, Group}
import models.animation.Animation
import models.component.{AnimatedSprite, StaticSprite}

class OverworldStaticComponents(game: Game, group: Group) {
  (0 until 4).foreach { i =>
    val top = StaticSprite(game, group, s"overworld.world.$i", s"overworld.world_0${i + 1}")
    top.setPositionInt(i * top.sprite.width.toInt, 0)
    val bottom = StaticSprite(game, group, s"overworld.world.${i + 4}", s"overworld.world_0${i + 5}")
    bottom.setPositionInt(i * top.sprite.width.toInt, top.sprite.height.toInt)
  }

  private[this] val freeRideFerry = StaticSprite(game, group, "overworld.ferry", "overworld.free_ride_ferry")
  freeRideFerry.setPositionInt(1685, 680)

  private[this] val sparkleAnim = Animation(id = "sparkle", frames = 0 until 8, delay = 0.2, loop = true)
  sparkleAnim.setJitter()

  private[this] val sparkles = OverworldZones.sparkleCoords.zipWithIndex.map { coord =>
    val s = AnimatedSprite.single(game, group, s"overworld.sparkle.${coord._2}", "overworld.sparkle", sparkleAnim.newCopy)
    s.setPositionInt(coord._1._1, coord._1._2)
    s
  }

  val flags = OverworldZones.zones.filter(_.bypass.isEmpty).map { zone =>
    val s = StaticSprite(game, group, s"overworld.flag.${zone.key}", "overworld.flag")
    s.setPositionInt(zone.x, zone.y)
    s
  }

  def addOverlays() = Seq(0, 1, 4, 5).map { i =>
    val s = StaticSprite(game, group, s"overworld.overlay.$i", s"overworld.world_overlay_0${i + 1}")
    s.setPosition((i % 4) * s.sprite.width, if (i < 4) { 0 } else { s.sprite.height })
    s
  }

  def update(dt: Double) = sparkles.foreach(_.update(dt))
}
