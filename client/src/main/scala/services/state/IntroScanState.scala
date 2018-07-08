package services.state

import com.definitelyscala.phaserce.Game

object IntroScanState {
  def load() = {
    new LoadingState(
      next = new IntroScanState(),
      spritesheets = Seq(
        ("intro.backgrounds", "images/intro/backgrounds.png", 400, 250),
        ("intro.names", "images/intro/names.png", 75, 15),
        ("intro.computer", "images/intro/computer.png", 75, 19),
        ("intro.description", "images/intro/description.png", 121, 13),
        ("intro.scanningbar", "images/intro/scanningbar.png", 121, 13),
        ("intro.scanningwords", "images/intro/scanningwords.png", 121, 13),

        ("intro.blankscan", "images/intro/blankscan.png", 121, 172),
        ("intro.invertedsprites", "images/intro/invertedsprites.png", 121, 172),
        ("intro.invertedscan", "images/intro/invertedscan.png", 121, 172),

        ("intro.jeffscan", "images/intro/jeffscan.png", 121, 172),
        ("intro.brittascan", "images/intro/brittascan.png", 121, 172),
        ("intro.abedscan", "images/intro/abedscan.png", 121, 172),
        ("intro.shirleyscan", "images/intro/shirleyscan.png", 121, 172),
        ("intro.anniescan", "images/intro/anniescan.png", 121, 172),
        ("intro.troyscan", "images/intro/troyscan.png", 121, 172),
        ("intro.piercescan", "images/intro/piercescan.png", 121, 172)
      )
    )
  }

  val rtime = 10.0
  val ctime = rtime / 7
  val ftime = ctime / 3
  val stime = ctime - ftime
}

class IntroScanState() extends GameState("introscan") {
  override def create(game: Game) = {
    val background = game.add.sprite(0, 0, "intro.backgrounds", 0)
  }
}
