/* Generated File */
package models.data.character

import models.character.{BoundingBox, CharacterTemplate, Costume}

object Rich {
  val name = "Rich"
  val givenName = "Dr. Rich Stephenson"

  val costumes = Seq(
    Costume("base", "base", "Dr. Rich Stephenson", 1)
  )

  val boundingBox = BoundingBox(
    width = 14,
    height = 43,
    duckHeight = 20,
    x = 17,
    y = 5
  )
  val offset = 2

  val template = CharacterTemplate("rich", name, givenName, costumes, boundingBox, offset)
}
