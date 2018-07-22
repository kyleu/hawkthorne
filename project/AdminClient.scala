import org.portablescala.sbtplatformdeps.PlatformDepsPlugin.autoImport._
import org.scalajs.sbtplugin.ScalaJSPlugin
import sbt.Keys._
import sbt._
import webscalajs.ScalaJSWeb

object AdminClient {
  private[this] val adminClientSettings = Shared.commonSettings ++ Seq(
    libraryDependencies ++= Seq(
      "be.doeraene" %%% "scalajs-jquery" % Dependencies.ScalaJS.jQueryVersion,
      "com.lihaoyi" %%% "scalatags" % Dependencies.Utils.scalatagsVersion
    ),
    testFrameworks += new TestFramework("utest.runner.Framework")
  )

  lazy val adminClient = Project(id = "adminClient", file("util/adminClient")).settings(adminClientSettings: _*).enablePlugins(
    ScalaJSPlugin, ScalaJSWeb
  ).dependsOn(Shared.coreJs)
}
