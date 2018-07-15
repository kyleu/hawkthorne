package models.component

object BaseComponent {
  trait Resizable {
    def resize(width: Double, height: Double): Unit
  }
}

trait BaseComponent {
  def update(deltaMs: Double): Unit = ()
}
