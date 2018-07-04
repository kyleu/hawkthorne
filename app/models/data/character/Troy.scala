/* Generated File */
package models.data.character

import models.character.{BoundingBox, CharacterTemplate, Costume}

object Troy {
  val name = "Troy"
  val givenName = "Troy Barnes"

  val costumes = Seq(
    Costume("base", "base", "Troy Barnes", 1),
    Costume("ac", "s3e22", "AC Repair", 28),
    Costume("atv", "s3e19", "ATV Gear", 49),
    Costume("bball", "s2e7", "B-Ball", 33),
    Costume("beatitudes", "s2e5", "Beat-itudes", 38),
    Costume("bingbong", "s2e14", "Bing Bong", 2),
    Costume("bumblebee", "s2e13", "Bumblebee", 3),
    Costume("gambino", "fanmade", "Childish Gambino", 4),
    Costume("mafia", "s1e18", "Chicken Mafia", 34),
    Costume("hurt", "s1e12", "Christmas Brawl", 44),
    Costume("christmas_tree", "s1e12", "Christmas Troy", 5),
    Costume("chronicles", "s1e9", "Community College Chronicles", 50),
    Costume("constable", "s3e6", "Constable Reggie", 6),
    Costume("cowboy", "s2e21", "Cowboy", 52),
    Costume("dancer", "s1e14", "Dancer", 21),
    Costume("detective", "s3e17", "Detective", 7),
    Costume("doctor", "s3e16", "Dr. Barnes", 39),
    Costume("eddie", "s1e7", "Eddie Murphy", 48),
    Costume("evil", "s3e4", "Evil Troy", 26),
    Costume("fiddla", "s2e20", "Fiddla, Please!", 23),
    Costume("fbf", "s3e1", "Finally Be Fine", 24),
    Costume("baby", "s4e1", "Greendale Baby", 27),
    Costume("popnlock", "s2e2", "Heather Popandlocklear", 37),
    Costume("hippie", "s3e10", "Hippie", 45),
    Costume("hobbes", "s4e2", "Hobbes", 8),
    Costume("invader", "s3e5", "Home Invader", 35),
    Costume("morning", "s1e20", "In the Morning", 42),
    Costume("kick", "s1e15", "Kickpuncher", 9),
    Costume("clubs", "s2e23", "King of Clubs", 46),
    Costume("lotus", "s5e4", "Laser Lotus", 54),
    Costume("letterman", "s1e1", "Letterman Jacket", 29),
    Costume("library", "s3e17", "Library Nerd", 10),
    Costume("michaeljackson", "s3e12", "Michael Jackson", 11),
    Costume("mustache", "s4e9", "Mustache", 41),
    Costume("chloroform", "s2e2", "My Whole Brain is Crying", 30),
    Costume("naked", "s3e20", "Naked", 53),
    Costume("night", "s3e19", "Night Troy", 12),
    Costume("operation", "s3e2", "Operation", 36),
    Costume("orange", "s2e24", "Orange Paint", 13),
    Costume("paintball", "s1e23", "Paintball", 15),
    Costume("pajamas", "s2e9", "Pajamas", 40),
    Costume("pantsuit", "s2e15", "Pant Suit", 14),
    Costume("pharaoh", "s1e21", "Pharaoh", 43),
    Costume("pumpkin", "s2e19", "Pumpkin", 25),
    Costume("ridley", "s2e6", "Ripley", 16),
    Costume("sexyvampire", "s2e6", "Sexy Dracula", 17),
    Costume("spidey", "s2e1", "Spiderman", 18),
    Costume("football", "s1e6", "Star Quarterback", 19),
    Costume("toga", "s1e22", "Toga", 32),
    Costume("sewn", "s3e5", "Troy and Abed Sewn Together", 20),
    Costume("troysoldier", "s2e11", "Troy Soldier", 51),
    Costume("werewolf", "s1e9", "Werewolf", 22),
    Costume("woodsman", "s3e7", "Woodsman", 31),
    Costume("zombie", "s2e6", "Zombie", 47)
  )

  val boundingBox = BoundingBox(
    width = 14,
    height = 34,
    duckHeight = 20,
    x = 17,
    y = 14
  )
  val offset = 8

  val template = CharacterTemplate("troy", name, givenName, costumes, boundingBox, offset)
}
