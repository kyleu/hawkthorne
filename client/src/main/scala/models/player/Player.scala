package models.player

import com.definitelyscala.phaserce.{Game, Sprite}
import models.character.{CharacterTemplate, Costume}
import models.data.Animation

import scala.util.Random

class Player(actor: CharacterTemplate, costume: Costume, x: Double, y: Double, game: Game) extends Sprite(game, x, y, s"${actor.id}.${costume.key}") {
  this.name = s"${actor.id}.${costume.key}"
  game.add.existing(this)

  private[this] def coordsFor(seq: Seq[(Int, Int)]) = scalajs.js.Array(seq.map(x => (x._1 * 12.0) + x._2): _*)

  override def update() = if (Random.nextInt(30) == 0) {
    this.frame = Random.nextInt(12 * 16)
  }
}
