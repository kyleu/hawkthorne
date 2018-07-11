/* Generated File */
package models.data.character

import models.character.{BoundingBox, CharacterTemplate, Costume}
import models.data.series.Episode

object Vicki extends CharacterTemplate(
  key = "vicki",
  name = "Vicki",
  givenName = "Vicki Cooper",

  costumes = Seq(
    Costume("base", Episode.S01E01, "Vicki Cooper", 1),
    Costume("knight", Episode.S03E19, "Chess Knight", 2)
  ),

  boundingBox = BoundingBox(
    width = 14,
    height = 35,
    duckHeight = 20,
    x = 17,
    y = 13
  ),
  offset = 7
)
