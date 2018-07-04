/* Generated File */
package models.data.character

import models.character.{BoundingBox, CharacterTemplate, Costume}

object Duncan {
  val name = "Duncan"
  val givenName = "Ian Duncan"

  val costumes = Seq(
    Costume("base", "base", "Ian Duncan", 1)
  )

  val boundingBox = BoundingBox(
    width = 14,
    height = 43,
    duckHeight = 20,
    x = 17,
    y = 5
  )
  val offset = 2

  val template = CharacterTemplate("duncan", name, givenName, costumes, boundingBox, offset)
}
