/* Generated File */
package models.data.character

import models.character.{BoundingBox, CharacterTemplate, Costume}

object Shirley {
  val name = "Shirley"
  val givenName = "Shirley Bennett"

  val costumes = Seq(
    Costume("base", "base", "Shirley Bennett", 1),
    Costume("clubs", "s2e23", "Ace of Clubs", 2),
    Costume("angel", "s3e5", "Angel", 11),
    Costume("space", "s2e4", "Astronaut", 14),
    Costume("babydoll", "s2e11", "Baby Doll", 13),
    Costume("anime", "s3e9", "Big Cheddar", 3),
    Costume("book", "s3e8", "Book", 26),
    Costume("security", "s1e20", "Campus Security", 22),
    Costume("captain", "s1e19", "Captain", 19),
    Costume("chef", "s3e21", "Chef", 4),
    Costume("hurt", "s1e12", "Christmas Brawl", 20),
    Costume("crayon", "s2e13", "Crayon", 5),
    Costume("dark", "s3e4", "Darkest Timeline", 6),
    Costume("fbf", "s3e1", "Finally Be Fine", 23),
    Costume("baby", "s4e1", "Greendale Baby", 16),
    Costume("potter", "s1e7", "Harry Potter", 7),
    Costume("headnurse", "s2e2", "Head Nurse Bennett", 28),
    Costume("poplock", "s2e2", "Heather Popandlocklear", 24),
    Costume("jules", "s2e19", "Jules Winnfield", 21),
    Costume("lingerie", "s3e5", "Magnum's Angel", 25),
    Costume("glinda", "s2e6", "Not Miss Piggy (Glinda)", 8),
    Costume("oprah", "s3e12", "Oprah", 15),
    Costume("planetchristmas", "s3e10", "Planet Christmas", 27),
    Costume("leia", "s4e2", "Princess Leia", 9),
    Costume("sandwiches", "s4e4", "Shirley's Sandwiches", 18),
    Costume("timelinebattle", "s4e13", "Timeline Battle", 17),
    Costume("zippy", "s2e14", "Zip-a-Dee-Doo", 12),
    Costume("zombie", "s2e6", "Zombie", 10)
  )

  val boundingBox = BoundingBox(
    width = 14,
    height = 30,
    duckHeight = 20,
    x = 17,
    y = 18
  )
  val offset = 9

  val template = CharacterTemplate("shirley", name, givenName, costumes, boundingBox, offset)
}
