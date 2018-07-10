package models.player

import java.util.UUID

import models.character.{CharacterTemplate, Costume}

case class PlayerDetails(id: UUID, char: CharacterTemplate, costume: Costume)
