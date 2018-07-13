scapegoatVersion in ThisBuild := Dependencies.Utils.scapegoatVersion

lazy val doc = Documentation.doc

lazy val coreJvm = Shared.coreJvm
lazy val coreJs = Shared.coreJs

lazy val sharedJvm = Shared.sharedJvm
lazy val sharedJs = Shared.sharedJs

lazy val server = Server.server

lazy val client = Client.client
lazy val adminClient = AdminClient.adminClient

lazy val pipeline = Pipeline.pipeline
