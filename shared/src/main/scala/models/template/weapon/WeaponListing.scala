/* Generated File */
package models.template.weapon

import models.data.weapon._

object WeaponListing {
  val all = Seq(
    Axe, Battleaxe, BattleaxeSmall, BlueSkySpecial, BoneClub, Bow, CherryPopper, CrimsonSword, Dagger, Epic, LaserPistol, Longsword,
    Mace, MaceSmall, Mallet, Nunchucks, Scythe, Switch, Sword, Torch, TruestWrench, Wrench
  )

  def withKey(key: String) = all.find(_.key == key).getOrElse(throw new IllegalStateException(s"No weapon [$key]."))
}
