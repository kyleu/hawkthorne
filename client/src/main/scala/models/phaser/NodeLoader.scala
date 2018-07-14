package models.phaser

import com.definitelyscala.phaserce.{Game, Group, Sprite}
import models.node.{Node, SpriteNode}
import services.map.MapService
import util.NullUtils

class NodeLoader(game: Game, group: Group) {
  def load(nodes: Seq[Node], onFileComplete: (Int, Int) => Unit = (progress, total) => (), onComplete: Seq[Sprite] => Unit = sprites => ()) = {
    val startNanos = System.nanoTime
    val sprites = nodes.collect { case s: SpriteNode => s }
    val spriteImages = sprites.map(s => s.sheetKey -> s.properties.sheet).distinct

    val images = spriteImages
    images.foreach(sheet => game.load.image(sheet._1, "/assets/game/" + sheet._2))

    var totalFiles = images.size
    var filesCompleted = 0

    game.load.onFileComplete.add(() => {
      filesCompleted += 1
      onFileComplete(filesCompleted, totalFiles)
    }, NullUtils.inst, 1.0)

    game.load.onLoadComplete.add(() => {
      val retSprites = sprites.map { s =>
        val sprite = game.add.sprite(x = s.x * MapService.scale, y = s.y * MapService.scale, key = s.sheetKey, frame = 0, group = group)
        sprite.name = s.name
        sprite.scale = MapService.scalePoint
        sprite
      }
      println(s"Loaded [${images.size}] images in [${((System.nanoTime - startNanos) / 1000000).toString.take(8)}ms].")
      onComplete(retSprites)
    }, NullUtils.inst, 1.0)
    game.load.start()
  }
}
