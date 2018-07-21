package models.player

import models.data.character._
import util.BoundingBox
import util.JsonSerializers._

object CharacterTemplate {
  implicit val jsonEncoder: Encoder[CharacterTemplate] = deriveEncoder
  implicit val jsonDecoder: Decoder[CharacterTemplate] = deriveDecoder

  lazy val greendaleSeven = Seq(Abed, Annie, Britta, Jeff, Pierce, Shirley, Troy)
  lazy val classmates = Seq(Buddy, FatNeil, Garrett, Leonard, Vaughn, Vicki)
  lazy val teachers = Seq(Chang, Dean, Duncan, Rich, ViceDean)

  lazy val all = Seq(
    Abed, Annie, Britta, Buddy, Chang, Dean, Duncan, FatNeil, Garrett, Gilbert,
    Guzman, Jeff, Leonard, Pierce, Rich, Shirley, Troy, Vaughn, ViceDean, Vicki
  )

  lazy val allCostumes = all.flatMap(c => c.costumes.map(c -> _))

  def withKey(key: String) = all.find(_.key == key).getOrElse(throw new IllegalStateException(s"No character [$key]."))
}

case class CharacterTemplate(
    key: String,
    name: String,
    givenName: String,
    costumes: Seq[Costume],
    boundingBox: BoundingBox,
    offset: Int
) {
  private[this] def costumeMap = costumes.map(c => c.key -> c).toMap
  def costume(k: String) = costumeMap.getOrElse(k, throw new IllegalStateException(s"Character [$key] has no costume [$k]."))
}
