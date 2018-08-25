/* Generated File */
package models.data.character

import models.data.series.Episode
import models.player.Costume
import models.template.character.CharacterTemplate
import util.BoundingBox

object Vaughn extends CharacterTemplate(
  key = "vaughn",
  name = "Vaughn",
  givenName = "Vaughn Miller",

  costumes = Seq(
    Costume("base", Episode.S03E20, "Vaughn Miller", 1)
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
