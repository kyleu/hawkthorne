package pipeline

object ImageFiles {
  def process(cfg: PipelineConfig) = Seq(
    cfg.copyAsset("images/menu/splash.png", "images/splash.png"),
    cfg.copyAsset("images/scanning/scanningbar.png", "images/progress.png"),
    cfg.copyAsset("images/menu/logo.png", "images/logo.png"),
    cfg.copyAsset("images/menu/cityscape.png", "images/mainbg.png"),
    cfg.copyAsset("images/characters", "images/character"),
    cfg.copyAsset("images/scanning", "images/intro")
  ).flatten
}
