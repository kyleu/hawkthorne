/* Generated File */
package models

import graphql.{CommonSchema, GraphQLContext, GraphQLSchemaHelper}
import sangria.schema.{EnumType, ListType, fields}
import scala.concurrent.Future

object TraceTypeEnumSchema extends GraphQLSchemaHelper("traceTypeEnum") {
  implicit val traceTypeEnumEnumType: EnumType[TraceTypeEnum] = CommonSchema.deriveStringEnumeratumType(
    name = "TraceTypeEnum",
    values = TraceTypeEnum.values
  )

  val queryFields = fields(
    unitField(name = "traceTypeEnum", desc = None, t = ListType(traceTypeEnumEnumType), f = (_, _) => Future.successful(TraceTypeEnum.values))
  )
}
