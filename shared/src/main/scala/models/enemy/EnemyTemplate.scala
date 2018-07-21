package models.enemy

import models.animation.Animation
import models.data.enemy._
import util.JsonSerializers._

object EnemyTemplate {
  implicit val jsonEncoder: Encoder[EnemyTemplate] = deriveEncoder
  implicit val jsonDecoder: Decoder[EnemyTemplate] = deriveDecoder

  lazy val all = Seq(
    Acorn, AcornBoss, AcornPod, Alien, AlienElite, AlienHeavy, AlienPilot, AlienRanged, AlienTurret, AmbushAlien, AmbushAlienElite, AmbushAlienHeavy,
    AmbushAlienRanged, Bat, BenzalkBoss, Bird, Canister, Cannon, Cat, Cornelius, Ducky, Fish, FishHorizontal, Frog, GiantAcorn, Goat, Guitarist, Hemp,
    Hempleaf, Hippy, HippyNormal, HippyRanged, HippyRangedVertical, Humbug, JumpingAcorn, LaserLotusBoss, Manicorn, Mannequin, Mike, Monkey, Penguin,
    Pinata, Qfo, RubberSpider, Snowman, Spider, SpiderRoaming, Squirrel, Trombonist, TSnake, Turkey, TurkeyBoss, Violinist, Wasabi, Wipe
  )

  def withKey(key: String) = all.find(_.key == key).getOrElse(throw new IllegalStateException(s"No npc [$key]."))
}

case class EnemyTemplate(
    key: String,
    name: String,
    width: Int,
    height: Int,
    damage: Int,
    hp: Int,
    isBoss: Boolean,
    animations: Seq[Animation]
)
