package models.character

case class CharacterTemplate(
    id: String,
    name: String,
    givenName: String,
    costumes: Seq[Costume],
    boundingBox: BoundingBox,
    offset: Int
)
