/* Generated File */
package models.data.character

import models.character.{BoundingBox, CharacterTemplate, Costume}
import models.data.series.Episode

object Vaughn extends CharacterTemplate(
  key = "vaughn",
  name = "Vaughn",
  givenName = "Vaughn Miller",

  costumes = Seq(
    Costume("base", Episode.S01E01, "Vaughn Miller", 1)
  ),

  boundingBox = BoundingBox(
    width = 14,
    height = 39,
    duckHeight = 20,
    x = 17,
    y = 9
  ),
  offset = 8
)
