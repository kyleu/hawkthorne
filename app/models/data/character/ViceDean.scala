/* Generated File */
package models.data.character

import models.character.{BoundingBox, CharacterTemplate, Costume}

object ViceDean {
  val name = "ViceDean"
  val givenName = "Vice Dean Laybourne"

  val costumes = Seq(
    Costume("base", "base", "Vice Dean Laybourne", 1),
    Costume("ghost", "s3e22", "Ghost", 2),
    Costume("stuff", "s3e13", "Going Through Some Stuff", 4),
    Costume("pajamas", "s3e13", "Pajamas", 3)
  )

  val boundingBox = BoundingBox(
    width = 14,
    height = 44,
    duckHeight = 20,
    x = 17,
    y = 4
  )
  val offset = 2

  val template = CharacterTemplate("vicedean", name, givenName, costumes, boundingBox, offset)
}
