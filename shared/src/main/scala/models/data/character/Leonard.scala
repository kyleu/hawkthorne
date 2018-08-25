/* Generated File */
package models.data.character

import models.data.series.Episode
import models.player.Costume
import models.template.character.CharacterTemplate
import util.BoundingBox

object Leonard extends CharacterTemplate(
  key = "leonard",
  name = "Leonard",
  givenName = "Leonard Rodriguez",

  costumes = Seq(
    Costume("base", Episode.S03E20, "Leonard Rodriguez", 1),
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
