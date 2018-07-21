package models.component

import com.definitelyscala.phaserce.Game

object BaseComponent {
  trait Resizable {
    def resize(width: Int, height: Int): Unit
  }
}

trait BaseComponent {
  def game: Game
  def name: String

  def x: Int
  def y: Int

  def update(deltaMs: Double): Unit = ()
}
