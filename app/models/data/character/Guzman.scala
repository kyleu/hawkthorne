/* Generated File */
package models.data.character

import models.character.{BoundingBox, CharacterTemplate, Costume}

object Guzman {
  val name = "Guzman"
  val givenName = "Luis Guzman"

  val costumes = Seq(
    Costume("base", "base", "Luis Guzman", 1)
  )

  val boundingBox = BoundingBox(
    width = 14,
    height = 41,
    duckHeight = 20,
    x = 17,
    y = 7
  )
  val offset = 4

  val template = CharacterTemplate("guzman", name, givenName, costumes, boundingBox, offset)
}
