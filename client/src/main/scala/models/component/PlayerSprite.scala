package models.component

import com.definitelyscala.phaserce.{Game, Group}
import models.data.character.CharacterAnimation
import models.input.InputCommand
import models.player.Player
import services.input.PlayerInputHandler

object PlayerSprite {
  val animations = CharacterAnimation.values.flatMap(a => Seq(a.leftAnim, a.rightAnim)).map(a => a.id -> a).toMap
}

class PlayerSprite(override val game: Game, group: Group, player: Player, initialX: Int, initialY: Int) extends BaseComponent {
  override val name = s"player.${player.idx}"

  val as = AnimatedSprite(
    game = game, group = group, name = s"player.${player.idx}",
    key = s"${player.templateKey}.${player.costume.key}", animations = PlayerSprite.animations.mapValues(_.newCopy), defAnim = Some("idle.right")
  )
  as.x = initialX.toDouble
  as.y = initialY.toDouble

  private[this] val input = new PlayerInputHandler(this)

  def processInput(delta: Double, velocity: (Double, Double), commands: Seq[InputCommand]) = {
    input.process(delta = delta, velocity = velocity, events = commands)
  }

  as.sprite.name = s"${player.templateKey}.${player.costume.key}"
  as.sprite.anchor = util.PhaserUtils.centerPoint

  override def update(deltaMs: Double) = as.update(deltaMs)

  override def x = as.x
  override def x_=(newX: Double) = as.x = newX
  override def y = as.y
  override def y_=(newY: Double) = as.y = newY

  override def visible = as.visible
  override def visible_=(v: Boolean) = as.visible = v
}
