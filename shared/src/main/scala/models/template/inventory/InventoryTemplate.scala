package models.template.inventory

import util.JsonSerializers._

object InventoryTemplate {
  implicit val jsonEncoder: Encoder[InventoryTemplate] = deriveEncoder
  implicit val jsonDecoder: Decoder[InventoryTemplate] = deriveDecoder
}

case class InventoryTemplate(
    key: String,
    name: String,
    section: String,
    info: String,
    maxItems: Int
) {
  lazy val json = {
    this.asJson.spaces2
  }
}
