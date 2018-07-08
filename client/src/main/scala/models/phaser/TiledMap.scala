package models.phaser

import com.definitelyscala.phaserce.Game
import enumeratum.values.{StringCirceEnum, StringEnum, StringEnumEntry}

sealed abstract class TiledMap(override val value: String, val images: Seq[String], val layers: Seq[String]) extends StringEnumEntry {
  val tilemap = "map.test" -> s"json/$value.json"
  val imageKeys = images.map(i => i -> s"images/tileset/$i.png")

  def create(phaser: Game) = {
    val map = phaser.add.tilemap("map.test") // s"map.${value.replaceAllLiterally("-", ".")}")
    images.foreach(i => map.addTilesetImage(i))
    map -> layers.reverse.map(l => map.createLayer(l))
  }
}

object TiledMap extends StringEnum[TiledMap] with StringCirceEnum[TiledMap] {
  case object AdminHallway extends TiledMap(value = "admin-hallway", images = Seq("collisions", "greendale-hallways"), layers = Seq(
    "nodes", "collision", "Tile Layer 1", "Tile Layer 2", "Tile Layer 3"
  ))
  case object GayIsland extends TiledMap(value = "gay-island", images = Seq("collisions", "gay-island"), layers = Seq(
    "nodes", "collision", "leaves2", "leaves", "trees", "grass", "floor", "filler", "bg_trees", "bg_leaves", "ocean", "clouds",
    "big_penis", "big_penis2", "big_penis3", "rainbows1", "clouds3", "little_penis", "little_penis2", "rainbows2", "sky"
  ))
  case object WomensBathroom extends TiledMap(value = "womens-bathroom", images = Seq("bathroom", "collisions"), layers = Seq(
    "collision", "fievel", "Wall Features 3", "Wall Features 2", "Wall Features 1", "Background"
  ))

  override val values = findValues
}
