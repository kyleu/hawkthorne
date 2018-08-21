import Dependencies.Utils
import sbt.Keys._
import sbt._

object WikiExport {
  lazy val wikiExport = Project(id = "wikiExport", base = file("./util/wikiExport")).settings(Shared.commonSettings: _*).settings(
    libraryDependencies ++= Seq(Utils.betterFiles, Utils.scopts, Utils.guava)
  ).dependsOn(Shared.sharedJvm)
}
