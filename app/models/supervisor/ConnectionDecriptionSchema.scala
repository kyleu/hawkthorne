package models.supervisor

import akka.util.Timeout
import models.InternalMessage.{GetSystemStatus, SystemStatus}
import graphql.CommonSchema._
import graphql.DateTimeSchema._
import graphql.{GraphQLContext, GraphQLSchemaHelper}
import sangria.macros.derive.deriveObjectType
import sangria.schema._
import util.FutureUtils.graphQlContext

object ConnectionDecriptionSchema extends GraphQLSchemaHelper("connection") {
  val channelArg = Argument("channel", OptionInputType(StringType))
  val connectionIdArg = Argument("connectionId", OptionInputType(uuidType))

  val connectionDecriptionType: ObjectType[GraphQLContext, ConnectionDescription] = deriveObjectType()

  val queryFields = fields(unitField(name = "connections", desc = None, t = ListType(connectionDecriptionType), f = (c, _) => {
    import akka.pattern.ask
    import scala.concurrent.duration._
    implicit val timeout: Timeout = Timeout(1.second)

    ask(c.ctx.app.gameSupervisor, GetSystemStatus).mapTo[SystemStatus].map { x =>
      x.connections.filter(s => c.arg(channelArg).forall(_ == s.channel) && c.arg(connectionIdArg).forall(_ == s.id))
    }
  }, channelArg, connectionIdArg))
}
