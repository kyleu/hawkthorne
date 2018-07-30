package models.asset

sealed abstract class Asset {
  def key: String
  def path: String
}

object Asset {
  final case class Audio(override val key: String, override val path: String) extends Asset
  def sfx(k: String) = Audio(s"sfx.$k", s"audio/sfx/$k.ogg")
  def music(k: String) = Audio(s"music.$k", s"audio/music/$k.ogg")

  final case class Image(override val key: String, override val path: String) extends Asset

  final case class Spritesheet(override val key: String, override val path: String, width: Int, height: Int) extends Asset
  def spritesheetFromTuple(t: (String, String, Int, Int)) = Spritesheet(t._1, t._2, t._3, t._4)

  final case class Tilemap(override val key: String, override val path: String) extends Asset
}
