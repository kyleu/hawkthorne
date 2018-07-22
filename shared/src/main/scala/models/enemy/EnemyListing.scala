/* Generated File */
package models.enemy

import models.data.enemy._

object EnemyListing {
  val all = Seq(
    Wipe, AmbushAlienElite, Spider, AlienPilot, Canister, RubberSpider, Turkey, GiantAcorn, Pinata, TSnake, Bird, LaserLotusBoss, Guitarist, AlienTurret, Hippy, HippyNormal, AlienElite, Penguin, AlienHeavy, Squirrel, Cat, AlienRanged, AcornBoss, Manicorn, Alien, Qfo, HippyRanged, HippyRangedVertical, JumpingAcorn, Cannon, Hemp, Frog, Cornelius, Hempleaf, Wasabi, Snowman, Monkey, Bat, BenzalkBoss, Acorn, SpiderRoaming, TurkeyBoss, FishHorizontal, AcornPod, Trombonist, AmbushAlienRanged, Mike, Mannequin, Qilin, AmbushAlienHeavy, Ducky, AmbushAlien, Violinist, Fish, Goat, Humbug
  )

  def withKey(key: String) = all.find(_.key == key).getOrElse(throw new IllegalStateException(s"No enemy [$key]."))
}
