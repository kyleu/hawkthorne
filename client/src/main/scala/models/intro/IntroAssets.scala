package models.intro

import models.asset.Asset

object IntroAssets {
  val assets = Seq(
    Asset.Audio("music.opening", s"audio/music/opening.ogg"),

    Asset.Spritesheet("intro.backgrounds", "images/scanning/backgrounds.png", 400, 250),
    Asset.Spritesheet("intro.names", "images/scanning/names.png", 75, 15),
    Asset.Spritesheet("intro.computer", "images/scanning/computer.png", 75, 19),
    Asset.Spritesheet("intro.description", "images/scanning/description.png", 121, 13),
    Asset.Spritesheet("intro.scanningbar", "images/scanning/scanningbar.png", 121, 13),
    Asset.Spritesheet("intro.scanningwords", "images/scanning/scanningwords.png", 121, 13),

    Asset.Spritesheet("intro.blankscan", "images/scanning/blankscan.png", 121, 172),
    Asset.Spritesheet("intro.invertedsprites", "images/scanning/invertedsprites.png", 121, 172),
    Asset.Spritesheet("intro.invertedscan", "images/scanning/invertedscan.png", 121, 172),

    Asset.Spritesheet("intro.jeffscan", "images/scanning/jeffscan.png", 121, 172),
    Asset.Spritesheet("intro.brittascan", "images/scanning/brittascan.png", 121, 172),
    Asset.Spritesheet("intro.abedscan", "images/scanning/abedscan.png", 121, 172),
    Asset.Spritesheet("intro.shirleyscan", "images/scanning/shirleyscan.png", 121, 172),
    Asset.Spritesheet("intro.anniescan", "images/scanning/anniescan.png", 121, 172),
    Asset.Spritesheet("intro.troyscan", "images/scanning/troyscan.png", 121, 172),
    Asset.Spritesheet("intro.piercescan", "images/scanning/piercescan.png", 121, 172)
  )
}
