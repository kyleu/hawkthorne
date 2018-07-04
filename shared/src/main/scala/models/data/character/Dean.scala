/* Generated File */
package models.data.character

import models.character.{BoundingBox, CharacterTemplate, Costume}
import models.data.series.Episode

object Dean {
  val name = "Dean"
  val givenName = "Dean Craig Pelton"

  val costumes = Seq(
    Costume("base", Episode.S01E01, "Dean Craig Pelton", 1),
    Costume("bee", Episode.S02E12, "Bumblebee", 8),
    Costume("construction", Episode.S03E22, "Construction", 7),
    Costume("devil", Episode.S03E05, "Devil Dean", 2),
    Costume("donna", Episode.S04E08, "Donna Reed", 10),
    Costume("cowboy", Episode.S04E05, "How-Dean Pilgrims!", 5),
    Costume("jgdiehard", Episode.S05E10, "Joseph Gordon Diehard", 11),
    Costume("mardigras", Episode.S02E21, "Mardi Gras", 3),
    Costume("newdean", Episode.S03E01, "New Dean", 6),
    Costume("conductor", Episode.S03E15, "Train Conductor", 9),
    Costume("unclesam", Episode.S02E17, "Uncle Sam", 4)
  )

  val boundingBox = BoundingBox(
    width = 14,
    height = 34,
    duckHeight = 20,
    x = 17,
    y = 14
  )
  val offset = 8

  val template = CharacterTemplate("dean", name, givenName, costumes, boundingBox, offset)
}
