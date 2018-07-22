/* Generated File */
package models.template.weapon

import models.data.weapon._

object WeaponListing {
  val all = Seq(
    Bow, BoneClub, LaserPistol, Battleaxe, CherryPopper, Dagger, Torch, Longsword, CrimsonSword, Scythe, Epic, Nunchucks, TruestWrench, Sword, BattleaxeSmall, MaceSmall, Switch, Mace, Axe, BlueSkySpecial, Wrench, Mallet
  )

  def withKey(key: String) = all.find(_.key == key).getOrElse(throw new IllegalStateException(s"No weapon [$key]."))
}
