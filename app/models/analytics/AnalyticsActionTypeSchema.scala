/* Generated File */
package models.analytics

import graphql.{CommonSchema, GraphQLContext, GraphQLSchemaHelper}
import sangria.schema.{EnumType, ListType, fields}
import scala.concurrent.Future

object AnalyticsActionTypeSchema extends GraphQLSchemaHelper("analyticsActionType") {
  implicit val analyticsActionTypeEnumType: EnumType[AnalyticsActionType] = CommonSchema.deriveStringEnumeratumType(
    name = "AnalyticsActionType",
    values = AnalyticsActionType.values
  )

  val queryFields = fields(
    unitField(name = "analyticsActionType", desc = None, t = ListType(analyticsActionTypeEnumType), f = (_, _) => Future.successful(AnalyticsActionType.values))
  )
}
