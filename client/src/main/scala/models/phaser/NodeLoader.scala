package models.phaser

import com.definitelyscala.phaserce.{Game, Group, Sprite}
import models.node.{Node, SpriteNode}
import services.map.MapService
import util.NullUtils

class NodeLoader(game: Game, group: Group) {
  def load(nodes: Seq[Node], onFileComplete: (Int, Int) => Unit = (_, _) => (), onComplete: Seq[Sprite] => Unit = _ => ()) = {
    val startNanos = System.nanoTime
    val sprites = nodes.collect { case s: SpriteNode => s }
    val spriteImages = sprites.map(s => (s.sheetKey, s.properties.sheet, s.width.toDouble, s.height.toDouble)).distinct

    val images = spriteImages
    images.foreach(sheet => game.load.spritesheet(sheet._1, "/assets/game/" + sheet._2, sheet._3, sheet._4))

    var filesCompleted = 0

    game.load.onFileComplete.add(() => {
      filesCompleted += 1
      onFileComplete(filesCompleted, images.size)
    }, NullUtils.inst, 1.0)

    game.load.onLoadComplete.add(() => {
      val retSprites = sprites.map { s =>
        s.animation match {
          case Some(a) =>
            val as = AnimatedSprite(game, group, (s.x * MapService.scale).toInt, (s.y * MapService.scale).toInt, s.sheetKey, Map("default" -> a))
            as.sprite.name = s.name
            as.sprite.scale = MapService.scalePoint
            as.sprite.frame = 4
            as.sprite
          case None =>
            val sprite = game.add.sprite(x = s.x * MapService.scale, y = s.y * MapService.scale, key = s.sheetKey, frame = 0, group = group)
            sprite.name = s.name
            sprite.scale = MapService.scalePoint
            sprite
        }
      }
      println(s"Loaded [${images.size}] images in [${((System.nanoTime - startNanos) / 1000000).toString.take(8)}ms].")
      onComplete(retSprites)
    }, NullUtils.inst, 1.0)
    game.load.start()
  }
}
