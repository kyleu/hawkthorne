/* Generated File */
package models.data.character

import models.character.{BoundingBox, CharacterTemplate, Costume}

object Buddy {
  val name = "Buddy"
  val givenName = "Buddy"

  val costumes = Seq(
    Costume("base", "base", "Buddy", 1),
    Costume("master_exploder", "fanmade", "Master Exploder", 2)
  )

  val boundingBox = BoundingBox(
    width = 14,
    height = 36,
    duckHeight = 20,
    x = 17,
    y = 12
  )
  val offset = 7

  val template = CharacterTemplate("buddy", name, givenName, costumes, boundingBox, offset)
}
