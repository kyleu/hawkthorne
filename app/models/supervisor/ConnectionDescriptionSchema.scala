package models.supervisor

import akka.util.Timeout
import models.InternalMessage.{GetSystemStatus, ConnectionStatus}
import graphql.CommonSchema._
import graphql.DateTimeSchema._
import graphql.{GraphQLContext, GraphQLSchemaHelper}
import sangria.macros.derive.deriveObjectType
import sangria.schema._
import util.FutureUtils.graphQlContext

object ConnectionDescriptionSchema extends GraphQLSchemaHelper("connection") {
  val channelArg = Argument("channel", OptionInputType(StringType))
  val connectionIdArg = Argument("connectionId", OptionInputType(uuidType))

  val connectionDescriptionType: ObjectType[GraphQLContext, ConnectionDescription] = deriveObjectType()

  val queryFields = fields(unitField(name = "connections", desc = None, t = ListType(connectionDescriptionType), f = (c, _) => {
    import akka.pattern.ask
    import scala.concurrent.duration._
    implicit val timeout: Timeout = Timeout(1.second)

    ask(c.ctx.app.connectionSupervisor, GetSystemStatus).mapTo[ConnectionStatus].map { x =>
      x.connections.filter(s => c.arg(channelArg).forall(_ == s.channel) && c.arg(connectionIdArg).forall(_ == s.id))
    }
  }, channelArg, connectionIdArg))
}
