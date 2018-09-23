/* Generated File */
package models

import graphql.{CommonSchema, GraphQLContext, GraphQLSchemaHelper}
import sangria.schema.{EnumType, ListType, fields}
import scala.concurrent.Future

object GameSnapshotTypeSchema extends GraphQLSchemaHelper("gameSnapshotType") {
  implicit val gameSnapshotTypeEnumType: EnumType[GameSnapshotType] = CommonSchema.deriveStringEnumeratumType(
    name = "GameSnapshotType",
    values = GameSnapshotType.values
  )

  val queryFields = fields(
    unitField(name = "gameSnapshotType", desc = None, t = ListType(gameSnapshotTypeEnumType), f = (_, _) => Future.successful(GameSnapshotType.values))
  )
}
