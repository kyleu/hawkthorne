package models.component

import com.definitelyscala.phaserce.{BitmapData, Game, Group, Image, Sprite}
import models.asset.Asset
import models.player.Player
import models.template.character.CharacterListing
import util.NullUtils

import scala.util.Random

object Portal {
  def costumes(characterKey: String, costumeKey: String) = {
    val character = CharacterListing.withKey(characterKey)
    val costume = character.costume(costumeKey)
    CharacterListing.greendaleSeven.map(c => c -> c.relatedCostume(costume).getOrElse(c.costume("base")))
  }

  def assets(characterKey: String, costumeKey: String) = costumes(characterKey, costumeKey).map {
    case (ch, co) => Asset.Spritesheet(s"${ch.key}.${co.key}", s"images/characters/${ch.key}/${co.key}.png", 48, 48)
  }
}

class Portal(game: Game, player: Player) {
  val group = new Group(game, NullUtils.inst, "portal", addToStage = true)
  val particlesGroup = new Group(game, group, "vertical.particles")

  private[this] val all = IndexedSeq(1 -> 1, 1 -> 2, 1 -> 3, 2 -> 2).zipWithIndex.map {
    case ((w, h), idx) => new BitmapData(game, s"small-particle-$idx", w.toDouble, h.toDouble)
  }
  all.foreach(_.fill(255, 255, 255))

  private[this] val images = (0 until 200).map { idx =>
    val x = Random.nextInt(game.width.toInt).toDouble
    val y = Random.nextInt(game.height.toInt).toDouble
    val ratio = 1.0 - Math.cos(Math.abs(x - game.width / 2) * 2 / game.width) * 0.6
    val i = new Image(game, x, y, all(Random.nextInt(all.length)))
    i.data = 300 * (ratio + math.random() / 4)
    i.name = s"particle.$idx"
    group.add(i)
    i
  }

  private[this] val sprites = Random.shuffle(Portal.costumes(player.templateKey, player.costumeKey)).zipWithIndex.map {
    case (char, idx) => new Sprite(game, 0, 48.0 * idx, s"${char._1.key}.${char._2.key}", frame = 0)
  }
  sprites.foreach(s => group.add(s))

  def update(dt: Double) = {
    images.foreach { i =>
      i.y -= (i.data.asInstanceOf[Double] * dt)
      if (i.y < -10) {
        i.x = Random.nextDouble() * game.width
        i.y = game.height + 10
      }
    }
  }
}
