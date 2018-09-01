package services.navigation

import models.data.map.TiledMap

object NavigationTitles {
  def titleForPath(path: String) = path match {
    case "intro" => "Introduction"
    case "menu" => "Main Menu"
    case "options" => "Options"
    case "character" => "Select Your Character"
    case "portal" => "Portal"
    case "test" => "Test"
    case "sandbox" => "Sandbox Test"
    case "overworld" => "Overworld"
    case x if x.startsWith("map/") => TiledMap.withValue(x.stripPrefix("map/")).title
    case "multiplayer/list" => "Multiplayer Games"
    case "multiplayer/host" => "Host Multiplayer Game"
    case "credits" => "Credits"
    case "help" => "Help"
    case x => x
  }
}
