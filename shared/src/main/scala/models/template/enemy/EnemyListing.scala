/* Generated File */
package models.template.enemy

import models.data.enemy._

object EnemyListing {
  val all = Seq(
    Acorn, AcornBoss, AcornPod, Alien, AlienElite, AlienHeavy, AlienPilot, AlienRanged, AlienTurret, AmbushAlien, AmbushAlienElite, AmbushAlienHeavy,
    AmbushAlienRanged, Bat, BenzalkBoss, Bird, Canister, Cannon, Cat, Cornelius, Ducky, Fish, FishHorizontal, Frog,
    GiantAcorn, Goat, Guitarist, Hemp, Hempleaf, Hippy, HippyNormal, HippyRanged, HippyRangedVertical, Humbug, JumpingAcorn, LaserLotusBoss,
    Manicorn, Mannequin, Mike, Monkey, Penguin, Pinata, Qfo, Qilin, RubberSpider, Snowman, Spider, SpiderRoaming,
    Squirrel, TSnake, Trombonist, Turkey, TurkeyBoss, Violinist, Wasabi, Wipe
  )

  def withKey(key: String) = all.find(_.key == key).getOrElse(throw new IllegalStateException(s"No enemy [$key]."))
}
