package pipeline

object PipelineService {
  def go(cfg: PipelineConfig) = {
    val started = util.DateUtils.now
    val startNanos = System.nanoTime
    cfg.assetRoot.children.foreach(_.delete(swallowIOExceptions = true))
    cfg.scalaAppRoot.children.foreach(_.delete(swallowIOExceptions = true))
    cfg.scalaSharedRoot.children.foreach(_.delete(swallowIOExceptions = true))

    val files = AudioFiles.process(cfg) ++ ImageFiles.process(cfg) ++ CharacterFiles.process(cfg)
    val result = PipelineResult(config = cfg, started = started, durationNanos = System.nanoTime - startNanos, files = files)
    scala.concurrent.Future.successful(result)
  }
}
