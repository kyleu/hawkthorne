package models.options

import enumeratum.{CirceEnum, Enum, EnumEntry}

sealed abstract class CheatOptions(val code: String, val description: String) extends EnumEntry

object CheatOptions extends Enum[CheatOptions] with CirceEnum[CheatOptions] {
  case object GodMode extends CheatOptions("spacetime", "Toggles god mode")
  case object SuperJump extends CheatOptions("pop pop", "Jump extra high")
  case object SuperSpeed extends CheatOptions("go abed go", "Run extra fast")
  case object SlideAttack extends CheatOptions("slide", "Enable slide attack")
  case object MaxCoins extends CheatOptions("hello rich people", "Add 10,000 coins")
  case object MaxHealth extends CheatOptions("seacrest hulk", "Restores you to full health")
  case object GreendaleKey extends CheatOptions("greendale is where i belong", "Gives the Greendale key")
  case object AllWeapons extends CheatOptions("use respect", "Gives all weapons")
  case object AllMaterials extends CheatOptions("this is more complex", "Gives all materials")
  case object AllScrolls extends CheatOptions("i want tbd", "Gives all scrolls")
  case object AllPotions extends CheatOptions("no no juice", "Gives all potions")
  case object AllConsumables extends CheatOptions("zombie", "Gives all consumables")
  case object AllIngredients extends CheatOptions("hubble bubble", "Gives all ingredients")
  case object AllFryables extends CheatOptions("can i fry that", "Gives all fryable items")
  case object UnlockLevels extends CheatOptions("chang level", "Unlocks all levels")
  case object MasterKey extends CheatOptions("dan harmon", "Gives the master key")

  override val values = findValues
}
