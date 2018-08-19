package gatling

import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import io.gatling.http.Predef._

import scala.concurrent.duration._

class SimpleSimulation extends Simulation {
  val domain = "localhost:13000"
  val protocol = "http"
  val baseUrl = s"$protocol://$domain"
  val baseWsUrl = s"${if (protocol == "https") { "wss" } else { "ws" }}://$domain"
  val pauseSeconds = 1

  val httpConf = http
    .baseURL(baseUrl).wsBaseURL(baseWsUrl).doNotTrackHeader("1")
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
    .acceptLanguageHeader("en-US,en;q=0.5").acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")

  val indexRequest = http("Index").get("/").check(status.is(200))

  val scn = scenario("New Visitor").exec(indexRequest).pause(pauseSeconds).exec(indexRequest).pause(pauseSeconds).exec(indexRequest)

  setUp(scn.inject(rampUsers(10) over 2.seconds).protocols(httpConf))
}
