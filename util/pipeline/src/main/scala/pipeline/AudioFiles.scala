package pipeline

object AudioFiles {
  def process(cfg: PipelineConfig) = Seq(
    cfg.copyAsset("audio", "audio")
  )
}
