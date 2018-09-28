import org.scalajs.sbtplugin.ScalaJSPlugin
import webscalajs.ScalaJSWeb
import sbt.Keys._
import sbt._

import org.portablescala.sbtplatformdeps.PlatformDepsPlugin.autoImport._

object Client {
  private[this] val clientSettings = Shared.commonSettings ++ Seq(
    resolvers += Resolver.bintrayRepo("definitelyscala", "maven"),
    libraryDependencies ++= Seq(
      "com.definitelyscala" %%% "scala-js-phaserce" % "1.2.0",
      "com.definitelyscala" %%% "scala-js-datgui" % "1.2.1"
    ),
    scalacOptions += "-P:scalajs:sjsDefinedByDefault"
  )

  lazy val client = (project in file("client")).settings(clientSettings: _*).enablePlugins(ScalaJSPlugin, ScalaJSWeb).dependsOn(Shared.coreJs, Shared.sharedJs)
}
