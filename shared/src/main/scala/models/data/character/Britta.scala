/* Generated File */
package models.data.character

import models.data.series.Episode
import models.player.Costume
import models.template.character.CharacterTemplate
import util.BoundingBox

object Britta extends CharacterTemplate(
  key = "britta",
  name = "Britta",
  givenName = "Britta Perry",

  costumes = Seq(
    Costume("base", Episode.S03E20, "Britta Perry", 1),
    Costume("astronaut", Episode.S02E04, "Astronaut", 2),
    Costume("asylum", Episode.S03E19, "Asylum", 3),
    Costume("bitten", Episode.S03E05, "Bitten", 4),
    Costume("bloodied", Episode.S03E05, "Bloody Hell!", 21),
    Costume("brittabot", Episode.S02E11, "Brittabot", 5),
    Costume("dragon", Episode.S02E06, "Brittasaurus Rex", 6),
    Costume("buzzkill", Episode.S05E11, "Buzzkill", 40),
    Costume("cheerleader", Episode.S01E13, "Cheerleader", 24),
    Costume("mafia", Episode.S01E18, "Chicken Mafia", 35),
    Costume("hurt", Episode.S01E12, "Christmas Brawl", 30),
    Costume("coldturkey", Episode.S01E09, "Cold Turkey", 28),
    Costume("dancer", Episode.S01E14, "Dancer", 33),
    Costume("dark", Episode.S03E04, "Darkest Timeline", 7),
    Costume("doctor", Episode.S03E16, "Dr. Perry", 23),
    Costume("fibrosis", Episode.S05E10, "Fibrosis The Ranger", 41),
    Costume("finallybefine", Episode.S03E01, "Finally Be Fine", 22),
    Costume("german", Episode.S04E04, "German Dirndl", 8),
    Costume("ham", Episode.S04E02, "Ham", 38),
    Costume("popnlock", Episode.S02E02, "Heather Popandlocklear", 25),
    Costume("fundraising", Episode.S02E03, "Help the Gulf", 29),
    Costume("cool", Episode.S02E13, "Kool Kat", 9),
    Costume("lavaworld", Episode.S05E05, "Lava World", 39),
    Costume("lavernica", Episode.S02E14, "Lavernica", 27),
    Costume("lingerie", Episode.S03E05, "Magnum's Angel", 32),
    Costume("king", Episode.S03E10, "Me So Christmas", 10),
    Costume("mia", Episode.S02E19, "Mia Wallace", 20),
    Costume("mj", Episode.S03E12, "Michael Jackson", 34),
    Costume("paintball", Episode.S01E23, "Modern Warfare", 11),
    Costume("dino", Episode.S02E06, "Monster", 12),
    Costume("tree", Episode.S03E10, "Mute Tree", 13),
    Costume("spades", Episode.S02E23, "Queen of Spades", 19),
    Costume("peyote", Episode.S03E19, "On Peyote", 14),
    Costume("psychopath", Episode.S03E05, "Psychopath", 18),
    Costume("punk", Episode.S04E12, "Punky Protester", 31),
    Costume("squirrel", Episode.S01E07, "Squirrel", 15),
    Costume("teapot", Episode.S01E14, "Teapot", 16),
    Costume("timelinebattle", Episode.S04E13, "Timeline Battle", 26),
    Costume("trannyqueen", Episode.S01E25, "Tranny Queen", 36),
    Costume("protest", Episode.S03E02, "U.N. Protest", 37),
    Costume("zombie", Episode.S02E06, "Zombie", 17)
  ),

  boundingBox = BoundingBox(
    width = 14,
    height = 35,
    duckHeight = 20,
    x = 17,
    y = 13
  ),
  offset = 8
)
