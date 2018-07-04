package pipeline

object ImageFiles {
  def process(cfg: PipelineConfig) = Seq(
    cfg.copyAsset("images/menu/splash.png", "images/splash.png"),
    cfg.copyAsset("images/characters", "images/character")
  ).flatten
}
