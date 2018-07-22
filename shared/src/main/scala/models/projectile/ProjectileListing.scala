/* Generated File */
package models.projectile

import models.data.projectile._

object ProjectileListing {
  val all = Seq(
    Bomb, AlienLaser, BombLongRange, WaterSpout, BirdBomb, Laser, RainbowBeamTSnake, ThrowingTorch, Arrow, Spike, CloudBomb, RainbowBeam, Lightning, CloudBombHorizontal, Icicle, AlienGatling, ThrowingAxe, Money, BenzalkFire, Baseball, LaserCell, Basketball, Computer, GhostPepper, Bicycle, AcornBomb, ThrowingKnife, CannonBomb
  )

  def withKey(key: String) = all.find(_.key == key).getOrElse(throw new IllegalStateException(s"No projectile [$key]."))
}
