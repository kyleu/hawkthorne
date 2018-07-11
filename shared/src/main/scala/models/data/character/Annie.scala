/* Generated File */
package models.data.character

import models.character.{BoundingBox, CharacterTemplate, Costume}
import models.data.series.Episode

object Annie extends CharacterTemplate(
  key = "annie",
  name = "Annie",
  givenName = "Annie Edison",

  costumes = Seq(
    Costume("base", Episode.S01E01, "Annie Edison", 1),
    Costume("abed", Episode.S03E16, "Abed", 4),
    Costume("hearts", Episode.S02E23, "Ace of Hearts", 8),
    Costume("kim", Episode.S03E02, "Annie Kim", 9),
    Costume("armor", Episode.S03E20, "Armor", 3),
    Costume("astronaut", Episode.S02E04, "Astronaut", 19),
    Costume("asylum", Episode.S03E19, "Asylum", 2),
    Costume("ballerannie", Episode.S02E11, "Ballerannie", 20),
    Costume("security", Episode.S01E20, "Campus Security", 13),
    Costume("changlorious", Episode.S03E21, "Changlorious Bastard", 25),
    Costume("cheerleader", Episode.S01E13, "Cheerleader", 29),
    Costume("mafia", Episode.S01E18, "Chicken Mafia", 44),
    Costume("hurt", Episode.S01E12, "Christmas Brawl", 37),
    Costume("paint", Episode.S02E24, "Covered In Paint", 45),
    Costume("debate", Episode.S01E09, "Debate Uniform", 30),
    Costume("dorothy", Episode.S03E11, "Dorothy (Judy Garland)", 24),
    Costume("hanniebal", Episode.S04E10, "Evil Annie (Hanniebal)", 47),
    Costume("reddress", Episode.S04E13, "Evil Annie (Red Dress)", 39),
    Costume("befine", Episode.S03E01, "Finally Be Fine", 5),
    Costume("geneva", Episode.S03E16, "Geneva", 6),
    Costume("german", Episode.S04E04, "German Dirndl", 43),
    Costume("baby", Episode.S04E01, "Greendale Baby", 36),
    Costume("poplock", Episode.S02E02, "Heather Popandlocklear", 31),
    Costume("hector", Episode.S02E14, "Hector the Well-Endowed", 34),
    Costume("hectorlvlup", Episode.S05E10, "Hector the Well-Endowed (Advanced)", 48),
    Costume("honey", Episode.S02E19, "Honey Bunny", 27),
    Costume("hooded", Episode.S05E03, "Hooded Detective Coat", 50),
    Costume("hospital", Episode.S01E08, "Hospital Gown", 18),
    Costume("karatannie", Episode.S02E21, "Karatannie", 21),
    Costume("lawyer", Episode.S03E17, "Lawyer", 41),
    Costume("highschool", Episode.S04E12, "Little Annie Adderall", 46),
    Costume("riding", Episode.S02E06, "Little Red Riding Hood", 11),
    Costume("lingerie", Episode.S03E05, "Magnum's Angel", 33),
    Costume("warfare", Episode.S01E23, "Modern Warfare", 14),
    Costume("nurse", Episode.S03E14, "Nurse", 10),
    Costume("pageant", Episode.S03E10, "Planet Christmas", 38),
    Costume("princess", Episode.S03E07, "Princess Annie", 22),
    Costume("reindeer", Episode.S03E10, "Reindeer Sweater", 23),
    Costume("samara", Episode.S04E02, "Samara (Ring Girl)", 42),
    Costume("script", Episode.S03E08, "Script Supervisor", 35),
    Costume("santa", Episode.S03E10, "Sexy Santa", 12),
    Costume("party", Episode.S03E05, "Sinful Party", 28),
    Costume("skeleton", Episode.S01E07, "Skeleton", 17),
    Costume("tightship", Episode.S05E11, "Tight Ship", 49),
    Costume("timebattle", Episode.S04E13, "Timeline Battle", 32),
    Costume("victorian", Episode.S03E05, "Victorian", 7),
    Costume("werewolf", Episode.S03E05, "Werewolf", 15),
    Costume("western", Episode.S02E23, "Western Dress", 40),
    Costume("wig", Episode.S03E19, "Wigging Out", 26),
    Costume("zombie", Episode.S03E20, "Zombie", 16)
  ),

  boundingBox = BoundingBox(
    width = 14,
    height = 32,
    duckHeight = 20,
    x = 17,
    y = 16
  ),
  offset = 8
)
