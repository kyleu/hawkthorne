package models.character

import models.data.character._

object Characters {
  val greendaleSeven = Seq(Abed, Annie, Britta, Jeff, Pierce, Shirley, Troy)
  val classmates = Seq(Buddy, FatNeil, Garrett, Leonard, Vaughn, Vicki)
  val teachers = Seq(Chang, Dean, Duncan, Rich, ViceDean)

  val all = Seq(
    Abed,
    Annie,
    Britta,
    Buddy,
    Chang,
    Dean,
    Duncan,
    FatNeil,
    Garrett,
    Gilbert,
    Guzman,
    Jeff,
    Leonard,
    Pierce,
    Rich,
    Shirley,
    Troy,
    Vaughn,
    ViceDean,
    Vicki
  )

  val allCostumes = Characters.all.flatMap(c => c.costumes.map(c -> _))

  def withKey(key: String) = all.find(_.key == key).getOrElse(throw new IllegalStateException(s"No character [$key]."))
}
