package services.input

import models.input.InputUpdate

class MenuInputHandler() {
  private[this] var lastMenuX = 0.0
  private[this] var lastMenuY = 0.0

  private[this] var menuCallback: Option[Seq[String] => Unit] = None

  def enabled = menuCallback.isDefined

  def setCallback(f: Option[Seq[String] => Unit] = None) = {
    lastMenuX = 0.0
    lastMenuY = 0.0
    menuCallback = f
  }

  def update(u: InputUpdate) = {
    val xAct = lastMenuX match {
      case _ if lastMenuX >= -0.5 && u.x < -0.5 => Some("Left")
      case _ if lastMenuX <= 0.5 && u.x > 0.5 => Some("Right")
      case _ => None
    }
    val yAct = lastMenuY match {
      case _ if lastMenuY >= -0.5 && u.y < -0.5 => Some("Up")
      case _ if lastMenuY <= 0.5 && u.y > 0.5 => Some("Down")
      case _ => None
    }
    lastMenuX = u.x
    lastMenuY = u.y
    val acts = xAct.toSeq ++ yAct.toSeq

    if (acts.nonEmpty) {
      menuCallback.getOrElse(throw new IllegalStateException("Menu update called with no active callback."))(acts)
    }
  }
}
