/* Generated File */
package models.data.character

import models.data.series.Episode
import models.player.{CharacterTemplate, Costume}
import util.BoundingBox

object Shirley extends CharacterTemplate(
  key = "shirley",
  name = "Shirley",
  givenName = "Shirley Bennett",

  costumes = Seq(
    Costume("base", Episode.S01E01, "Shirley Bennett", 1),
    Costume("clubs", Episode.S02E23, "Ace of Clubs", 2),
    Costume("angel", Episode.S03E05, "Angel", 11),
    Costume("space", Episode.S02E04, "Astronaut", 14),
    Costume("babydoll", Episode.S02E11, "Baby Doll", 13),
    Costume("anime", Episode.S03E09, "Big Cheddar", 3),
    Costume("book", Episode.S03E08, "Book", 26),
    Costume("security", Episode.S01E20, "Campus Security", 22),
    Costume("captain", Episode.S01E19, "Captain", 19),
    Costume("chef", Episode.S03E21, "Chef", 4),
    Costume("hurt", Episode.S01E12, "Christmas Brawl", 20),
    Costume("crayon", Episode.S02E13, "Crayon", 5),
    Costume("dark", Episode.S03E04, "Darkest Timeline", 6),
    Costume("fbf", Episode.S03E01, "Finally Be Fine", 23),
    Costume("baby", Episode.S04E01, "Greendale Baby", 16),
    Costume("potter", Episode.S01E07, "Harry Potter", 7),
    Costume("headnurse", Episode.S02E02, "Head Nurse Bennett", 28),
    Costume("poplock", Episode.S02E02, "Heather Popandlocklear", 24),
    Costume("jules", Episode.S02E19, "Jules Winnfield", 21),
    Costume("lingerie", Episode.S03E05, "Magnum's Angel", 25),
    Costume("glinda", Episode.S02E06, "Not Miss Piggy (Glinda)", 8),
    Costume("oprah", Episode.S03E12, "Oprah", 15),
    Costume("planetchristmas", Episode.S03E10, "Planet Christmas", 27),
    Costume("leia", Episode.S04E02, "Princess Leia", 9),
    Costume("sandwiches", Episode.S04E04, "Shirley's Sandwiches", 18),
    Costume("timelinebattle", Episode.S04E13, "Timeline Battle", 17),
    Costume("zippy", Episode.S02E14, "Zip-a-Dee-Doo", 12),
    Costume("zombie", Episode.S02E06, "Zombie", 10)
  ),

  boundingBox = BoundingBox(
    width = 14,
    height = 30,
    duckHeight = 20,
    x = 17,
    y = 18
  ),
  offset = 9
)
