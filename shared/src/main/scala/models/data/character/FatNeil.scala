/* Generated File */
package models.data.character

import models.character.{BoundingBox, CharacterTemplate, Costume}
import models.data.series.Episode

object FatNeil {
  val name = "FatNeil"
  val givenName = "Fat Neil"

  val costumes = Seq(
    Costume("base", Episode.S01E01, "Fat Neil", 1),
    Costume("coach", Episode.S04E07, "Coach", 2),
    Costume("duquense", Episode.S02E14, "Duquesne", 3)
  )

  val boundingBox = BoundingBox(
    width = 14,
    height = 37,
    duckHeight = 20,
    x = 17,
    y = 11
  )
  val offset = 6

  val template = CharacterTemplate("fatneil", name, givenName, costumes, boundingBox, offset)
}
