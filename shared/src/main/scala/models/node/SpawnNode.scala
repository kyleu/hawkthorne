package models.node

import util.JsonSerializers._

object SpawnNode {
  object Props {
    implicit val jsonEncoder: Encoder[Props] = deriveEncoder
    implicit val jsonDecoder: Decoder[Props] = deriveDecoder
  }

  case class Props(
      enemytype: Option[String],
      infinite: Option[String],
      initialState: Option[String],
      key: Option[String],
      lastspawn: Option[String],
      message: Option[String],
      nodeType: Option[String],
      offset_x: Option[String],
      offset_y: Option[String],
      sound: Option[String],
      spawnMax: Option[String],
      spawnType: Option[String],
      spawntime: Option[String],
      sprite: Option[String],
      velocityX: Option[String],
      velocityY: Option[String],
      x_Proximity: Option[String],
      y_Proximity: Option[String]
  )

  val key = "spawn"
  implicit val jsonEncoder: Encoder[SpawnNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[SpawnNode] = deriveDecoder
}

case class SpawnNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int,
    override val rotation: Option[Int],
    override val visible: Option[Boolean],
    properties: SpawnNode.Props
) extends Node(SpawnNode.key)
