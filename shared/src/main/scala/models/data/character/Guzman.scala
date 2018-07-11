/* Generated File */
package models.data.character

import models.character.{BoundingBox, CharacterTemplate, Costume}
import models.data.series.Episode

object Guzman extends CharacterTemplate(
  key = "guzman",
  name = "Guzman",
  givenName = "Luis Guzman",

  costumes = Seq(
    Costume("base", Episode.S01E01, "Luis Guzman", 1)
  ),

  boundingBox = BoundingBox(
    width = 14,
    height = 41,
    duckHeight = 20,
    x = 17,
    y = 7
  ),
  offset = 4
)
