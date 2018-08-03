package services.intro

import com.definitelyscala.phaserce.{Game, Group, Point}
import models.component.StaticSprite
import util.PhaserUtils

class IntroScan(game: Game, onComplete: () => Unit) {
  private[this] var elapsed = 0.0

  private[this] val margin = 20.0
  private[this] val dimensions = (400 + (margin * 2)) -> (250 + (margin * 2))

  private[this] val charHorizontalOffset = 36 + margin
  private[this] val charVerticalOffset = 28 + margin
  private[this] val labelOffset = charHorizontalOffset + IntroAssets.charHeight
  private[this] val rightStartEdge = dimensions._1 - charHorizontalOffset - IntroAssets.charWidth - 1

  val group = new Group(game = game, name = s"intro.scan")

  val backdrop = PhaserUtils.makeBackdrop(game, color = "#3854b3")
  group.add(backdrop)

  private[this] val background = StaticSprite(game = game, group = group, name = "background", key = "intro.backgrounds")
  background.x = margin
  background.y = margin

  private[this] val characters = Seq("jeff", "britta", "abed", "shirley", "annie", "troy", "pierce")
  private[this] val charSprites = characters.map(key => StaticSprite(game = game, group = group, name = s"${key}scan", key = s"intro.${key}scan"))
  charSprites.foreach { s =>
    s.x = charHorizontalOffset
    s.y = charVerticalOffset
    s.visible = false
  }

  private[this] val computer = StaticSprite(game = game, group = group, name = "computer", key = "intro.computer")
  computer.x = (dimensions._1 - 75) / 2
  computer.y = 160

  private[this] val inverted = StaticSprite(game = game, group = group, name = "inverted", key = "intro.invertedscan")
  inverted.x = charHorizontalOffset
  inverted.y = charVerticalOffset
  inverted.visible = false

  private[this] val description = StaticSprite(game = game, group = group, name = "description", key = "intro.description")
  description.x = charHorizontalOffset
  description.y = labelOffset

  private[this] val name = StaticSprite(game = game, group = group, name = "name", key = "intro.names")
  name.x = (dimensions._1 - 75) / 2
  name.y = charVerticalOffset + 5

  private[this] val scanBlank = StaticSprite(game = game, group = group, name = "scanBlank", key = "intro.blankscan")
  scanBlank.x = rightStartEdge
  scanBlank.y = charVerticalOffset

  private[this] val scanSprites = StaticSprite(game = game, group = group, name = "scanSprites", key = "intro.invertedsprites")
  scanSprites.x = rightStartEdge
  scanSprites.y = charVerticalOffset
  scanSprites.visible = false

  private[this] val scanningBar = StaticSprite(game = game, group = group, name = "scanningBar", key = "intro.scanningbar")
  scanningBar.x = rightStartEdge
  scanningBar.y = labelOffset

  private[this] val scanningWords = StaticSprite(game = game, group = group, name = "scanningWords", key = "intro.scanningwords")
  scanningWords.x = rightStartEdge
  scanningWords.y = labelOffset + 16

  private[this] val events = Seq(
    IntroAnimations.backgroundEvents(background.sprite, characters),
    IntroAnimations.characterEvents(inverted.sprite, characters.zip(charSprites.map(_.sprite))),
    IntroAnimations.computerEvents(computer.sprite, characters.size),
    IntroAnimations.descriptionEvents(description.sprite, characters.size),
    IntroAnimations.nameEvents(name.sprite, characters.size),
    IntroAnimations.progressEvents(scanningBar.sprite, characters.size),
    IntroAnimations.scanEvents(scanBlank.sprite, scanSprites.sprite, characters.size),
    IntroAnimations.wordsEvents(scanningWords.sprite, characters.size),
    IntroAnimations.onComplete(onComplete)
  ).flatten.sortBy(x => x.delay)
  private[this] val eventQueue = collection.mutable.Queue.apply(events: _*)

  resize(game.width.toInt, game.height.toInt)
  game.world.add(group)

  def update(dt: Double) = {
    elapsed += dt

    while (eventQueue.headOption.exists(_.delay < elapsed)) {
      eventQueue.dequeue().trigger()
    }
  }

  def resize(width: Int, height: Int) = {
    backdrop.width = game.width * 2
    backdrop.height = game.height * 2
    backdrop.position = new Point(-width.toDouble, -height.toDouble)

    util.PhaserUtils.simpleResize(group, width, height, dimensions._1.toInt -> dimensions._2.toInt)
  }

  def destroy() = {
    game.world.remove(group)
    group.destroy(destroyChildren = true)
  }
}
