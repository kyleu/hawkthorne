package models.node

import io.circe.JsonObject
import util.JsonSerializers._

object UnknownNode {
  implicit val jsonEncoder: Encoder[UnknownNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[UnknownNode] = deriveDecoder
}

case class UnknownNode(typ: String, json: JsonObject) extends Node(
  t = "unknown",
  x = json("x").get.asNumber.map(_.toInt.get).getOrElse(0),
  y = json("y").get.asNumber.map(_.toInt.get).getOrElse(0),
  width = json("width").get.asNumber.map(_.toInt.get).getOrElse(0),
  height = json("height").get.asNumber.map(_.toInt.get).getOrElse(0)
)
