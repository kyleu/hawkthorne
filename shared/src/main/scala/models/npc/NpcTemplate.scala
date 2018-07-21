package models.npc

import models.animation.Animation
import models.data.npc._
import util.JsonSerializers._

object NpcTemplate {
  implicit val jsonEncoder: Encoder[NpcTemplate] = deriveEncoder
  implicit val jsonDecoder: Decoder[NpcTemplate] = deriveDecoder

  lazy val all = Seq(
    Alien, AlienRegroup, AnniesBoobs, BabyAbed, Blacksmith, BlacksmithJuan, BlacksmithWife, Frankie, GayNpc, Hermit, Hilda, HumanBeing,
    Jerry, Juan, Juanita, JumpingGirl, LaserLotus1, LaserLotus2, Leslie, MayorJuan, NotStarburns, OldMan, ProfHolly, SenorJuan, Shmitty,
    SophieB, TelescopeJuan, Tilda, TownKnight, TownLady, Townsperson, TutorialWizard, XmasWizard
  )

  def withKey(key: String) = all.find(_.key == key).getOrElse(throw new IllegalStateException(s"No npc [$key]."))
}

case class NpcTemplate(
    key: String,
    name: String,
    width: Int,
    height: Int,
    greeting: Option[String],
    noInventory: Option[String],
    noCommands: Option[String],
    animations: Seq[Animation]
)
