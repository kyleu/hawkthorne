package models.game.obj

import util.JsonSerializers._

object Vehicle {
  implicit val jsonEncoder: Encoder[Vehicle] = deriveEncoder
  implicit val jsonDecoder: Decoder[Vehicle] = deriveDecoder

  val key = "vehicle"
}

final case class Vehicle(
    override val id: Int,
    override val n: String,
    override val loc: util.Rectangle,
    override val vis: Boolean
) extends GameObject(Vehicle.key)
