/* Generated File */
package models.data.character

import models.character.{BoundingBox, CharacterTemplate, Costume}
import models.data.series.Episode

object Gilbert extends CharacterTemplate(
  key = "gilbert",
  name = "Gilbert",
  givenName = "Gilbert Lawson",

  costumes = Seq(
    Costume("base", Episode.S01E01, "Gilbert Lawson", 1)
  ),

  boundingBox = BoundingBox(
    width = 14,
    height = 38,
    duckHeight = 20,
    x = 17,
    y = 10
  ),
  offset = 7
)
