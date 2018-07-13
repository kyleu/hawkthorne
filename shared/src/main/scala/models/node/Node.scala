package models.node

import util.JsonSerializers._

object Node {
  implicit val jsonEncoder: Encoder[Node] = NodeEncoder.jsonEncoder
  implicit val jsonDecoder: Decoder[Node] = NodeDecoder.jsonDecoder

  def parse(o: Json) = o.as[Node] match {
    case Right(x) => x
    case Left(x) => throw new IllegalStateException(s"Cannot parse Node from [${o.noSpaces}].", x)
  }

  def parseString(s: String) = parse(parseJson(s).right.getOrElse(throw new IllegalStateException(s"Invalid node json: $s")))
}

abstract class Node(val t: String, val x: Int, val y: Int, val width: Int, val height: Int)
