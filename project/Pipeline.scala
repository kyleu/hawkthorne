import sbt._
import sbt.Keys._
import Dependencies._

object Pipeline {
  lazy val pipeline = Project(id = "pipeline", base = file("./util/pipeline")).settings(Shared.commonSettings: _*).settings(
    libraryDependencies ++= Dependencies.Serialization.circeProjects.map(c => "io.circe" %% c % Dependencies.Serialization.circeVersion) ++ Seq(
      Utils.betterFiles, Utils.scopts, Utils.guava, Utils.enumeratumCirce
    )
  )
}
