/* Generated File */
package models.data.character

import models.character.{BoundingBox, CharacterTemplate, Costume}

object Jeff {
  val name = "Jeff"
  val givenName = "Jeff Winger"

  val costumes = Seq(
    Costume("base", "base", "Jeff Winger", 1),
    Costume("astronaut", "s2e4", "Astronaut", 2),
    Costume("asylum", "s3e19", "Asylum", 3),
    Costume("aviators", "s3e12", "Aviators", 4),
    Costume("bball", "s2e7", "B-Ball", 23),
    Costume("naked", "s1e17", "Birthday Suit", 5),
    Costume("boxer", "s4e2", "Boxer", 44),
    Costume("carpediem", "s1e3", "Carpe Diem!", 27),
    Costume("hurt", "s1e12", "Christmas Brawl", 39),
    Costume("darkest", "s3e4", "Darkest Timeline", 41),
    Costume("david", "s2e6", "David Beckham", 6),
    Costume("dean", "s3e8", "Dean Pelton", 24),
    Costume("doctor", "s3e16", "Doctor Winger", 33),
    Costume("drunk", "s1e16", "Drunk", 40),
    Costume("electro", "s3e20", "Electrocuted", 7),
    Costume("darkundies", "s4e13", "Evil Undies", 38),
    Costume("fbf", "s3e1", "Finally Be Fine", 28),
    Costume("goldblum", "s1e19", "Goldblumming", 8),
    Costume("baby", "s4e1", "Greendale Baby", 29),
    Costume("hawkeye", "s1e13", "Hawkeye", 32),
    Costume("poplock", "s2e2", "Heather Popandlocklear", 9),
    Costume("hungerdeans", "s4e1", "Hunger Deans", 49),
    Costume("jeffinthebox", "s2e11", "Jeff-In-The-Box", 43),
    Costume("spades", "s2e23", "King of Spades", 10),
    Costume("cool", "s2e13", "Kool Kat", 11),
    Costume("app", "s5e8", "Level 4", 50),
    Costume("mar", "s2e14", "Marrrrrrrr", 31),
    Costume("straightjacket", "s2e21", "Mercury Poisoning", 12),
    Costume("warfare", "s1e23", "Modern Warfare", 26),
    Costume("mohawk", "s3e19", "Mohawk", 13),
    Costume("monkeygas", "s3e1", "Monkey Gas", 14),
    Costume("plaid", "s3e14", "Plaid Coat", 45),
    Costume("planet", "s3e10", "Planet Christmas", 36),
    Costume("professor", "s5e2", "Professor", 46),
    Costume("skater", "s4e4", "Proving A Point", 42),
    Costume("ricky", "s3e21", "Ricky Nightshade", 30),
    Costume("hulk", "s3e12", "Seacrest Hulk", 15),
    Costume("cowboy", "s1e7", "Sexy Cowboy", 17),
    Costume("shorts", "s1e17", "Short Shorts", 16),
    Costume("riggs", "s5e10", "Sir Riggs Diehard", 47),
    Costume("abeds_shirt", "s1e2", "Spanish 101", 18),
    Costume("thoraxis", "s4e3", "Thoraxis", 19),
    Costume("timeline", "s4e13", "Timeline Battle", 35),
    Costume("anime", "s3e9", "Tinkletown", 20),
    Costume("train", "s2e21", "Train Conductor", 34),
    Costume("undies", "s1e17", "Undies", 37),
    Costume("vampire", "s3e5", "Vampire", 22),
    Costume("vega", "s2e19", "Vincent Vega", 25),
    Costume("wingman", "s5e11", "Wingman", 48),
    Costume("zombie", "s2e6", "Zombie", 21)
  )

  val boundingBox = BoundingBox(
    width = 14,
    height = 41,
    duckHeight = 20,
    x = 17,
    y = 7
  )
  val offset = 5

  val template = CharacterTemplate("jeff", name, givenName, costumes, boundingBox, offset)
}
