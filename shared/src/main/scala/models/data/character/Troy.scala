/* Generated File */
package models.data.character

import models.character.{BoundingBox, CharacterTemplate, Costume}
import models.data.series.Episode

object Troy {
  val name = "Troy"
  val givenName = "Troy Barnes"

  val costumes = Seq(
    Costume("base", Episode.S01E01, "Troy Barnes", 1),
    Costume("ac", Episode.S03E22, "AC Repair", 28),
    Costume("atv", Episode.S03E19, "ATV Gear", 49),
    Costume("bball", Episode.S02E07, "B-Ball", 33),
    Costume("beatitudes", Episode.S02E05, "Beat-itudes", 38),
    Costume("bingbong", Episode.S02E14, "Bing Bong", 2),
    Costume("bumblebee", Episode.S02E13, "Bumblebee", 3),
    Costume("gambino", Episode.S00E01, "Childish Gambino", 4),
    Costume("mafia", Episode.S01E18, "Chicken Mafia", 34),
    Costume("hurt", Episode.S01E12, "Christmas Brawl", 44),
    Costume("christmas_tree", Episode.S01E12, "Christmas Troy", 5),
    Costume("chronicles", Episode.S01E09, "Community College Chronicles", 50),
    Costume("constable", Episode.S03E06, "Constable Reggie", 6),
    Costume("cowboy", Episode.S02E21, "Cowboy", 52),
    Costume("dancer", Episode.S01E14, "Dancer", 21),
    Costume("detective", Episode.S03E17, "Detective", 7),
    Costume("doctor", Episode.S03E16, "Dr. Barnes", 39),
    Costume("eddie", Episode.S01E07, "Eddie Murphy", 48),
    Costume("evil", Episode.S03E04, "Evil Troy", 26),
    Costume("fiddla", Episode.S02E20, "Fiddla, Please!", 23),
    Costume("fbf", Episode.S03E01, "Finally Be Fine", 24),
    Costume("baby", Episode.S04E01, "Greendale Baby", 27),
    Costume("popnlock", Episode.S02E02, "Heather Popandlocklear", 37),
    Costume("hippie", Episode.S03E10, "Hippie", 45),
    Costume("hobbes", Episode.S04E02, "Hobbes", 8),
    Costume("invader", Episode.S03E05, "Home Invader", 35),
    Costume("morning", Episode.S01E20, "In the Morning", 42),
    Costume("kick", Episode.S01E15, "Kickpuncher", 9),
    Costume("clubs", Episode.S02E23, "King of Clubs", 46),
    Costume("lotus", Episode.S05E04, "Laser Lotus", 54),
    Costume("letterman", Episode.S01E01, "Letterman Jacket", 29),
    Costume("library", Episode.S03E17, "Library Nerd", 10),
    Costume("michaeljackson", Episode.S03E12, "Michael Jackson", 11),
    Costume("mustache", Episode.S04E09, "Mustache", 41),
    Costume("chloroform", Episode.S02E02, "My Whole Brain is Crying", 30),
    Costume("naked", Episode.S03E20, "Naked", 53),
    Costume("night", Episode.S03E19, "Night Troy", 12),
    Costume("operation", Episode.S03E02, "Operation", 36),
    Costume("orange", Episode.S02E24, "Orange Paint", 13),
    Costume("paintball", Episode.S01E23, "Paintball", 15),
    Costume("pajamas", Episode.S02E09, "Pajamas", 40),
    Costume("pantsuit", Episode.S02E15, "Pant Suit", 14),
    Costume("pharaoh", Episode.S01E21, "Pharaoh", 43),
    Costume("pumpkin", Episode.S02E19, "Pumpkin", 25),
    Costume("ridley", Episode.S02E06, "Ripley", 16),
    Costume("sexyvampire", Episode.S02E06, "Sexy Dracula", 17),
    Costume("spidey", Episode.S02E01, "Spiderman", 18),
    Costume("football", Episode.S01E06, "Star Quarterback", 19),
    Costume("toga", Episode.S01E22, "Toga", 32),
    Costume("sewn", Episode.S03E05, "Troy and Abed Sewn Together", 20),
    Costume("troysoldier", Episode.S02E11, "Troy Soldier", 51),
    Costume("werewolf", Episode.S01E09, "Werewolf", 22),
    Costume("woodsman", Episode.S03E07, "Woodsman", 31),
    Costume("zombie", Episode.S02E06, "Zombie", 47)
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
