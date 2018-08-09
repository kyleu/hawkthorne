package services.overworld

import com.definitelyscala.phaserce.Point

object OverworldZones {
  case class Zone(
      key: String, xCoord: Int, yCoord: Int, name: String = "", level: Option[String] = None, bypass: Seq[(String, String)] = Nil, visited: Boolean = false,
      up: Option[String] = None, right: Option[String] = None, down: Option[String] = None, left: Option[String] = None
  ) {
    val x = (xCoord * 12) + 10
    val y = (yCoord * 12) - 24
    val point = new Point(x.toDouble, y.toDouble)
    def tgtForDir(dir: String) = dir match {
      case "up" => up
      case "right" => right
      case "down" => down
      case "left" => left
    }
  }

  val zones = Seq(
    Zone(key = "greendale", xCoord = 66, yCoord = 100, name = "Greendale", level = Some("studyroom"), visited = true, right = Some("forest_2")),
    Zone(key = "forest_2", xCoord = 91, yCoord = 100, name = "Forest", level = Some("forest"), up = Some("forest_3"), left = Some("greendale")),
    Zone(key = "forest_3", xCoord = 91, yCoord = 89, name = "Forest", level = Some("forest-2"), up = Some("town_1"), down = Some("forest_2")),
    Zone(key = "town_1", xCoord = 91, yCoord = 76, name = "Town", level = Some("town"), down = Some("forest_3"), left = Some("town_2")),
    Zone(
      key = "town_2", xCoord = 71, yCoord = 76, name = "New Abedtown", level = Some("new-abedtown"), visited = true,
      right = Some("town_1"), left = Some("vforest_1")
    ),
    Zone(key = "vforest_1", xCoord = 51, yCoord = 76, name = "Village Forest", level = Some("treeline"), right = Some("town_2"), left = Some("vforest_2")),
    Zone(
      key = "vforest_2", xCoord = 37, yCoord = 76, name = "Village Forest", level = Some("village-forest-2"),
      up = Some("valley_1"), right = Some("vforest_1")
    ),
    Zone(key = "valley_1", xCoord = 37, yCoord = 45, name = "Valley of Laziness", level = Some("valley"), down = Some("vforest_2"), right = Some("valley_2")),
    Zone(
      key = "valley_2", xCoord = 66, yCoord = 45, name = "Valley of Laziness", bypass = Seq("right" -> "up", "down" -> "left"),
      up = Some("valley_3"), left = Some("valley_1")
    ),
    Zone(
      key = "valley_3", xCoord = 66, yCoord = 36, name = "Valley of Laziness", bypass = Seq("up" -> "right", "left" -> "down"),
      down = Some("valley_2"), right = Some("island_1")
    ),
    Zone(
      key = "island_1", xCoord = 93, yCoord = 36, name = "Gay Island", bypass = Seq("right" -> "down", "up" -> "left"),
      down = Some("island_2"), left = Some("valley_3")
    ),
    Zone(key = "island_2", xCoord = 93, yCoord = 56, name = "Gay Island", level = Some("gay-island"), up = Some("island_1"), right = Some("island_3")),
    Zone(
      key = "island_3", xCoord = 109, yCoord = 56, name = "Gay Island", level = Some("gay-island-2"),
      up = Some("island_4"), down = Some("island_5"), left = Some("island_2")
    ),
    Zone(key = "island_4", xCoord = 109, yCoord = 36, bypass = Seq("up" -> "right", "left" -> "down"), down = Some("island_3"), right = Some("forest_4")),
    Zone(key = "forest_4", xCoord = 122, yCoord = 36, up = Some("forest_5"), left = Some("island_4")),
    Zone(key = "forest_5", xCoord = 122, yCoord = 22, down = Some("forest_4")),
    Zone(key = "island_5", xCoord = 109, yCoord = 68, name = "Gay Island", level = Some("gay-island-4"), up = Some("island_3"), right = Some("ferry")),
    Zone(
      key = "ferry", xCoord = 163, yCoord = 68, name = "Free Ride Ferry", bypass = Seq("down" -> "left", "right" -> "up"),
      up = Some("caverns"), left = Some("island_5")
    ),
    Zone(key = "caverns", xCoord = 163, yCoord = 44, name = "Black Caverns", level = Some("black-caverns"), down = Some("ferry"))
  )

  val byKey = zones.map(z => z.key -> z).toMap

  val sparkleCoords = Seq(
    1028 -> 456, 1089 -> 442, 1403 -> 440, 1348 -> 591, 1390 -> 633, 1273 -> 698, 1160 -> 657, 1088 -> 702, 1048 -> 665, 1072 -> 604,
    1060 -> 552, 1104 -> 548, 1172 -> 555, 1199 -> 727, 1263 -> 735, 1313 -> 505, 1337 -> 459, 1358 -> 429, 1270 -> 617, 1289 -> 571,
    1123 -> 505, 1124 -> 472, 1359 -> 709, 1389 -> 555, 1376 -> 677, 1057 -> 624, 1169 -> 710, 1149 -> 592, 1297 -> 639
  )
}
