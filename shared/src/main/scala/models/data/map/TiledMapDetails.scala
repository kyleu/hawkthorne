package models.data.map

case class TiledMapDetails(key: String, title: String, soundtrack: String, color: String, images: Map[String, String]) {
  lazy val tilesetImages = images.toIndexedSeq.sortBy(_._1)
}
