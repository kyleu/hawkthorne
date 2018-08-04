package services.input

import models.input.{InputCommand, MenuAction}

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

  def translate(c: InputCommand) = c match {
    case InputCommand.Jump | InputCommand.Confirm | InputCommand.Select => MenuAction.Select
    case InputCommand.Pause => MenuAction.Back
    case _ => throw new IllegalStateException(s"Unhandled command [$c].")
  }

  def update(x: Double, y: Double, commands: Seq[InputCommand]) = {
    val xAct = lastMenuX match {
      case _ if lastMenuX >= -0.5 && x < -0.5 => Some(MenuAction.Left)
      case _ if lastMenuX <= 0.5 && x > 0.5 => Some(MenuAction.Right)
      case _ => None
    }
    val yAct = lastMenuY match {
      case _ if lastMenuY >= -0.5 && y < -0.5 => Some(MenuAction.Up)
      case _ if lastMenuY <= 0.5 && y > 0.5 => Some(MenuAction.Down)
      case _ => None
    }
    lastMenuX = x
    lastMenuY = y
    val acts = xAct.toSeq ++ yAct.toSeq ++ commands.map(c => translate(c))

    if (acts.nonEmpty) {
      menuCallback.getOrElse(throw new IllegalStateException("Menu update called with no active callback."))(acts)
    }
  }
}
