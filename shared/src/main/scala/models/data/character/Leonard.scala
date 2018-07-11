/* Generated File */
package models.data.character

import models.character.{BoundingBox, CharacterTemplate, Costume}
import models.data.series.Episode

object Leonard extends CharacterTemplate(
  key = "leonard",
  name = "Leonard",
  givenName = "Leonard Rodriguez",

  costumes = Seq(
    Costume("base", Episode.S01E01, "Leonard Rodriguez", 1),
    Costume("asylum", Episode.S03E19, "Asylum", 2),
    Costume("paintball", Episode.S02E24, "Paintball", 3)
  ),

  boundingBox = BoundingBox(
    width = 14,
    height = 34,
    duckHeight = 20,
    x = 17,
    y = 14
  ),
  offset = 9
)
