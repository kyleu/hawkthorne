/* Generated File */
package models

import graphql.{CommonSchema, GraphQLContext, GraphQLSchemaHelper}
import sangria.schema.{EnumType, ListType, fields}
import scala.concurrent.Future

object GameHistoryTypeSchema extends GraphQLSchemaHelper("gameHistoryType") {
  implicit val gameHistoryTypeEnumType: EnumType[GameHistoryType] = CommonSchema.deriveStringEnumeratumType(
    name = "GameHistoryType",
    values = GameHistoryType.values
  )

  val queryFields = fields(
    unitField(name = "gameHistoryType", desc = None, t = ListType(gameHistoryTypeEnumType), f = (_, _) => Future.successful(GameHistoryType.values))
  )
}
