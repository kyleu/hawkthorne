package models.player

import java.util.UUID

import models.template.character.CharacterTemplate

final case class PlayerDetails(id: UUID, char: CharacterTemplate, costume: Costume)
