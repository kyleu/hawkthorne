/* Generated File */
package models.template.npc

import models.data.npc._

object NpcListing {
  val all = Seq(
    Alien, AlienRegroup, AnniesBoobs, BabyAbed, Blacksmith, BlacksmithJuan, BlacksmithWife, Frankie, GayNpc, Hermit, Hilda, HumanBeing,
    Jerry, Juan, Juanita, JumpingGirl, LaserLotus1, LaserLotus2, Leslie, MayorJuan, NotStarburns, OldMan, ProfHolly, SenorJuan,
    Shmitty, SophieB, TelescopeJuan, Tilda, TownKnight, TownLady, Townsperson, TutorialWizard, XmasWizard
  )

  def withKey(key: String) = all.find(_.key == key).getOrElse(throw new IllegalStateException(s"No npc [$key]."))
}
