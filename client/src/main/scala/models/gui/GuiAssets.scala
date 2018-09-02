package models.gui

import models.font.Font
import models.modal.BaseModal

object GuiAssets {
  val assets = HudOverlay.assets ++ Font.assets ++ BaseModal.assets
}
