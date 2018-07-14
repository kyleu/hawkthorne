package services.input

import models.player.PlayerSprite

class InputHandler(players: IndexedSeq[PlayerSprite]) {
  def process(elapsed: Double, playerIdx: Int, velocity: (Double, Double), events: Seq[String]) = {
    val p = players(playerIdx)

    val speed = 250

    val xDelta = velocity._1 * elapsed * speed
    val yDelta = velocity._2 * elapsed * speed

    p.sprite.x = p.sprite.x + xDelta
    p.sprite.y = p.sprite.y + yDelta

    //println(s"Process: [$playerIdx]: ${velocity._1}:${velocity._2} - ${events.mkString(", ")}")
  }
}
