package models.node

import io.circe.JsonObject
import util.JsonSerializers._

object UnknownNode {
  val key = "unknown"
  implicit val jsonEncoder: Encoder[UnknownNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[UnknownNode] = deriveDecoder
}

case class UnknownNode(typ: String, json: JsonObject) extends Node(UnknownNode.key) {
  override val id = json("id").get.asNumber.map(_.toInt.get).getOrElse(0)
  override val name = json("name").get.asString.getOrElse("?")
  override val x = json("x").get.asNumber.map(_.toInt.get).getOrElse(0)
  override val y = json("y").get.asNumber.map(_.toInt.get).getOrElse(0)
  override val width = json("width").get.asNumber.map(_.toInt.get).getOrElse(0)
  override val height = json("height").get.asNumber.map(_.toInt.get).getOrElse(0)
  override val rotation = json("rotation").get.asNumber.get.toInt.getOrElse(0)
  override val visible = json("visible").get.asBoolean.get
}
