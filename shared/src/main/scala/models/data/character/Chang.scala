/* Generated File */
package models.data.character

import models.character.{BoundingBox, CharacterTemplate, Costume}

object Chang {
  val name = "Chang"
  val givenName = "Ben Chang"

  val costumes = Seq(
    Costume("base", "base", "Ben Chang", 1),
    Costume("brutalitops", "s2e14", "Brutalitops", 2),
    Costume("butch", "s2e19", "Butch Coolidge", 7),
    Costume("cheerleader", "s2e23", "Cheerleader", 8),
    Costume("dictator", "s3e21", "Dictator", 3),
    Costume("dingleberry", "s5e10", "Dingleberry The Troll", 21),
    Costume("evil", "s4promo", "Evil Chang", 4),
    Costume("father", "s2e18", "Father", 5),
    Costume("popnlock", "s2e2", "Heather Popandlocklear", 17),
    Costume("cannotdie", "s1e13", "I Cannot Die", 11),
    Costume("naked", "s4e1", "Kevin", 20),
    Costume("leather", "s1e16", "Leather Jacket", 18),
    Costume("peggy", "s2e6", "Peggy Fleming", 9),
    Costume("ymca", "s1e19", "Robbed at the YMCA", 13),
    Costume("safety", "s1e24", "Safety First", 6),
    Costume("shaving", "s4e4", "Shaving Cream", 16),
    Costume("soccer", "s2e15", "Soccer Fan", 19),
    Costume("snowman", "s2e11", "Snowman", 14),
    Costume("enterchangment", "s3e14", "That's Enter-chang-ment", 12),
    Costume("understudy", "s3e8", "Understudy", 15),
    Costume("zombie", "s2e6", "Zombie", 10)
  )

  val boundingBox = BoundingBox(
    width = 14,
    height = 34,
    duckHeight = 20,
    x = 17,
    y = 14
  )
  val offset = 8

  val template = CharacterTemplate("chang", name, givenName, costumes, boundingBox, offset)
}
