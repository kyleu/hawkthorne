/* Generated File */
package models.data.character

import models.character.{BoundingBox, CharacterTemplate, Costume}

object Leonard {
  val name = "Leonard"
  val givenName = "Leonard Rodriguez"

  val costumes = Seq(
    Costume("base", "base", "Leonard Rodriguez", 1),
    Costume("asylum", "s3e19", "Asylum", 2),
    Costume("paintball", "s2e24", "Paintball", 3)
  )

  val boundingBox = BoundingBox(
    width = 14,
    height = 34,
    duckHeight = 20,
    x = 17,
    y = 14
  )
  val offset = 9

  val template = CharacterTemplate("leonard", name, givenName, costumes, boundingBox, offset)
}
