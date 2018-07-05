scapegoatVersion in ThisBuild := Dependencies.Utils.scapegoatVersion

lazy val doc = Documentation.doc

lazy val sharedJvm = Shared.sharedJvm

lazy val server = Server.server

lazy val sharedJs = Shared.sharedJs

lazy val client = Client.client

lazy val adminClient = AdminClient.adminClient

lazy val pipeline = Pipeline.pipeline
