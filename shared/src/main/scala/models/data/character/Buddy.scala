/* Generated File */
package models.data.character

import models.character.{BoundingBox, CharacterTemplate, Costume}
import models.data.series.Episode

object Buddy extends CharacterTemplate(
  key = "buddy",
  name = "Buddy",
  givenName = "Buddy",

  costumes = Seq(
    Costume("base", Episode.S01E01, "Buddy", 1),
    Costume("master_exploder", Episode.S00E01, "Master Exploder", 2)
  ),

  boundingBox = BoundingBox(
    width = 14,
    height = 36,
    duckHeight = 20,
    x = 17,
    y = 12
  ),
  offset = 7
)
