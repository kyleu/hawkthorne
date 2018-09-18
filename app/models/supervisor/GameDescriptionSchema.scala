package models.supervisor

import akka.util.Timeout
import controllers.GameplayController
import graphql.CommonSchema._
import graphql.DateTimeSchema._
import graphql.{GraphQLContext, GraphQLSchemaHelper}
import models.InternalMessage.{GameStatus, GetSystemStatus}
import models.data.map.TiledMap
import models.options.GameOptions
import sangria.macros.derive.deriveObjectType
import sangria.schema._
import util.FutureUtils.graphQlContext

object GameDescriptionSchema extends GraphQLSchemaHelper("game") {
  val gameIdArg = Argument("gameId", OptionInputType(uuidType))

  implicit val tiledMapType: EnumType[TiledMap] = deriveStringEnumeratumType("TiledMap", TiledMap.values)
  implicit val gameOptionsType: ObjectType[GraphQLContext, GameOptions] = deriveObjectType()
  val gameDescriptionType: ObjectType[GraphQLContext, GameDescription] = deriveObjectType()

  val queryFields = fields(unitField(name = "games", desc = None, t = ListType(gameDescriptionType), f = (c, _) => {
    import akka.pattern.ask

    import scala.concurrent.duration._
    implicit val timeout: Timeout = Timeout(1.second)

    ask(GameplayController.gameSupervisor, GetSystemStatus).mapTo[GameStatus].map { x =>
      x.games.filter(s => c.arg(gameIdArg).forall(_ == s.id))
    }
  }, gameIdArg))
}
