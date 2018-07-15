package models.component

trait BaseComponent {
  def update(deltaMs: Double): Unit
}
