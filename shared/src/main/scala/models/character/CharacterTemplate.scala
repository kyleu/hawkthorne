package models.character

case class CharacterTemplate(
    id: String,
    name: String,
    givenName: String,
    costumes: Seq[Costume],
    boundingBox: BoundingBox,
    offset: Int
) {
  private[this] def costumeMap = costumes.map(c => c.key -> c).toMap
  def costume(k: String) = costumeMap.getOrElse(k, throw new IllegalStateException(s"Character [$id] has no costume [$k]."))
}
