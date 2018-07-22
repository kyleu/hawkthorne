package pipeline

object ImageFiles {
  def process(cfg: PipelineConfig) = Seq(
    cfg.copyAsset("images/sparkle.png", "images/sparkle.png"),
    cfg.copyAsset("images/steam.png", "images/steam.png"),
    cfg.copyAsset("images/menu/splash.png", "images/splash.png"),
    cfg.copyAsset("images/scanning/scanningbar.png", "images/progress.png"),
    cfg.copyAsset("images/menu/logo.png", "images/logo.png"),
    cfg.copyAsset("images/menu/cityscape.png", "images/mainbg.png"),
    cfg.copyAsset("images/cornelius_head_2.png", "images/misc/cornelius.png"),

    cfg.copyAsset("images/characters", "images/character"),
    cfg.copyAsset("images/enemies", "images/enemies"),
    cfg.copyAsset("images/fonts", "images/font"),
    cfg.copyAsset("images/hud", "images/hud"),
    cfg.copyAsset("images/liquid", "images/liquid"),
    cfg.copyAsset("images/npc", "images/npc"),
    cfg.copyAsset("images/platforms", "images/platforms"),
    cfg.copyAsset("images/potions", "images/crafting"),
    cfg.copyAsset("images/scanning", "images/intro"),
    cfg.copyAsset("images/sprites", "images/sprites"),
    cfg.copyAsset("images/tilesets", "images/tileset"),
    cfg.copyAsset("images/weapons", "images/weapons")
  ).flatten
}
