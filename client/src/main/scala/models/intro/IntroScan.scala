package models.intro

import com.definitelyscala.phaserce.{Game, Group, Math, Point}
import models.component.StaticSprite
import util.Logging

class IntroScan(game: Game, onComplete: () => Unit) {
  private[this] var elapsed = 0.0

  private[this] val margin = 20
  private[this] val dimensions = (400 + (margin * 2)) -> (250 + (margin * 2))

  private[this] val charHorizontalOffset = 36 + margin
  private[this] val charVerticalOffset = 28 + margin
  private[this] val labelOffset = charHorizontalOffset + IntroAssets.charHeight
  private[this] val rightStartEdge = dimensions._1 - charHorizontalOffset - IntroAssets.charWidth - 1

  val group = new Group(game = game, name = s"intro.scan")

  private[this] val background = StaticSprite(game = game, group = group, name = "background", x = margin, y = margin, key = "intro.backgrounds")

  private[this] val characters = Seq("jeff", "britta", "abed", "shirley", "annie", "troy", "pierce")
  private[this] val charSprites = characters.map(key => StaticSprite(
    game = game, group = group, name = s"${key}scan", x = charHorizontalOffset, y = charVerticalOffset, key = s"intro.${key}scan", visible = false
  ))

  private[this] val computer = StaticSprite(
    game = game, group = group, name = "computer", x = (dimensions._1 - 75) / 2, y = 160, key = "intro.computer"
  )
  private[this] val inverted = StaticSprite(
    game = game, group = group, name = "inverted", x = charHorizontalOffset, y = charVerticalOffset, key = "intro.invertedscan", visible = false
  )
  private[this] val description = StaticSprite(
    game = game, group = group, name = "description", x = charHorizontalOffset, y = labelOffset, key = "intro.description"
  )
  private[this] val name = StaticSprite(
    game = game, group = group, name = "name", x = (dimensions._1 - 75) / 2, y = charVerticalOffset + 5, key = "intro.names"
  )
  private[this] val scanBlank = StaticSprite(
    game = game, group = group, name = "scanBlank", x = rightStartEdge, y = charVerticalOffset, key = "intro.blankscan"
  )
  private[this] val scanSprites = StaticSprite(
    game = game, group = group, name = "scanSprites", x = rightStartEdge, y = charVerticalOffset, key = "intro.invertedsprites", visible = false
  )
  private[this] val scanningBar = StaticSprite(
    game = game, group = group, name = "scanningBar", x = rightStartEdge, y = labelOffset, key = "intro.scanningbar"
  )
  private[this] val scanningWords = StaticSprite(
    game = game, group = group, name = "scanningWords", x = rightStartEdge, y = labelOffset + 16, key = "intro.scanningwords"
  )

  private[this] val events = Seq(
    IntroAnimations.backgroundEvents(background.sprite, characters),
    IntroAnimations.characterEvents(inverted.sprite, characters.zip(charSprites.map(_.sprite))),
    IntroAnimations.computerEvents(computer.sprite, characters.size),
    IntroAnimations.descriptionEvents(description.sprite, characters.size),
    IntroAnimations.nameEvents(name.sprite, characters.size),
    IntroAnimations.progressEvents(scanningBar.sprite, characters.size),
    IntroAnimations.scanEvents(scanBlank.sprite, scanSprites.sprite, characters.size),
    IntroAnimations.wordsEvents(scanningWords.sprite, characters.size),
    IntroAnimations.onComplete(() => {
      // TODO
    })
  ).flatten.sortBy(x => x.delay)
  private[this] val eventQueue = collection.mutable.Queue.apply(events: _*)

  game.world.add(group)

  def update(dt: Double) = {
    elapsed += dt

    while (eventQueue.headOption.exists(_.delay < elapsed)) {
      val event = eventQueue.dequeue()
      Logging.info(s"Performing event [$event].")
      event.trigger()
    }
  }

  def resize(width: Int, height: Int) = {
    val wRatio = width.toDouble / dimensions._1
    val hRatio = height.toDouble / dimensions._2
    val scale = Math.min(wRatio, hRatio)
    val x = (width - (dimensions._1 * scale)) / 2
    val y = (height - (dimensions._2 * scale)) / 2
    util.Logging.info(s"width: $width, height: $height, wRatio: $wRatio, hRatio: $hRatio, scale: $scale, x: $x, y: $y")
    group.position.set(Math.max(x, 0), Math.max(y, 0))
    group.scale = new Point(scale, scale)
  }

  def destroy() = {
    game.world.remove(group)
    group.alive = false
    group.visible = false
  }
}
