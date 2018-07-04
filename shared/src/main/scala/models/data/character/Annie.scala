/* Generated File */
package models.data.character

import models.character.{BoundingBox, CharacterTemplate, Costume}

object Annie {
  val name = "Annie"
  val givenName = "Annie Edison"

  val costumes = Seq(
    Costume("base", "base", "Annie Edison", 1),
    Costume("abed", "s3e16", "Abed", 4),
    Costume("hearts", "s2e23", "Ace of Hearts", 8),
    Costume("kim", "s3e2", "Annie Kim", 9),
    Costume("armor", "s3e20", "Armor", 3),
    Costume("astronaut", "s2e4", "Astronaut", 19),
    Costume("asylum", "s3e19", "Asylum", 2),
    Costume("ballerannie", "s2e11", "Ballerannie", 20),
    Costume("security", "s1e20", "Campus Security", 13),
    Costume("changlorious", "s3e21", "Changlorious Bastard", 25),
    Costume("cheerleader", "s1e13", "Cheerleader", 29),
    Costume("mafia", "s1e18", "Chicken Mafia", 44),
    Costume("hurt", "s1e12", "Christmas Brawl", 37),
    Costume("paint", "s2e24", "Covered In Paint", 45),
    Costume("debate", "s1e9", "Debate Uniform", 30),
    Costume("dorothy", "s3e11", "Dorothy (Judy Garland)", 24),
    Costume("hanniebal", "s4e10", "Evil Annie (Hanniebal)", 47),
    Costume("reddress", "s4e13", "Evil Annie (Red Dress)", 39),
    Costume("befine", "s3e1", "Finally Be Fine", 5),
    Costume("geneva", "s3e16", "Geneva", 6),
    Costume("german", "s4e4", "German Dirndl", 43),
    Costume("baby", "s4e1", "Greendale Baby", 36),
    Costume("poplock", "s2e2", "Heather Popandlocklear", 31),
    Costume("hector", "s2e14", "Hector the Well-Endowed", 34),
    Costume("hectorlvlup", "s5e10", "Hector the Well-Endowed (Advanced)", 48),
    Costume("honey", "s2e19", "Honey Bunny", 27),
    Costume("hooded", "s5e3", "Hooded Detective Coat", 50),
    Costume("hospital", "s1e8", "Hospital Gown", 18),
    Costume("karatannie", "s2e21", "Karatannie", 21),
    Costume("lawyer", "s3e17", "Lawyer", 41),
    Costume("highschool", "s4e12", "Little Annie Adderall", 46),
    Costume("riding", "s2e6", "Little Red Riding Hood", 11),
    Costume("lingerie", "s3e5", "Magnum's Angel", 33),
    Costume("warfare", "s1e23", "Modern Warfare", 14),
    Costume("nurse", "s3e14", "Nurse", 10),
    Costume("pageant", "s3e10", "Planet Christmas", 38),
    Costume("princess", "s3e7", "Princess Annie", 22),
    Costume("reindeer", "s3e10", "Reindeer Sweater", 23),
    Costume("samara", "s4e2", "Samara (Ring Girl)", 42),
    Costume("script", "s3e8", "Script Supervisor", 35),
    Costume("santa", "s3e10", "Sexy Santa", 12),
    Costume("party", "s3e5", "Sinful Party", 28),
    Costume("skeleton", "s1e7", "Skeleton", 17),
    Costume("tightship", "s5e11", "Tight Ship", 49),
    Costume("timebattle", "s4e13", "Timeline Battle", 32),
    Costume("victorian", "s3e5", "Victorian", 7),
    Costume("werewolf", "s3e5", "Werewolf", 15),
    Costume("western", "s2e23", "Western Dress", 40),
    Costume("wig", "s3e19", "Wigging Out", 26),
    Costume("zombie", "s3e20", "Zombie", 16)
  )

  val boundingBox = BoundingBox(
    width = 14,
    height = 32,
    duckHeight = 20,
    x = 17,
    y = 16
  )
  val offset = 8

  val template = CharacterTemplate("annie", name, givenName, costumes, boundingBox, offset)
}
