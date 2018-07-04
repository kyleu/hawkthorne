import sbt._
import sbt.Keys._
import Dependencies._

object Pipeline {
  lazy val pipeline = Project(id = "pipeline", base = file("./util/pipeline")).settings(Shared.commonSettings: _*).settings(
    libraryDependencies ++= Seq(Utils.betterFiles, Utils.scopts, Utils.guava)
  ).dependsOn(Shared.sharedJvm)
}
