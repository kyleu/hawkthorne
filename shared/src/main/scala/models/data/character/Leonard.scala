/* Generated File */
package models.data.character

import models.character.{BoundingBox, CharacterTemplate, Costume}
import models.data.series.Episode

object Leonard {
  val name = "Leonard"
  val givenName = "Leonard Rodriguez"

  val costumes = Seq(
    Costume("base", Episode.S01E01, "Leonard Rodriguez", 1),
    Costume("asylum", Episode.S03E19, "Asylum", 2),
    Costume("paintball", Episode.S02E24, "Paintball", 3)
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
