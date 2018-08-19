package gatling

import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._

import scala.concurrent.duration._

class GameplaySimulation extends Simulation {
  setUp(newVisitorScenario().inject(rampUsers(1000) over 60.seconds).protocols(GatlingConfig.getHttpConfig))

  private[this] def newVisitorScenario() = webSocketSession(httpCalls(scenario("New Visitor")))

  private[this] def webSocketSession(scn: ScenarioBuilder) = {
    val socketRequest = ws("Gameplay Socket").open("/connect?binary=false")
    val pingRepeat = 120
    scn.exec(socketRequest).pause(5).repeat(pingRepeat, "ping") {
      exec(ws("Ping").sendText("""{ "Ping": { "ts": 0 } }""").check(wsAwait.within(30).until(1))).pause(1)
    }.exec(ws("Close WS").close)
  }

  private[this] def httpCalls(s: ScenarioBuilder) = {
    val indexRequest = http("Index").get("/").check(status.is(200))
    val gameplayRequest = http("Gameplay Page").get("/play").check(status.is(200))
    s.exec(indexRequest).pause(5).exec(gameplayRequest).pause(5)
  }
}
