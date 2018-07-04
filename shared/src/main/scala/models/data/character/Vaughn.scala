/* Generated File */
package models.data.character

import models.character.{BoundingBox, CharacterTemplate, Costume}
import models.data.series.Episode

object Vaughn {
  val name = "Vaughn"
  val givenName = "Vaughn Miller"

  val costumes = Seq(
    Costume("base", Episode.S01E01, "Vaughn Miller", 1)
  )

  val boundingBox = BoundingBox(
    width = 14,
    height = 39,
    duckHeight = 20,
    x = 17,
    y = 9
  )
  val offset = 8

  val template = CharacterTemplate("vaughn", name, givenName, costumes, boundingBox, offset)
}
