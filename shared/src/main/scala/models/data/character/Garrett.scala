/* Generated File */
package models.data.character

import models.character.{BoundingBox, CharacterTemplate, Costume}

object Garrett {
  val name = "Garrett"
  val givenName = "Garrett Lambert"

  val costumes = Seq(
    Costume("base", "base", "Garrett Lambert", 1),
    Costume("jammies", "s3e13", "Camo Jammies", 2),
    Costume("alien", "s1e5", "Creepy Alien", 3)
  )

  val boundingBox = BoundingBox(
    width = 14,
    height = 43,
    duckHeight = 20,
    x = 17,
    y = 5
  )
  val offset = 2

  val template = CharacterTemplate("garrett", name, givenName, costumes, boundingBox, offset)
}
