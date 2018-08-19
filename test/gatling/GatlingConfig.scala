package gatling

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object GatlingConfig {
  val domain = "localhost:13000"
  val protocol = "http"

  def getHttpConfig = http
    .baseURL(s"$protocol://$domain").wsBaseURL(s"${if (protocol == "https") { "wss" } else { "ws" }}://$domain").doNotTrackHeader("1")
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
    .acceptLanguageHeader("en-US,en;q=0.5").acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0 Gatling")
}
