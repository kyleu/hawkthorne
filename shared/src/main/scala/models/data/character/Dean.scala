/* Generated File */
package models.data.character

import models.character.{BoundingBox, CharacterTemplate, Costume}

object Dean {
  val name = "Dean"
  val givenName = "Dean Craig Pelton"

  val costumes = Seq(
    Costume("base", "base", "Dean Craig Pelton", 1),
    Costume("bee", "s2e12", "Bumblebee", 8),
    Costume("construction", "s3e22", "Construction", 7),
    Costume("devil", "s3e5", "Devil Dean", 2),
    Costume("donna", "s4e8", "Donna Reed", 10),
    Costume("cowboy", "s4e5", "How-Dean Pilgrims!", 5),
    Costume("jgdiehard", "s5e10", "Joseph Gordon Diehard", 11),
    Costume("mardigras", "s2e21", "Mardi Gras", 3),
    Costume("newdean", "s3e1", "New Dean", 6),
    Costume("conductor", "s3e15", "Train Conductor", 9),
    Costume("unclesam", "s2e17", "Uncle Sam", 4)
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
