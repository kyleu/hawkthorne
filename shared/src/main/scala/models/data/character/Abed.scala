/* Generated File */
package models.data.character

import models.character.{BoundingBox, CharacterTemplate, Costume}

object Abed {
  val name = "Abed"
  val givenName = "Abed Nadir"

  val costumes = Seq(
    Costume("base", "base", "Abed Nadir", 1),
    Costume("alien", "s2e6", "Alien", 2),
    Costume("batman", "s1e7", "Batman", 3),
    Costume("bert", "s1e17", "Bert", 36),
    Costume("britta", "s3e16", "Britta Roleplay", 24),
    Costume("jamielee", "s3e12", "Brown Jamie Lee Curtis", 46),
    Costume("bee", "s2e13", "Bumblebee", 4),
    Costume("camo", "s1e23", "Camouflage", 5),
    Costume("cape", "s2e21", "The Cape", 23),
    Costume("chang", "s3e16", "Chang Roleplay", 22),
    Costume("mafia", "s1e18", "Chicken Mafia", 38),
    Costume("hurt", "s1e12", "Christmas Brawl", 29),
    Costume("elf", "s1e12", "Christmas Elf", 31),
    Costume("christmas", "s3e10", "Christmas Sweater", 6),
    Costume("paint", "s2e24", "Covered In Paint", 7),
    Costume("cowboy", "s2e21", "Cowboy", 8),
    Costume("creepy", "s1e5", "Creepy Alien", 45),
    Costume("rasalghul", "s4e13", "Darkest Timeline (Ra's Al Ghul)", 42),
    Costume("andre", "s2e19", "Dinner With Andre", 41),
    Costume("disco", "s3e10", "Disco", 30),
    Costume("drunk", "s1e16", "Drunk", 35),
    Costume("maiden", "s2e14", "Elf Maiden", 32),
    Costume("evil", "s3e22", "Evil Abed", 9),
    Costume("fine", "s3e1", "Finally Be Fine", 20),
    Costume("gangster", "s3e19", "Gangster", 10),
    Costume("baby", "s4e1", "Greendale Baby", 26),
    Costume("solo", "s2e24", "Han Solo", 11),
    Costume("poplock", "s2e2", "Heather Popandlocklear", 37),
    Costume("hobgoblin", "s5e10", "Hobgoblin", 44),
    Costume("morning", "s1e20", "In the Morning", 15),
    Costume("inspector", "s3e5", "Inspector Spacetime", 12),
    Costume("clubs", "s2e23", "Jack of Clubs", 34),
    Costume("jbv", "s1e15", "Jamaican Baseball Villain", 40),
    Costume("jeff", "s3e16", "Jeff Roleplay", 13),
    Costume("jeffshirt", "s1e2", "Jeff's Shirt", 28),
    Costume("white", "s1e17", "Joey", 14),
    Costume("mcclane", "s4e10", "John McClane", 21),
    Costume("kyle", "s2e14", "Kyle the Gnome", 33),
    Costume("king", "s3e10", "Mouse King", 16),
    Costume("naked", "s3e20", "Naked", 47),
    Costume("pierce", "s3e16", "Pierce Roleplay", 17),
    Costume("radar", "s1e13", "Radar", 39),
    Costume("plumber", "s3e21", "Rod the Plumber", 27),
    Costume("patrick", "s2e21", "St Patrick's Day", 43),
    Costume("sewn", "s3e5", "Troy and Abed Sewn Together", 18),
    Costume("troy", "s3e16", "Troy Roleplay", 25),
    Costume("zombie", "s2e6", "Zombie", 19)
  )

  val boundingBox = BoundingBox(
    width = 14,
    height = 41,
    duckHeight = 20,
    x = 17,
    y = 7
  )
  val offset = 5

  val template = CharacterTemplate("abed", name, givenName, costumes, boundingBox, offset)
}
