package pipeline

import util.JsonSerializers._

import scala.concurrent.Await
import scala.concurrent.duration._

object Entrypoint {
  def main(args: Array[String]): Unit = println(run().asJson.spaces2)

  def run() = {
    val cfg = PipelineConfig(srcProjectLoc = "../../Libraries/hawkthorne-journey/src", tgtRootLoc = ".", wipe = false)
    val resultF = PipelineService.go(cfg)
    val result = Await.result(resultF, 10.seconds)
    result
  }
}
