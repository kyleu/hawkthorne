package models.template.character

import models.player.Costume
import util.BoundingBox
import util.JsonSerializers._

import scala.util.Random

object CharacterTemplate {
  implicit val jsonEncoder: Encoder[CharacterTemplate] = deriveEncoder
  implicit val jsonDecoder: Decoder[CharacterTemplate] = deriveDecoder
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
  def relatedCostume(c: Costume) = costumeMap.get(c.key).orElse(costumes.find(_.episode == c.episode))
  def randomCostume = costumes(Random.nextInt(costumes.size))
}
