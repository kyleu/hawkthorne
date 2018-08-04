package services.map

import com.definitelyscala.phaserce.{Game, Group}
import models.component.StaticSprite
import util.PhaserUtils

object OverworldMap {

  case class Zone(
      x: Int, y: Int, up: Option[String] = None, right: Option[String] = None, down: Option[String] = None, left: Option[String] = None,
      name: String, level: Option[String] = None, bypass: Seq[(String, String)] = Nil, visited: Boolean = false
  )

  val zones = Map(
    "greendale" -> Zone(x = 66, y = 100, right = Some("forest_2"), name = "Greendale", level = Some("studyroom"), visited = true),
    "forest_2" -> Zone(x = 91, y = 100, up = Some("forest_3"), left = Some("greendale"), name = "Forest", level = Some("forest")),
    "forest_3" -> Zone(x = 91, y = 89, up = Some("town_1"), down = Some("forest_2"), name = "Forest", level = Some("forest-2")),
    "town_1" -> Zone(x = 91, y = 76, down = Some("forest_3"), left = Some("town_2"), name = "Town", level = Some("town")),
    "town_2" -> Zone(x = 71, y = 76, right = Some("town_1"), left = Some("vforest_1"), name = "New Abedtown", level = Some("new-abedtown"), visited = true),
    "vforest_1" -> Zone(x = 51, y = 76, right = Some("town_2"), left = Some("vforest_2"), name = "Village Forest", level = Some("treeline")),
    "vforest_2" -> Zone(x = 37, y = 76, up = Some("valley_1"), right = Some("vforest_1"), name = "Village Forest", level = Some("village-forest-2")),
    "valley_1" -> Zone(x = 37, y = 45, down = Some("vforest_2"), right = Some("valley_2"), name = "Valley of Laziness", level = Some("valley")),
    "valley_2" -> Zone(x = 66, y = 45, up = Some("valley_3"), left = Some("valley_1"), name = "Valley of Laziness", bypass = Seq("right" -> "up", "down" -> "left")),
    "valley_3" -> Zone(x = 66, y = 36, down = Some("valley_2"), right = Some("island_1"), name = "Valley of Laziness", bypass = Seq("up" -> "right", "left" -> "down")),
    "island_1" -> Zone(x = 93, y = 36, down = Some("island_2"), left = Some("valley_3"), name = "Gay Island", bypass = Seq("right" -> "down", "up" -> "left")),
    "island_2" -> Zone(x = 93, y = 56, up = Some("island_1"), right = Some("island_3"), name = "Gay Island", level = Some("gay-island")),
    "island_3" -> Zone(x = 109, y = 56, up = Some("island_4"), down = Some("island_5"), left = Some("island_2"), name = "Gay Island", level = Some("gay-island-2")),
    "island_4" -> Zone(x = 109, y = 36, down = Some("island_3"), right = Some("forest_4"), name = "", bypass = Seq("up" -> "right", "left" -> "down")),
    "forest_4" -> Zone(x = 122, y = 36, up = Some("forest_5"), left = Some("island_4"), name = ""),
    "forest_5" -> Zone(x = 122, y = 22, down = Some("forest_4"), name = ""),
    "island_5" -> Zone(x = 109, y = 68, up = Some("island_3"), right = Some("ferry"), name = "Gay Island", level = Some("gay-island-4")),
    "ferry" -> Zone(x = 163, y = 68, up = Some("caverns"), left = Some("island_5"), name = "Free Ride Ferry", bypass = Seq("down" -> "left", "right" -> "up")),
    "caverns" -> Zone(x = 163, y = 44, down = Some("ferry"), name = "Black Caverns", level = Some("black-caverns"))
  )
}

case class OverworldMap(game: Game) {
  val group = new Group(game, name = "overworld")

  val topRow = (0 until 4).map { i =>
    val s = StaticSprite(game, group, s"overworld.world.$i", s"overworld.world_0${i + 1}")
    s.setPositionInt(i * s.sprite.width.toInt, 0)
    s
  }
  val bottomRow = (0 until 4).map { i =>
    val s = StaticSprite(game, group, s"overworld.world.${i + 4}", s"overworld.world_0${i + 5}")
    s.setPositionInt(i * s.sprite.width.toInt, s.sprite.height.toInt)
    s
  }

  val backdrop = PhaserUtils.makeBackdrop(game = game, width = group.width, height = group.height, color = OverworldMapAssets.bgColor)
  group.add(backdrop)
  backdrop.sendToBack()

  val overlays = Seq(1, 2, 5, 6).map { i =>
    val s = StaticSprite(game, group, s"overworld.overlay.${i - 1}", s"overworld.world_overlay_0$i")
    i match {
      case _ => s.setPositionInt(0, 0)
    }
    s
  }

  val board = StaticSprite(game, group, "overworld.titleboard", "overworld.titleboard")
  val flag = StaticSprite(game, group, "overworld.flag", "overworld.flag")

  val freeRideFerry = StaticSprite(game, group, "overworld.ferry", "overworld.free_ride_ferry")
  freeRideFerry.setPositionInt(1685, 680)

  def update(dt: Double) = {

  }
}
