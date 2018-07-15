package services.input

class MenuInputHandler(menu: String) {
  private[this] var lastVelocity = 0.0 -> 0.0

  def process(elapsed: Double, velocity: (Double, Double), events: Seq[String]) = {
    lastVelocity._1 match {
      case x if x <= 0.0 && velocity._1 > 0.0 => // menu.onRight
      case x if x <= 0.0 && velocity._1 < 0.0 => // menu.onLeft
      case _ => // noop
    }
    lastVelocity._2 match {
      case y if y <= 0.0 && velocity._2 > 0.0 => // menu.onUp
      case y if y <= 0.0 && velocity._2 < 0.0 => // menu.onDown
      case _ => // noop
    }

    lastVelocity = velocity
  }
}
