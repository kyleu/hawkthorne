package models.template.character

import models.data.character._

object CharacterListing {
  lazy val greendaleSeven = Seq(Abed, Annie, Britta, Jeff, Pierce, Shirley, Troy)
  lazy val classmates = Seq(Buddy, FatNeil, Garrett, Leonard, Vaughn, Vicki)
  lazy val teachers = Seq(Chang, Dean, Duncan, Rich, ViceDean)

  lazy val all = Seq(
    Abed, Annie, Britta, Buddy, Chang, Dean, Duncan, FatNeil, Garrett, Gilbert,
    Guzman, Jeff, Leonard, Pierce, Rich, Shirley, Troy, Vaughn, ViceDean, Vicki
  )

  lazy val allCostumes = all.flatMap(c => c.costumes.map(c -> _))

  def withKey(key: String) = all.find(_.key == key).getOrElse(throw new IllegalStateException(s"No character [$key]."))
}
