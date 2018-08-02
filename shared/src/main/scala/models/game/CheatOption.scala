package models.game

import enumeratum.{CirceEnum, Enum, EnumEntry}

sealed abstract class CheatOption(val code: String, val description: String) extends EnumEntry

object CheatOption extends Enum[CheatOption] with CirceEnum[CheatOption] {
  case object GodMode extends CheatOption("spacetime", "Toggles god mode")
  case object SuperJump extends CheatOption("pop pop", "Jump extra high")
  case object SuperSpeed extends CheatOption("go abed go", "Run extra fast")
  case object SlideAttack extends CheatOption("slide", "Enable slide attack")
  case object MaxCoins extends CheatOption("hello rich people", "Add 10,000 coins")
  case object MaxHealth extends CheatOption("seacrest hulk", "Restores you to full health")
  case object GreendaleKey extends CheatOption("greendale is where i belong", "Gives the Greendale key")
  case object AllWeapons extends CheatOption("use respect", "Gives all weapons")
  case object AllMaterials extends CheatOption("this is more complex", "Gives all materials")
  case object AllScrolls extends CheatOption("i want tbd", "Gives all scrolls")
  case object AllPotions extends CheatOption("no no juice", "Gives all potions")
  case object AllConsumables extends CheatOption("zombie", "Gives all consumables")
  case object AllIngredients extends CheatOption("hubble bubble", "Gives all ingredients")
  case object AllFryables extends CheatOption("can i fry that", "Gives all fryable items")
  case object UnlockLevels extends CheatOption("chang level", "Unlocks all levels")
  case object MasterKey extends CheatOption("dan harmon", "Gives the master key")

  override val values = findValues
}
