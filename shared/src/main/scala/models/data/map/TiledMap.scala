/* Generated File */
package models.data.map

import enumeratum.values.{StringCirceEnum, StringEnum, StringEnumEntry}

sealed abstract class TiledMap(
    override val value: String, val title: String, val soundtrack: Option[String], val color: String, val images: Seq[String], val layers: Seq[String]
) extends StringEnumEntry

object TiledMap extends StringEnum[TiledMap] with StringCirceEnum[TiledMap] {
  case object AbedCastleInterior extends TiledMap(value = "abed-castle-interior", title = "abed-castle-interior", soundtrack = Some("abeds-castle"), color = "#000000", images = Seq("abed-castle-interior", "collisions"), layers = Seq(
    "Tile Layer 1", "Tile Layer 2", "Tile Layer 3", "foreground", "foreground 2", "collision", "nodes"
  ))
  case object AbedCave extends TiledMap(value = "abed-cave", title = "abed-cave", soundtrack = Some("abeds-castle"), color = "#000000", images = Seq("abed-cave", "collisions"), layers = Seq(
    "Background", "Posts", "Midground", "Foreground", "Walkway", "WalkwayOverlay", "collision", "platform", "nodes"
  ))
  case object ACSchool extends TiledMap(value = "acschool", title = "acschool", soundtrack = None, color = "#000000", images = Seq("acschool", "collisions"), layers = Seq(
    "bg", "walldeco", "collision", "nodes"
  ))
  case object AdminHallway extends TiledMap(value = "admin-hallway", title = "Admin Hallway", soundtrack = Some("greendale-alt"), color = "#687b9f", images = Seq("greendale-hallways", "collisions"), layers = Seq(
    "Tile Layer 1", "Tile Layer 2", "Tile Layer 3", "collision", "nodes"
  ))
  case object Baseball extends TiledMap(value = "baseball", title = "Baseball with Cornelius", soundtrack = Some("britta-bot"), color = "#7d9af9", images = Seq("baseball", "collisions"), layers = Seq(
    "background", "foreground", "leaves", "collision", "nodes"
  ))
  case object BlackCaverns2 extends TiledMap(value = "black-caverns-2", title = "Black Caverns", soundtrack = Some("blackcaves"), color = "#000000", images = Seq("black-caverns", "collisions"), layers = Seq(
    "background", "walls", "wall shadow corners", "wall shadows", "floors", "doors", "extras", "collision", "nodes", "movement"
  ))
  case object BlackCaverns3 extends TiledMap(value = "black-caverns-3", title = "black-caverns-3", soundtrack = Some("blackcaves"), color = "#000000", images = Seq("black-caverns", "collisions"), layers = Seq(
    "bg", "bg_pillar", "bgwall", "floor", "background", "foreground", "super foreground", "collision", "nodes"
  ))
  case object BlackCaverns extends TiledMap(value = "black-caverns", title = "black-caverns", soundtrack = Some("blackcaves"), color = "#000000", images = Seq("black-caverns", "collisions"), layers = Seq(
    "background", "floor", "features", "collision", "nodes", "movement"
  ))
  case object BlacksmithUpstairs extends TiledMap(value = "blacksmith-upstairs", title = "blacksmith-upstairs", soundtrack = Some("blacksmith"), color = "#000000", images = Seq("inside"), layers = Seq(
    "floor", "wall", "pillar_bottom", "pillar_top", "floorspace", "nodes"
  ))
  case object Blacksmith extends TiledMap(value = "blacksmith", title = "blacksmith", soundtrack = Some("blacksmith"), color = "#000000", images = Seq("inside", "collisions"), layers = Seq(
    "background", "foreground", "accent", "newStairs", "floorspace", "nodes"
  ))
  case object BorchertHallway extends TiledMap(value = "borchert-hallway", title = "Borchert Hallway", soundtrack = Some("greendale-alt"), color = "#687b9f", images = Seq("greendale-hallways", "collisions"), layers = Seq(
    "Tile Layer 1", "Tile Layer 2", "Tile Layer 3", "collision", "nodes"
  ))
  case object CastleHawkthorneEntrance extends TiledMap(value = "castle-hawkthorne-entrance", title = "castle-hawkthorne-entrance", soundtrack = Some("castle-entrance"), color = "#000000", images = Seq("castle-hawkthorne-entrance"), layers = Seq(
    "bg_tree", "bg_leaves3", "floor", "features", "bridge", "bg_leaves2", "bg_leaves", "wall", "gate", "floorspace", "nodes", "foreground", "foreground2", "foreground3", "foreground4"
  ))
  case object CastleHawkthorneRoom1 extends TiledMap(value = "castle-hawkthorne-room-1", title = "castle-hawkthorne-room-1", soundtrack = Some("castle"), color = "#000000", images = Seq("castle-hawkthorne", "collisions"), layers = Seq(
    "wall", "pillar", "floor", "features", "collision", "nodes"
  ))
  case object CastleHawkthorneRoom2 extends TiledMap(value = "castle-hawkthorne-room-2", title = "castle-hawkthorne-room-2", soundtrack = Some("castle"), color = "#000000", images = Seq("castle-hawkthorne", "collisions"), layers = Seq(
    "wall", "pillar", "floor", "features", "collision", "nodes"
  ))
  case object CastleHawkthorneRoom3 extends TiledMap(value = "castle-hawkthorne-room-3", title = "castle-hawkthorne-room-3", soundtrack = Some("castle"), color = "#000000", images = Seq("castle-hawkthorne", "collisions"), layers = Seq(
    "wall", "pillar", "floor", "features", "collision", "nodes"
  ))
  case object CastleHawkthorneRoom4 extends TiledMap(value = "castle-hawkthorne-room-4", title = "castle-hawkthorne-room-4", soundtrack = Some("castle"), color = "#000000", images = Seq("castle-hawkthorne", "collisions"), layers = Seq(
    "wall", "pillar", "floor", "features", "collision", "nodes"
  ))
  case object CastleHawkthorneThrone extends TiledMap(value = "castle-hawkthorne-throne", title = "castle-hawkthorne-throne", soundtrack = Some("castle"), color = "#000000", images = Seq("castle-hawkthorne", "collisions"), layers = Seq(
    "sky", "bg_leaves2", "bg_leaves", "background", "pillar", "ground", "floor", "features", "collision", "nodes"
  ))
  case object CastleHawkthorne extends TiledMap(value = "castle-hawkthorne", title = "castle-hawkthorne", soundtrack = Some("castle"), color = "#000000", images = Seq("castle-hawkthorne", "collisions"), layers = Seq(
    "pillar", "floor", "features", "collision", "nodes"
  ))
  case object ClassBasement extends TiledMap(value = "class-basement", title = "class-basement", soundtrack = Some("greendale-alt"), color = "#696d73", images = Seq("greendale-hallways", "collisions"), layers = Seq(
    "Tile Layer 1", "Tile Layer 2", "Tile Layer 3", "collision", "nodes"
  ))
  case object ClassHallway2 extends TiledMap(value = "class-hallway-2", title = "Class Hallway 2", soundtrack = Some("greendale-alt"), color = "#687b9f", images = Seq("greendale-hallways", "collisions"), layers = Seq(
    "Tile Layer 1", "Tile Layer 2", "Tile Layer 3", "collision", "nodes"
  ))
  case object ClassHallway extends TiledMap(value = "class-hallway", title = "Class Hallway 1", soundtrack = Some("greendale-alt"), color = "#dbc399", images = Seq("greendale-hallways", "collisions"), layers = Seq(
    "Tile Layer 1", "Tile Layer 2", "Tile Layer 3", "collision", "nodes"
  ))
  case object DeansCloset extends TiledMap(value = "deans-closet", title = "Dean's Closet", soundtrack = Some("dancingqueen"), color = "#757575", images = Seq("deans-closet", "collisions"), layers = Seq(
    "Tile Layer 1", "Tile Layer 2", "Tile Layer 3", "collision", "nodes"
  ))
  case object DeansCloset2 extends TiledMap(value = "deans-closet2", title = "deans-closet2", soundtrack = Some("dancingqueen"), color = "#757575", images = Seq("deans-closet", "collisions"), layers = Seq(
    "background", "floor", "foregorund", "foreground2", "collision", "nodes"
  ))
  case object DeansOffice2 extends TiledMap(value = "deans-office-2", title = "Dean Inner Office", soundtrack = Some("greendale-alt"), color = "#989453", images = Seq("deans-office"), layers = Seq(
    "Tile Layer 1", "Tile Layer 2", "Tile Layer 3", "Tile Layer 4", "floorspace", "nodes"
  ))
  case object DeansOffice extends TiledMap(value = "deans-office", title = "Dean Outer Office", soundtrack = Some("greendale-alt"), color = "#989453", images = Seq("deans-office"), layers = Seq(
    "Tile Layer 1", "Tile Layer 2", "Tile Layer 3", "Tile Layer 4", "nodes", "floorspace"
  ))
  case object DormLobby extends TiledMap(value = "dorm-lobby", title = "dorm lobby", soundtrack = None, color = "#a87158", images = Seq("greendale-hallways", "collisions"), layers = Seq(
    "Tile Layer 1", "Tile Layer 2", "Tile Layer 3", "collision", "nodes"
  ))
  case object Forest2 extends TiledMap(value = "forest-2", title = "Forest 2", soundtrack = Some("forest-2"), color = "#73defa", images = Seq("forest", "collisions"), layers = Seq(
    "mountains", "clouds 2", "clouds", "leaves", "Tile Layer 10", "Tile Layer 9", "leaves3", "leaves2", "background", "foreground", "trees", "collision", "nodes"
  ))
  case object ForestHidden extends TiledMap(value = "forest-hidden", title = "forest-hidden", soundtrack = Some("forest-2"), color = "#73defa", images = Seq("forest", "collisions"), layers = Seq(
    "clouds", "bg_leaves", "bg_tree2", "bg_tree", "background", "foreground", "Tile Layer 5", "features", "leaves", "collision", "nodes"
  ))
  case object Forest extends TiledMap(value = "forest", title = "Forest", soundtrack = Some("forest-2"), color = "#73defa", images = Seq("forest", "collisions"), layers = Seq(
    "clouds 2", "clouds", "leaves bg", "leaves2", "leaves", "cave", "stalagmite bg", "icicles background2", "icicles background", "icicles forground", "darker background", "filler", "background", "Tile Layer 19", "leaves3", "foreground", "leaves", "nodes", "welcome_to_hawkthorne", "stalagmatites", "fade", "collision"
  ))
  case object FrozenCave2 extends TiledMap(value = "frozencave-2", title = "Frozen Cave 2", soundtrack = Some("winter2"), color = "#000000", images = Seq("frozencave", "collisions"), layers = Seq(
    "background", "floor", "details", "collision", "nodes"
  ))
  case object Frozencave3 extends TiledMap(value = "frozencave-3", title = "frozencave-3", soundtrack = Some("winter2"), color = "#000000", images = Seq("frozencave", "collisions"), layers = Seq(
    "background", "floor", "foreground", "collision", "nodes", "movement"
  ))
  case object FrozenCave extends TiledMap(value = "frozencave", title = "Frozencave", soundtrack = Some("winter2"), color = "#000000", images = Seq("frozencave", "collisions"), layers = Seq(
    "background", "filler", "floor", "foreground", "collision", "nodes", "movement"
  ))
  case object GayIsland2 extends TiledMap(value = "gay-island-2", title = "Gay Island 2", soundtrack = Some("mamma-mia"), color = "#000000", images = Seq("gay-island", "collisions"), layers = Seq(
    "sky", "rainbows", "little_penis", "little_clouds", "big_penis", "big_penis2", "clouds", "bushes2", "bushes", "bg_leaves3", "bg_leaves2", "bg_leaves", "filler", "floor", "features", "grass", "trees", "leaves", "collision", "nodes", "movement"
  ))
  case object GayIsland3 extends TiledMap(value = "gay-island-3", title = "Gay Island 2", soundtrack = Some("mamma-mia"), color = "#000000", images = Seq("gay-island", "collisions"), layers = Seq(
    "sky", "rainbows", "little_penis", "little_clouds", "big_penis", "big_penis2", "clouds", "bushes2", "bushes", "bg_leaves3", "bg_leaves2", "bg_leaves", "filler", "floor", "features", "grass", "trees", "leaves", "collision", "nodes", "movement"
  ))
  case object GayIsland4 extends TiledMap(value = "gay-island-4", title = "gay-island-4", soundtrack = Some("mamma-mia"), color = "#000000", images = Seq("gay-island", "collisions"), layers = Seq(
    "background", "clouds2", "clouds", "ocean", "bg_penises", "bg_trees", "bg_leaves2", "bg_leaves", "filler", "floor", "trees", "collision", "nodes"
  ))
  case object GayIsland extends TiledMap(value = "gay-island", title = "Gay Island", soundtrack = Some("mamma-mia"), color = "#000000", images = Seq("gay-island", "collisions"), layers = Seq(
    "sky", "rainbows2", "little_penis2", "little_penis", "clouds3", "rainbows1", "big_penis3", "big_penis2", "big_penis", "clouds2", "clouds", "ocean", "bg_leaves2", "bg_leaves", "bg_trees", "filler", "floor", "grass", "trees", "leaves", "leaves2", "collision", "nodes"
  ))
  case object GazetteOffice2 extends TiledMap(value = "gazette-office-2", title = "gazette-office-2", soundtrack = Some("mash-theme"), color = "#5c725c", images = Seq("gazette-office"), layers = Seq(
    "Tile Layer 1", "Tile Layer 2", "Tile Layer 3", "floorspace", "nodes"
  ))
  case object GazetteOffice extends TiledMap(value = "gazette-office", title = "gazette-office", soundtrack = Some("mash-theme"), color = "#667380", images = Seq("gazette-office"), layers = Seq(
    "Tile Layer 1", "Tile Layer 2", "Tile Layer 3", "floorspace", "nodes", "Object Layer 3"
  ))
  case object GreendaleAnthropology extends TiledMap(value = "greendale-anthropology", title = "greendale-anthropology", soundtrack = Some("greendale-alt"), color = "#000000", images = Seq("anthropologyroom", "collisions"), layers = Seq(
    "bg", "bg2", "decor1", "decor2", "tabletop", "collision", "nodes"
  ))
  case object GreendaleBiology extends TiledMap(value = "greendale-biology", title = "greendale-biology", soundtrack = Some("greendale-alt"), color = "#000000", images = Seq("greendale-classrooms", "collisions"), layers = Seq(
    "bg", "boards", "baseboard", "windows", "decor", "tabletops", "labbenches", "benchtops", "collision", "nodes"
  ))
  case object GreendaleEnglishMemorial extends TiledMap(value = "greendale-englishmemorial", title = "greendale-englishmemorial", soundtrack = Some("greendale-alt"), color = "#7d9af9", images = Seq("englishmemorial", "greendale-exterior", "collisions"), layers = Seq(
    "bg", "cloud", "city", "groundandsky", "littlebushes", "building", "buildingdetails", "fountain", "details", "collision", "nodes"
  ))
  case object GreendaleExterior extends TiledMap(value = "greendale-exterior", title = "Greendale Exterior", soundtrack = Some("greendale"), color = "#7d9af9", images = Seq("greendale-exterior", "collisions"), layers = Seq(
    "city_little_clouds", "hedge_big_clouds", "background", "foreground", "leaves", "lampposts", "collision", "nodes", "movement"
  ))
  case object GreendaleFry extends TiledMap(value = "greendale-fry", title = "greendale-fry", soundtrack = Some("greendale-alt"), color = "#000000", images = Seq("greendale-classrooms", "collisions"), layers = Seq(
    "bg", "walldecor", "desk", "tabletop", "seats", "collision", "nodes"
  ))
  case object GreendaleLadders extends TiledMap(value = "greendale-ladders", title = "greendale-ladders", soundtrack = Some("greendale-alt"), color = "#000000", images = Seq("greendale-classrooms", "collisions"), layers = Seq(
    "bg", "walldecor", "podium", "seats", "ladder", "collision", "nodes"
  ))
  case object GreendaleQuad extends TiledMap(value = "greendale-quad", title = "Greendale Quad", soundtrack = Some("greendale"), color = "#7d9af9", images = Seq("greendale-exterior", "collisions"), layers = Seq(
    "skyline", "ground", "bg_buildings", "trees", "bushes", "floor", "trunk", "leaves", "features", "collision", "nodes"
  ))
  case object Hallway extends TiledMap(value = "hallway", title = "hallway", soundtrack = None, color = "#000000", images = Seq("greendale-interior", "collisions"), layers = Seq(
    "background", "accents", "collision", "block", "nodes", "ceiling"
  ))
  case object House extends TiledMap(value = "house", title = "house", soundtrack = Some("tavern"), color = "#000000", images = Seq("inside"), layers = Seq(
    "Background", "Foreground", "Accent", "Overlap", "nodes", "floorspace"
  ))
  case object Lab extends TiledMap(value = "lab", title = "lab", soundtrack = Some("potionlab"), color = "#000000", images = Seq("lab"), layers = Seq(
    "background", "foreground", "accents", "nodes", "floorspace"
  ))
  case object MensBathroom extends TiledMap(value = "mens-bathroom", title = "mens-bathroom", soundtrack = Some("greendale-alt"), color = "#000000", images = Seq("bathroom", "collisions"), layers = Seq(
    "Background", "Wall features 1", "Wall features 2", "collision", "nodes"
  ))
  case object NewAbedtown extends TiledMap(value = "new-abedtown", title = "New Abedtown", soundtrack = Some("abeds-town"), color = "#90c2ce", images = Seq("new-abedtown", "collisions"), layers = Seq(
    "Para002", "Para005", "Para010", "Para020", "Para050", "BackWall", "Background", "detail", "overlay", "nodes", "foreground", "foreground2", "collision"
  ))
  case object ParkingLot extends TiledMap(value = "parking-lot", title = "Parking lot", soundtrack = Some("greendale"), color = "#7d9af9", images = Seq("parking_lot", "collisions"), layers = Seq(
    "city_little_clouds", "Clouds", "bushes", "Background", "Signs", "vehicles", "collision", "nodes"
  ))
  case object PotteryClass extends TiledMap(value = "potteryclass", title = "potteryclass", soundtrack = Some("greendale-alt"), color = "#000000", images = Seq("pottery"), layers = Seq(
    "bg", "walldecor", "shelves", "shelfitems", "siding", "seats", "table", "tableitems", "nodes", "floorspace"
  ))
  case object RainbowBar extends TiledMap(value = "rainbow-bar", title = "Rainbow Bar", soundtrack = Some("pocketful"), color = "#dbc399", images = Seq("rainbow-bar", "collisions"), layers = Seq(
    "Floor", "Wall", "Decoration", "collision", "nodes"
  ))
  case object RaveHallway extends TiledMap(value = "rave-hallway", title = "rave-hallway", soundtrack = Some("rave"), color = "#1f252f", images = Seq("rave-hallway", "collisions"), layers = Seq(
    "Tile Layer 1", "Tile Layer 2", "Tile Layer 3", "collision", "nodes"
  ))
  case object Seabluff extends TiledMap(value = "seabluff", title = "seabluff", soundtrack = Some("seabluff"), color = "#73e1fa", images = Seq("seabluff", "collisions"), layers = Seq(
    "clouds", "clouds2", "castle", "leaf", "leaf2", "backgroundbluff5", "backgroundbluff4", "backgroundbluff3", "backgroundbluff2", "backgroundbluff", "filler", "floor", "floor2", "leafs", "leafs2", "features", "collision", "nodes"
  ))
  case object SecretWritersGarden extends TiledMap(value = "secretwritersgarden", title = "secretwritersgarden", soundtrack = Some("lovesoalike"), color = "#000000", images = Seq("secretgarden", "collisions"), layers = Seq(
    "bg", "pipe", "ground", "hedge", "ledges", "board", "trees", "writing", "tables", "writers", "writers2", "collision", "nodes"
  ))
  case object Sophieb extends TiledMap(value = "sophieb", title = "sophieb", soundtrack = Some("asilaymedown"), color = "#000000", images = Seq("sophiedance", "collisions"), layers = Seq(
    "sky", "stars", "clouds", "city", "plants", "main", "lamps", "banners", "tables", "stage", "door", "text", "windowshapes", "streamersunder", "streamers", "streamersovelap", "litter", "collision", "nodes"
  ))
  case object StudyRoom extends TiledMap(value = "studyroom", title = "Greendale", soundtrack = None, color = "#000000", images = Seq("greendale-interior"), layers = Seq(
    "background", "side walls", "accents bg", "nodes", "floorspace"
  ))
  case object Sunchamber extends TiledMap(value = "sunchamber", title = "sunchamber", soundtrack = None, color = "#000000", images = Seq("sunchamber", "collisions"), layers = Seq(
    "bg", "toptile", "tileline", "curtainspink", "curtainsblue", "velvetropes", "deco", "sunchamber", "collision", "nodes"
  ))
  case object Tavern extends TiledMap(value = "tavern", title = "tavern", soundtrack = Some("tavern"), color = "#000000", images = Seq("inside"), layers = Seq(
    "background", "foreground", "accents", "top", "floorspace", "nodes"
  ))
  case object TestLevel extends TiledMap(value = "test-level", title = "test-level", soundtrack = Some("forest"), color = "#4ad8f7", images = Seq("treeline", "collisions"), layers = Seq(
    "bg_walls", "background", "foreground", "leaves", "collision", "nodes", "movement"
  ))
  case object Town extends TiledMap(value = "town", title = "Town", soundtrack = Some("town"), color = "#c3a37c", images = Seq("town", "collisions"), layers = Seq(
    "mountains", "treeline", "reeds", "bg_trunks", "bg_needles", "bg_leaves", "buildings", "foreground", "accents", "collision", "nodes"
  ))
  case object Trampoline extends TiledMap(value = "trampoline", title = "trampoline", soundtrack = Some("lovesoalike"), color = "#7d9af9", images = Seq("trampoline", "collisions"), layers = Seq(
    "background", "City", "bush", "little_clouds", "big clouds", "Grass_and_bg_hedges", "hedges0", "hedges1", "plants", "Bench_creeper", "Final", "collision", "nodes"
  ))
  case object Treeline extends TiledMap(value = "treeline", title = "Village Forest", soundtrack = Some("village-forest"), color = "#4ad8f7", images = Seq("treeline", "treeline", "collisions"), layers = Seq(
    "mountains", "Hills", "Fade", "Bushes", "Trees-decorative", "bg_trees", "bg_leaves", "Trees Distant", "Leaves 1", "Trees", "Background", "Leaves 2", "Leaves 3", "Leaves 4", "Extras", "collision", "block", "nodes"
  ))
  case object Upstairs extends TiledMap(value = "upstairs", title = "upstairs", soundtrack = Some("tavern"), color = "#000000", images = Seq("inside"), layers = Seq(
    "background", "foreground", "accents", "floorspace", "nodes"
  ))
  case object Valley2 extends TiledMap(value = "valley-2", title = "valley-2", soundtrack = Some("valley"), color = "#000000", images = Seq("valley", "collisions"), layers = Seq(
    "sky", "taco-mountains_bg", "taco-mountains", "mountains_bg", "mountains", "tacos2", "tacos", "filler_bg", "filler", "leaves", "floor", "foreground", "shrubs", "collision", "nodes", "movement"
  ))
  case object Valley3 extends TiledMap(value = "valley-3", title = "valley-3", soundtrack = Some("valley"), color = "#000000", images = Seq("valley", "collisions"), layers = Seq(
    "sky", "taco_mountains_bg", "taco_mountains", "mountains_bg", "mountains", "bg_chilis", "ocean", "filler", "filler_fg", "fence_frame", "fence", "fence_top", "fence_barbedcoil", "fence_pillar", "floor", "foreground", "collision", "nodes", "movement"
  ))
  case object ValleyChiliFields2 extends TiledMap(value = "valley-chili-fields-2", title = "valley-chili-fields-2", soundtrack = Some("valley"), color = "#000000", images = Seq("valley", "collisions"), layers = Seq(
    "sky", "taco_mountains_bg", "taco_mountains", "mountains_bg", "mountains", "bg_leaves", "bg_leaves_2", "bg_chilis_1", "bg_chilis_2", "bg_chilis_3", "filler2", "filler", "leaves", "leaves2", "floor", "foreground", "chili_3", "chili_2", "chili_1", "shrubs", "fence", "collision", "nodes"
  ))
  case object ValleyChiliFields extends TiledMap(value = "valley-chili-fields", title = "valley-chili-fields", soundtrack = Some("valley"), color = "#000000", images = Seq("valley", "collisions"), layers = Seq(
    "sky", "taco_mountains_bg", "taco_mountains", "mountains_bg", "mountains", "leaves2", "leaves", "bg_chilis_3", "bg_chilis_2", "bg_chilis", "filler", "filler_fg", "floor", "chilis", "chilis2", "chilis3", "fence", "collision", "nodes"
  ))
  case object ValleyGoatCave extends TiledMap(value = "valley-goat-cave", title = "valley-goat-cave", soundtrack = Some("valley2"), color = "#000000", images = Seq("valley-sandpits", "collisions"), layers = Seq(
    "floor", "Tile Layer 4", "Tile Layer 6", "features", "dark", "collision", "nodes"
  ))
  case object ValleyGoatFarm extends TiledMap(value = "valley-goat-farm", title = "valley-goat-farm", soundtrack = Some("tacotown"), color = "#000000", images = Seq("valley", "collisions"), layers = Seq(
    "sky", "nacho_mountains_bg", "nacho_mountains", "mountains", "taco_bg", "taco", "bg_buildings", "bushes", "smallfence", "bg_fence", "buildings", "features", "fence", "floor", "collision", "nodes"
  ))
  case object ValleyHills2 extends TiledMap(value = "valley-hills-2", title = "valley-hills-2", soundtrack = Some("valley"), color = "#000000", images = Seq("valley", "collisions"), layers = Seq(
    "sky", "taco_mountains_bg", "taco_mountains", "mountains_bg", "mountains", "bg_leaves", "bg_leaves_2", "floor", "nodes"
  ))
  case object ValleyHills extends TiledMap(value = "valley-hills", title = "valley-hills", soundtrack = Some("valley2"), color = "#000000", images = Seq("valley", "collisions"), layers = Seq(
    "sky", "taco_mountains_bg", "taco_mountains", "mountains_bg", "mountains", "bg_leaves", "bg_leaves_2", "filler", "floor", "features", "collision", "nodes"
  ))
  case object ValleySandpits2 extends TiledMap(value = "valley-sandpits-2", title = "valley-sandpits-2", soundtrack = Some("sandpits"), color = "#000000", images = Seq("valley-sandpits", "collisions"), layers = Seq(
    "pillar3", "background_walls2", "pillar2", "bg_walls2", "bg_walls", "spiderweb", "shrub", "filler", "ropes", "walls2", "walls", "Tile Layer 9", "collision", "nodes", "movement"
  ))
  case object ValleySandpitsEntrance extends TiledMap(value = "valley-sandpits-entrance", title = "valley-sandpits-entrance", soundtrack = Some("valley"), color = "#000000", images = Seq("valley", "collisions"), layers = Seq(
    "bg_filler", "background_walls", "leaves_bg", "leaves", "filler", "floor", "foreground", "shrubs", "collision", "nodes", "movement"
  ))
  case object ValleySandpits extends TiledMap(value = "valley-sandpits", title = "valley-sandpits", soundtrack = Some("sandpits"), color = "#000000", images = Seq("valley-sandpits", "collisions"), layers = Seq(
    "pillar3", "background_walls2", "pillar2", "bg_walls2", "bg_walls", "filler", "walls2", "walls", "spiderweb", "Tile Layer 9", "collision", "nodes", "movement"
  ))
  case object ValleyTacotown extends TiledMap(value = "valley-tacotown", title = "valley-tacotown", soundtrack = Some("tacotown"), color = "#000000", images = Seq("valley", "collisions"), layers = Seq(
    "sky", "nacho_mountains_bg", "nacho_mountains", "mountains", "taco_bg", "taco", "bgbushes", "fences", "bottom_fence", "floor", "buildings_bg", "buildings", "windows", "grass/roofs", "collision", "nodes"
  ))
  case object Valley extends TiledMap(value = "valley", title = "valley", soundtrack = Some("valley"), color = "#000000", images = Seq("valley", "collisions"), layers = Seq(
    "sky", "nacho_mountains_bg", "nacho_mountains", "mountains_bg", "mountains", "ocean", "filler", "filler_fg", "floor", "foreground", "singposts", "collision", "nodes"
  ))
  case object Vents2 extends TiledMap(value = "vents-2", title = "vents-2", soundtrack = Some("somewhereoutthere"), color = "#000000", images = Seq("vents", "collisions"), layers = Seq(
    "background", "bg_vents2", "bg_vents", "vents", "platforms", "ladders/features", "collision", "nodes"
  ))
  case object Vents extends TiledMap(value = "vents", title = "vents", soundtrack = Some("somewhereoutthere"), color = "#000000", images = Seq("vents", "collisions"), layers = Seq(
    "background", "bathroom", "pipe", "pipe2", "Tile Layer 10", "ladders", "hoard", "pipedings", "pipethings", "collision", "nodes"
  ))
  case object VillageForest2 extends TiledMap(value = "village-forest-2", title = "village-forest-2", soundtrack = Some("mountains"), color = "#4ad8f7", images = Seq("village-forest-mountains", "collisions"), layers = Seq(
    "sky", "mountains3", "clouds_bg", "mountains2", "clouds_bg_2", "mountains", "clouds2", "clouds", "bushes_2", "bushes", "filler2", "filler", "floor", "trees", "leaves", "features", "tree1", "leaves1", "trees2", "leaves2", "collision", "nodes"
  ))
  case object VillageForest3 extends TiledMap(value = "village-forest-3", title = "village-forest-3", soundtrack = Some("village-forest"), color = "#4ad8f7", images = Seq("village-forest-mountains", "collisions"), layers = Seq(
    "mountains2", "mountains", "clouds", "clouds2", "bg_leaves2", "bg_trees", "bg_leaves", "filler", "filler2", "floor", "tree", "leaves", "collision", "nodes"
  ))
  case object VillageForest4 extends TiledMap(value = "village-forest-4", title = "village-forest-4", soundtrack = Some("village-forest"), color = "#4ad8f7", images = Seq("treeline", "collisions"), layers = Seq(
    "clouds", "ocean", "mountains", "mountains_front", "bg_trees", "bg_leaves2", "bg_leaves", "filler", "leaves_2", "foreground", "features", "trees", "leaves", "collision", "nodes"
  ))
  case object VillageForestAcornpeak2 extends TiledMap(value = "village-forest-acornpeak-2", title = "village-forest-acornpeak-2", soundtrack = Some("mountains"), color = "#000000", images = Seq("village-forest-mountains", "collisions"), layers = Seq(
    "sky", "mountains4", "clouds6", "clouds5", "mountains3", "clouds4", "mountains2", "clouds3", "mountains", "clouds2", "clouds", "bg_leaves2", "bg_leaves", "filler", "floor", "tree", "leaves", "vines2", "vines", "features", "grass", "fog", "fg", "collision", "nodes"
  ))
  case object VillageForestAcornpeak extends TiledMap(value = "village-forest-acornpeak", title = "village-forest-acornpeak", soundtrack = Some("mountains"), color = "#000000", images = Seq("village-forest-mountains", "collisions"), layers = Seq(
    "sky", "mountains3", "clouds4", "mountains2", "clouds3", "mountains", "clouds2", "clouds", "bg_bushes4", "bg_Trees", "bg_bushes3", "bg_bushes2", "bg_bushes ", "filler2", "filler", "floor", "trees", "leaves", "trees2", "leaves2", "vines", "vines2", "features", "foregroundstuff", "collision", "nodes"
  ))
  case object VillageForestMines2 extends TiledMap(value = "village-forest-mines-2", title = "village-forest-mines-2", soundtrack = Some("abeds-castle"), color = "#000000", images = Seq("village-forest-mountains", "collisions"), layers = Seq(
    "bg", "rocks", "rocks2", "rocks3", "pillar", "floor", "stairs", "stalactite", "dark", "collision", "nodes", "movement"
  ))
  case object VillageForestMines3 extends TiledMap(value = "village-forest-mines-3", title = "village-forest-mines-3", soundtrack = Some("abeds-castle"), color = "#000000", images = Seq("village-forest-mountains", "collisions"), layers = Seq(
    "bg", "pillar", "floor", "Tile Layer 6", "dark", "collision", "nodes"
  ))
  case object VillageForestMinesEntrance extends TiledMap(value = "village-forest-mines-entrance", title = "village-forest-mines-entrance", soundtrack = Some("mountains"), color = "#000000", images = Seq("village-forest-mountains", "collisions"), layers = Seq(
    "sky", "mountains3", "clouds", "clouds_2", "mountains2", "clouds_3", "mountains", "clouds", "Copy of clouds", "bg_leaves2", "bg_leaves", "filler2", "filler", "fade", "floor", "trees2", "leaves_bg", "trees", "bg_bushes2", "bg_bushes", "leaves", "leaves2", "bushes", "bushes2", "features", "Tile Layer 22", "fgbushes", "fgbushes2", "collision", "nodes", "movement"
  ))
  case object VillageForestMinesReturn extends TiledMap(value = "village-forest-mines-return", title = "village-forest-mines-return", soundtrack = Some("abeds-castle"), color = "#000000", images = Seq("village-forest-mountains", "collisions"), layers = Seq(
    "dots", "rocks3", "rocks2", "Tile Layer 12", "rocks1", "filler", "pillars", "floor", "ledges", "railings", "features", "dark", "collision", "nodes", "movement"
  ))
  case object VillageForestMinesRoom extends TiledMap(value = "village-forest-mines-room", title = "village-forest-mines-room", soundtrack = Some("abeds-castle"), color = "#000000", images = Seq("village-forest-mountains", "collisions"), layers = Seq(
    "bg", "rocks", "Tile Layer 10", "pillar", "filler", "floor", "features", "Tile Layer 9", "dark", "collision", "nodes"
  ))
  case object VillageForestMinesStorageRoom extends TiledMap(value = "village-forest-mines-storage-room", title = "village-forest-mines-storage-room", soundtrack = Some("abeds-castle"), color = "#000000", images = Seq("village-forest-mountains", "collisions"), layers = Seq(
    "bg", "pillar", "floor", "features", "dark", "collision", "nodes"
  ))
  case object VillageForestMines extends TiledMap(value = "village-forest-mines", title = "village-forest-mines", soundtrack = Some("abeds-castle"), color = "#000000", images = Seq("village-forest-mountains", "collisions"), layers = Seq(
    "dots", "rocks3", "rocks2", "Tile Layer 12", "rocks1", "filler", "pillars", "floor", "ledges", "railings", "features", "dark", "collision", "nodes", "movement"
  ))
  case object VillageForestStonerspeak2 extends TiledMap(value = "village-forest-stonerspeak-2", title = "village-forest-stonerspeak-2", soundtrack = Some("forest"), color = "#000000", images = Seq("village-forest-mountains", "collisions"), layers = Seq(
    "clouds", "mountains2", "mountains", "filler2", "filler", "bg", "floor", "features", "fog", "collision", "nodes"
  ))
  case object VillageForestStonerspeakReturn extends TiledMap(value = "village-forest-stonerspeak-return", title = "village-forest-stonerspeak-return", soundtrack = Some("forest"), color = "#000000", images = Seq("village-forest-mountains", "collisions"), layers = Seq(
    "clouds", "mountains2", "mountains", "Tile Layer 13", "Tile Layer 12", "Tile Layer 11", "vines", "vines2", "filler", "floor", "features", "fog", "collision", "nodes", "movement"
  ))
  case object VillageForestStonerspeak extends TiledMap(value = "village-forest-stonerspeak", title = "village-forest-stonerspeak", soundtrack = Some("forest"), color = "#000000", images = Seq("village-forest-mountains", "collisions"), layers = Seq(
    "clouds", "mountains2", "mountains", "Tile Layer 13", "Tile Layer 12", "Tile Layer 11", "vines", "vines2", "filler", "floor", "features", "fog", "collision", "nodes", "movement"
  ))
  case object VillageForest extends TiledMap(value = "village-forest", title = "village-forest", soundtrack = Some("mountains"), color = "#000000", images = Seq("village-forest-mountains", "collisions"), layers = Seq(
    "sky", "mountains_3", "clouds_3", "clouds_2", "mountains_2", "mountains_1", "clouds_front", "mountains_front", "bushes_bg_2", "bushes_bg", "Tile Layer 23", "trees_bg", "filler_2", "filler", "treetrunk_bg", "treeleaves_bg", "floor", "treetrunk", "treeleaves", "bushes_2", "bushes", "features", "foreground", "collision", "nodes", "block", "movement"
  ))
  case object VillageTreeline extends TiledMap(value = "village-treeline", title = "village-treeline", soundtrack = Some("mountains"), color = "#a7c1ce", images = Seq("treeline", "trampoline", "collisions"), layers = Seq(
    "mountain_2", "mountain", "Clouds", "bg_trees-2", "foreground2", "foreground", "bg_trees", "bg_leaves", "bush", "bush 1", "leaves2", "Trees", "leaves", "hole", "ropes", "bush 3", "collision", "nodes"
  ))
  case object WinterWonderland extends TiledMap(value = "winterwonderland", title = "winterwonderland", soundtrack = Some("winter"), color = "#000000", images = Seq("winter-wonderland", "collisions"), layers = Seq(
    "sky", "stars", "mountains3", "mountains2", "mountains", "snowbank3", "snow bank2", "filler", "floor3", "features", "features2", "features3", "features4", "collision", "nodes"
  ))
  case object WinterWonderland2 extends TiledMap(value = "winterwonderland2", title = "winterwonderland2", soundtrack = Some("winter"), color = "#000000", images = Seq("winter-wonderland", "collisions"), layers = Seq(
    "sky", "stars", "filler", "snowbank", "snowbank2", "floor", "feature3", "feature4", "collision", "nodes"
  ))
  case object WomensBathroom extends TiledMap(value = "womens-bathroom", title = "womens-bathroom", soundtrack = Some("greendale-alt"), color = "#000000", images = Seq("bathroom", "collisions"), layers = Seq(
    "Background", "Wall Features 1", "Wall Features 2", "Wall Features 3", "fievel", "collision", "nodes"
  ))

  override val values = findValues
}
