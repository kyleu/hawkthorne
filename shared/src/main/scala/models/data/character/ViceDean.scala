/* Generated File */
package models.data.character

import models.data.series.Episode
import models.player.Costume
import models.template.character.CharacterTemplate
import util.BoundingBox

object ViceDean extends CharacterTemplate(
  key = "vicedean",
  name = "ViceDean",
  givenName = "Vice Dean Laybourne",

  costumes = Seq(
    Costume("base", Episode.S03E20, "Vice Dean Laybourne", 1),
    Costume("ghost", Episode.S03E22, "Ghost", 2),
    Costume("stuff", Episode.S03E13, "Going Through Some Stuff", 4),
    Costume("pajamas", Episode.S03E13, "Pajamas", 3)
  ),

  boundingBox = BoundingBox(
    width = 14,
    height = 44,
    duckHeight = 20,
    x = 17,
    y = 4
  ),
  offset = 2
)
