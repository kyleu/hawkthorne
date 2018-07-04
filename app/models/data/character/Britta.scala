/* Generated File */
package models.data.character

import models.character.{BoundingBox, CharacterTemplate, Costume}

object Britta {
  val name = "Britta"
  val givenName = "Britta Perry"

  val costumes = Seq(
    Costume("base", "base", "Britta Perry", 1),
    Costume("astronaut", "s2e4", "Astronaut", 2),
    Costume("asylum", "s3e19", "Asylum", 3),
    Costume("bitten", "s3e05", "Bitten", 4),
    Costume("bloodied", "s3e05", "Bloody Hell!", 21),
    Costume("brittabot", "s2e11", "Brittabot", 5),
    Costume("dragon", "s2e6", "Brittasaurus Rex", 6),
    Costume("buzzkill", "s5e11", "Buzzkill", 40),
    Costume("cheerleader", "s1e13", "Cheerleader", 24),
    Costume("mafia", "s1e18", "Chicken Mafia", 35),
    Costume("hurt", "s1e12", "Christmas Brawl", 30),
    Costume("coldturkey", "s1e9", "Cold Turkey", 28),
    Costume("dancer", "s1e14", "Dancer", 33),
    Costume("dark", "s3e4", "Darkest Timeline", 7),
    Costume("doctor", "s3e16", "Dr. Perry", 23),
    Costume("fibrosis", "s5e10", "Fibrosis The Ranger", 41),
    Costume("finallybefine", "s3e1", "Finally Be Fine", 22),
    Costume("german", "s4e4", "German Dirndl", 8),
    Costume("ham", "s4e2", "Ham", 38),
    Costume("popnlock", "s2e2", "Heather Popandlocklear", 25),
    Costume("fundraising", "s2e3", "Help the Gulf", 29),
    Costume("cool", "s2e13", "Kool Kat", 9),
    Costume("lavaworld", "s5e5", "Lava World", 39),
    Costume("lavernica", "s2e14", "Lavernica", 27),
    Costume("lingerie", "s3e5", "Magnum's Angel", 32),
    Costume("king", "s3e10", "Me So Christmas", 10),
    Costume("mia", "s2e19", "Mia Wallace", 20),
    Costume("mj", "s3e12", "Michael Jackson", 34),
    Costume("paintball", "s1e23", "Modern Warfare", 11),
    Costume("dino", "s2e6", "Monster", 12),
    Costume("tree", "s3e10", "Mute Tree", 13),
    Costume("spades", "s2e23", "Queen of Spades", 19),
    Costume("peyote", "s3e19", "On Peyote", 14),
    Costume("psychopath", "s3e5", "Psychopath", 18),
    Costume("punk", "s4e12", "Punky Protester", 31),
    Costume("squirrel", "s1e7", "Squirrel", 15),
    Costume("teapot", "s1e14", "Teapot", 16),
    Costume("timelinebattle", "s4e13", "Timeline Battle", 26),
    Costume("trannyqueen", "s1e25", "Tranny Queen", 36),
    Costume("protest", "s3e2", "U.N. Protest", 37),
    Costume("zombie", "s2e6", "Zombie", 17)
  )

  val boundingBox = BoundingBox(
    width = 14,
    height = 35,
    duckHeight = 20,
    x = 17,
    y = 13
  )
  val offset = 8

  val template = CharacterTemplate("britta", name, givenName, costumes, boundingBox, offset)
}
