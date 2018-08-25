/* Generated File */
package models.data.character

import models.data.series.Episode
import models.player.Costume
import models.template.character.CharacterTemplate
import util.BoundingBox

object Pierce extends CharacterTemplate(
  key = "pierce",
  name = "Pierce",
  givenName = "Pierce Hawthorne",

  costumes = Seq(
    Costume("base", Episode.S03E20, "Pierce Hawthorne", 1),
    Costume("astronaut", Episode.S02E04, "Astronaut", 2),
    Costume("beastmaster", Episode.S01E07, "Beastmaster", 26),
    Costume("naked", Episode.S03E20, "Birthday Suit", 3),
    Costume("canoe", Episode.S01E19, "Canoe", 4),
    Costume("kirk", Episode.S02E06, "Captain Kirk", 5),
    Costume("captain", Episode.S01E19, "Captain Pierce", 19),
    Costume("hurt", Episode.S01E12, "Christmas Brawl", 21),
    Costume("wizard", Episode.S03E20, "Cookie Crisp Wizard", 20),
    Costume("drugs", Episode.S02E13, "Drugs", 6),
    Costume("fatreynolds", Episode.S03E12, "Fat Burt Reynolds", 28),
    Costume("feethands", Episode.S03E05, "Feet Hands", 25),
    Costume("gimp", Episode.S02E19, "The Gimp", 7),
    Costume("popnlock", Episode.S02E02, "Heather Popandlocklear", 27),
    Costume("hotdog", Episode.S02E21, "Hotdog", 8),
    Costume("hulapaint", Episode.S03E07, "Hula Paint Hallucination", 9),
    Costume("janetreno", Episode.S01E16, "Janet Reno", 10),
    Costume("lotus", Episode.S02E03, "Level 5 Laser Lotus", 11),
    Costume("madscientist", Episode.S03E05, "Mad Scientist", 24),
    Costume("magnum", Episode.S03E05, "Magnum", 12),
    Costume("paintball", Episode.S02E24, "Paintball Trooper", 13),
    Costume("dickish", Episode.S02E14, "Pierce the Dickish", 22),
    Costume("pillow", Episode.S03E14, "Pillow Man", 14),
    Costume("planet_christmas", Episode.S03E10, "Planet Christmas", 15),
    Costume("teddy", Episode.S02E11, "Teddy Pierce", 18),
    Costume("western", Episode.S02E23, "Western", 23),
    Costume("wheelchair", Episode.S02E09, "Wheelchair", 16),
    Costume("zombie", Episode.S02E06, "Zombie", 17)
  ),

  boundingBox = BoundingBox(
    width = 14,
    height = 42,
    duckHeight = 20,
    x = 17,
    y = 6
  ),
  offset = 2
)
