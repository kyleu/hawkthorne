package models.template.quest

import models.data.quest._

object QuestListing {
  val all = Seq(
    AlienQuests.all, FrankieQuests.all, HermitQuests.all, HildaQuests.all, JuanitaQuests.all,
    LotusQuests.all, TelescopeJuanQuests.all, TildaQuests.all, WifeQuests.all
  ).flatten

  def withKey(key: String) = all.find(_.key == key).getOrElse(throw new IllegalStateException(s"No quest [$key]."))
}
