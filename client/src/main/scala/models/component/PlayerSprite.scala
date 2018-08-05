package models.component

import com.definitelyscala.phaserce.{Game, Group}
import models.data.character.CharacterAnimation
import models.game.GameUpdate
import models.input.InputCommand
import models.player.Player
import services.input.PlayerInputHandler

object PlayerSprite {
  val animations = CharacterAnimation.values.flatMap(a => Seq(a.leftAnim, a.rightAnim)).map(a => a.id -> a).toMap
}

class PlayerSprite(override val game: Game, group: Group, player: Player, initialX: Int, initialY: Int) extends SimpleComponent {
  override val name = s"player.${player.idx}"

  val as = AnimatedSprite(
    game = game, group = group, name = s"player.${player.idx}",
    key = s"${player.templateKey}.${player.costume.key}", animations = PlayerSprite.animations.mapValues(_.newCopy), defAnim = Some("idle.right")
  )
  override def comp = as.sprite
  as.x = initialX.toDouble
  as.y = initialY.toDouble

  private[this] val input = new PlayerInputHandler(this)

  def processInput(delta: Double, playerInput: GameUpdate.PlayerInput) = input.process(delta = delta, input = playerInput)

  as.sprite.name = s"${player.templateKey}.${player.costume.key}"
  as.sprite.anchor = util.PhaserUtils.centerPoint

  override def update(deltaMs: Double) = as.update(deltaMs)
}
