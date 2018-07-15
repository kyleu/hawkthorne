package models.asset

sealed abstract class Asset {
  def key: String
  def path: String
}

object Asset {
  case class Audio(override val key: String, override val path: String) extends Asset
  case class Image(override val key: String, override val path: String) extends Asset
  case class Spritesheet(override val key: String, override val path: String, width: Int, height: Int) extends Asset
  case class Tilemap(override val key: String, override val path: String) extends Asset
}
