package models.animation

case class Animation(id: String, frames: Seq[Int], duration: Double, loop: Boolean) {
}
