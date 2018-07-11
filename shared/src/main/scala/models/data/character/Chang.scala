/* Generated File */
package models.data.character

import models.character.{BoundingBox, CharacterTemplate, Costume}
import models.data.series.Episode

object Chang extends CharacterTemplate(
  key = "chang",
  name = "Chang",
  givenName = "Ben Chang",

  costumes = Seq(
    Costume("base", Episode.S01E01, "Ben Chang", 1),
    Costume("brutalitops", Episode.S02E14, "Brutalitops", 2),
    Costume("butch", Episode.S02E19, "Butch Coolidge", 7),
    Costume("cheerleader", Episode.S02E23, "Cheerleader", 8),
    Costume("dictator", Episode.S03E21, "Dictator", 3),
    Costume("dingleberry", Episode.S05E10, "Dingleberry The Troll", 21),
    Costume("evil", Episode.S04E01, "Evil Chang", 4),
    Costume("father", Episode.S02E18, "Father", 5),
    Costume("popnlock", Episode.S02E02, "Heather Popandlocklear", 17),
    Costume("cannotdie", Episode.S01E13, "I Cannot Die", 11),
    Costume("naked", Episode.S04E01, "Kevin", 20),
    Costume("leather", Episode.S01E16, "Leather Jacket", 18),
    Costume("peggy", Episode.S02E06, "Peggy Fleming", 9),
    Costume("ymca", Episode.S01E19, "Robbed at the YMCA", 13),
    Costume("safety", Episode.S01E24, "Safety First", 6),
    Costume("shaving", Episode.S04E04, "Shaving Cream", 16),
    Costume("soccer", Episode.S02E15, "Soccer Fan", 19),
    Costume("snowman", Episode.S02E11, "Snowman", 14),
    Costume("enterchangment", Episode.S03E14, "That's Enter-chang-ment", 12),
    Costume("understudy", Episode.S03E08, "Understudy", 15),
    Costume("zombie", Episode.S02E06, "Zombie", 10)
  ),

  boundingBox = BoundingBox(
    width = 14,
    height = 34,
    duckHeight = 20,
    x = 17,
    y = 14
  ),
  offset = 8
)
