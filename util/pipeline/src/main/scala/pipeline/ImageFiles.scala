package pipeline

object ImageFiles {
  def process(cfg: PipelineConfig) = cfg.copyAsset("images", "images").toSeq
}
