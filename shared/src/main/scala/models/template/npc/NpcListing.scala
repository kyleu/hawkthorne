/* Generated File */
package models.template.npc

import models.data.npc._

object NpcListing {
  val all = Seq(
    Juan, XmasWizard, SophieB, TutorialWizard, MayorJuan, Frankie, AnniesBoobs, HumanBeing, TownLady, Blacksmith, NotStarburns, GayNpc, BlacksmithJuan, TelescopeJuan, TownKnight, BlacksmithWife, AlienRegroup, JumpingGirl, Shmitty, LaserLotus1, SenorJuan, LaserLotus2, Alien, Townsperson, Juanita, OldMan, Leslie, BabyAbed, Hilda, Tilda, Jerry, ProfHolly, Hermit
  )

  def withKey(key: String) = all.find(_.key == key).getOrElse(throw new IllegalStateException(s"No npc [$key]."))
}
