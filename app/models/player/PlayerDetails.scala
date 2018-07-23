package models.player

import java.util.UUID

final case class PlayerDetails(id: UUID, char: CharacterTemplate, costume: Costume)
