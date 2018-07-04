/* Generated File */
package models.data.character

import models.character.{BoundingBox, CharacterTemplate, Costume}

object Pierce {
  val name = "Pierce"
  val givenName = "Pierce Hawthorne"

  val costumes = Seq(
    Costume("base", "base", "Pierce Hawthorne", 1),
    Costume("astronaut", "s2e4", "Astronaut", 2),
    Costume("beastmaster", "s1e7", "Beastmaster", 26),
    Costume("naked", "s3e20", "Birthday Suit", 3),
    Costume("canoe", "s1e19", "Canoe", 4),
    Costume("kirk", "s2e6", "Captain Kirk", 5),
    Costume("captain", "s1e19", "Captain Pierce", 19),
    Costume("hurt", "s1e12", "Christmas Brawl", 21),
    Costume("wizard", "s3e20", "Cookie Crisp Wizard", 20),
    Costume("drugs", "s2e13", "Drugs", 6),
    Costume("fatreynolds", "s3e12", "Fat Burt Reynolds", 28),
    Costume("feethands", "s3e5", "Feet Hands", 25),
    Costume("gimp", "s2e19", "The Gimp", 7),
    Costume("popnlock", "s2e2", "Heather Popandlocklear", 27),
    Costume("hotdog", "s2e21", "Hotdog", 8),
    Costume("hulapaint", "s3e7", "Hula Paint Hallucination", 9),
    Costume("janetreno", "s1e16", "Janet Reno", 10),
    Costume("lotus", "s2e3", "Level 5 Laser Lotus", 11),
    Costume("madscientist", "s3e5", "Mad Scientist", 24),
    Costume("magnum", "s3e5", "Magnum", 12),
    Costume("paintball", "s2e24", "Paintball Trooper", 13),
    Costume("dickish", "s2e14", "Pierce the Dickish", 22),
    Costume("pillow", "s3e14", "Pillow Man", 14),
    Costume("planet_christmas", "s3e10", "Planet Christmas", 15),
    Costume("teddy", "s2e11", "Teddy Pierce", 18),
    Costume("western", "s2e23", "Western", 23),
    Costume("wheelchair", "s2e9", "Wheelchair", 16),
    Costume("zombie", "s2e6", "Zombie", 17)
  )

  val boundingBox = BoundingBox(
    width = 14,
    height = 42,
    duckHeight = 20,
    x = 17,
    y = 6
  )
  val offset = 2

  val template = CharacterTemplate("pierce", name, givenName, costumes, boundingBox, offset)
}
