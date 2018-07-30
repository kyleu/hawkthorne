package services.input

import models.input.{InputUpdate, MenuAction}

class MenuInputHandler() {
  private[this] var lastMenuX = 0.0
  private[this] var lastMenuY = 0.0

  private[this] var menuCallback: Option[Seq[MenuAction] => Unit] = None

  def enabled = menuCallback.isDefined

  def setCallback(f: Option[Seq[MenuAction] => Unit] = None) = {
    lastMenuX = 0.0
    lastMenuY = 0.0
    menuCallback = f
  }

  def translate(c: String) = c match {
    case "jump" | "confirm" => MenuAction.Select
    case _ => throw new IllegalStateException(s"Unhandled command [$c].")
  }

  def update(u: InputUpdate) = {
    val xAct = lastMenuX match {
      case _ if lastMenuX >= -0.5 && u.x < -0.5 => Some(MenuAction.Left)
      case _ if lastMenuX <= 0.5 && u.x > 0.5 => Some(MenuAction.Right)
      case _ => None
    }
    val yAct = lastMenuY match {
      case _ if lastMenuY >= -0.5 && u.y < -0.5 => Some(MenuAction.Up)
      case _ if lastMenuY <= 0.5 && u.y > 0.5 => Some(MenuAction.Down)
      case _ => None
    }
    lastMenuX = u.x
    lastMenuY = u.y
    val acts = xAct.toSeq ++ yAct.toSeq ++ u.commands.map(c => translate(c))

    if (acts.nonEmpty) {
      menuCallback.getOrElse(throw new IllegalStateException("Menu update called with no active callback."))(acts)
    }
  }
}
