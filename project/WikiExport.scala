import sbt._

object WikiExport {
  lazy val wikiExport = Project(id = "wikiExport", base = file("./util/wikiExport")).settings(Shared.commonSettings: _*).dependsOn(Shared.sharedJvm)
}
