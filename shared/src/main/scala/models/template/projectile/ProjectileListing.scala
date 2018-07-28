/* Generated File */
package models.template.projectile

import models.data.projectile._

object ProjectileListing {
  val all = Seq(
    AcornBomb, AlienGatling, AlienLaser, Arrow, Baseball, Basketball, BenzalkFire, Bicycle, BirdBomb, Bomb, BombLongRange, CannonBomb,
    CloudBomb, CloudBombHorizontal, Computer, GhostPepper, Icicle, Laser, LaserCell, Lightning, Money, RainbowBeam, RainbowBeamTSnake, Spike,
    ThrowingAxe, ThrowingKnife, ThrowingTorch, WaterSpout
  )

  def withKey(key: String) = all.find(_.key == key).getOrElse(throw new IllegalStateException(s"No projectile [$key]."))
}
