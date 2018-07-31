/* Generated File */
package models.analytics

import graphql.{GraphQLContext, GraphQLSchemaHelper}
import graphql.GraphQLUtils._
import java.util.UUID
import models.analytics.AnalyticsActionTypeSchema.analyticsActionTypeEnumType
import models.note.NoteSchema
import models.user.SystemUserSchema
import sangria.execution.deferred.{Fetcher, HasId, Relation}
import sangria.schema._

object AnalyticsActionSchema extends GraphQLSchemaHelper("analyticsAction") {
  implicit val analyticsActionPrimaryKeyId: HasId[AnalyticsAction, UUID] = HasId[AnalyticsAction, UUID](_.id)
  private[this] def getByPrimaryKeySeq(c: GraphQLContext, idSeq: Seq[UUID]) = {
    c.services.analyticsServices.analyticsActionService.getByPrimaryKeySeq(c.creds, idSeq)(c.trace)
  }
  val analyticsActionByPrimaryKeyFetcher = Fetcher(getByPrimaryKeySeq)

  val analyticsActionIdArg = Argument("id", uuidType)
  val analyticsActionIdSeqArg = Argument("ids", ListInputType(uuidType))

  val analyticsActionAnalyticsActionTypeArg = Argument("t", analyticsActionTypeEnumType)
  val analyticsActionAnalyticsActionTypeSeqArg = Argument("ts", ListInputType(analyticsActionTypeEnumType))
  val analyticsActionAuthorArg = Argument("author", uuidType)
  val analyticsActionAuthorSeqArg = Argument("authors", ListInputType(uuidType))

  val analyticsActionByAuthorRelation = Relation[AnalyticsAction, UUID]("byAuthor", x => Seq(x.author))
  val analyticsActionByAuthorFetcher = Fetcher.rel[GraphQLContext, AnalyticsAction, AnalyticsAction, UUID](
    getByPrimaryKeySeq, (c, rels) => c.services.analyticsServices.analyticsActionService.getByAuthorSeq(c.creds, rels(analyticsActionByAuthorRelation))(c.trace)
  )

  implicit lazy val analyticsActionType: sangria.schema.ObjectType[GraphQLContext, AnalyticsAction] = deriveObjectType(
    sangria.macros.derive.AddFields(
      Field(
        name = "authorRel",
        fieldType = SystemUserSchema.systemUserType,
        resolve = ctx => SystemUserSchema.systemUserByPrimaryKeyFetcher.defer(ctx.value.author)
      ),
      Field(
        name = "relatedNotes",
        fieldType = ListType(NoteSchema.noteType),
        resolve = c => c.ctx.app.coreServices.notes.getFor(c.ctx.creds, "analyticsAction", c.value.id)(c.ctx.trace)
      )
    )
  )

  implicit lazy val analyticsActionResultType: sangria.schema.ObjectType[GraphQLContext, AnalyticsActionResult] = deriveObjectType()

  val queryFields = fields(
    unitField(name = "analyticsAction", desc = None, t = OptionType(analyticsActionType), f = (c, td) => {
      c.ctx.services.analyticsServices.analyticsActionService.getByPrimaryKey(c.ctx.creds, c.arg(analyticsActionIdArg))(td)
    }, analyticsActionIdArg),
    unitField(name = "analyticsActionSeq", desc = None, t = ListType(analyticsActionType), f = (c, td) => {
      c.ctx.services.analyticsServices.analyticsActionService.getByPrimaryKeySeq(c.ctx.creds, c.arg(analyticsActionIdSeqArg))(td)
    }, analyticsActionIdSeqArg),
    unitField(name = "analyticsActionSearch", desc = None, t = analyticsActionResultType, f = (c, td) => {
      runSearch(c.ctx.services.analyticsServices.analyticsActionService, c, td).map(toResult)
    }, queryArg, reportFiltersArg, orderBysArg, limitArg, offsetArg),
    unitField(name = "analyticsActionById", desc = None, t = OptionType(analyticsActionType), f = (c, td) => {
      c.ctx.services.analyticsServices.analyticsActionService.getById(c.ctx.creds, c.arg(analyticsActionIdArg))(td).map(_.headOption)
    }, analyticsActionIdArg),
    unitField(name = "analyticsActionByIdSeq", desc = None, t = ListType(analyticsActionType), f = (c, td) => {
      c.ctx.services.analyticsServices.analyticsActionService.getByIdSeq(c.ctx.creds, c.arg(analyticsActionIdSeqArg))(td)
    }, analyticsActionIdSeqArg),
    unitField(name = "analyticsActionsByAnalyticsActionType", desc = None, t = ListType(analyticsActionType), f = (c, td) => {
      c.ctx.services.analyticsServices.analyticsActionService.getByAnalyticsActionType(c.ctx.creds, c.arg(analyticsActionAnalyticsActionTypeArg))(td)
    }, analyticsActionAnalyticsActionTypeArg),
    unitField(name = "analyticsActionsByAnalyticsActionTypeSeq", desc = None, t = ListType(analyticsActionType), f = (c, td) => {
      c.ctx.services.analyticsServices.analyticsActionService.getByAnalyticsActionTypeSeq(c.ctx.creds, c.arg(analyticsActionAnalyticsActionTypeSeqArg))(td)
    }, analyticsActionAnalyticsActionTypeSeqArg),
    unitField(name = "analyticsActionsByAuthor", desc = None, t = ListType(analyticsActionType), f = (c, td) => {
      c.ctx.services.analyticsServices.analyticsActionService.getByAuthor(c.ctx.creds, c.arg(analyticsActionAuthorArg))(td)
    }, analyticsActionAuthorArg),
    unitField(name = "analyticsActionsByAuthorSeq", desc = None, t = ListType(analyticsActionType), f = (c, td) => {
      c.ctx.services.analyticsServices.analyticsActionService.getByAuthorSeq(c.ctx.creds, c.arg(analyticsActionAuthorSeqArg))(td)
    }, analyticsActionAuthorSeqArg)
  )

  val analyticsActionMutationType = ObjectType(
    name = "AnalyticsActionMutations",
    fields = fields(
      unitField(name = "create", desc = None, t = OptionType(analyticsActionType), f = (c, td) => {
        c.ctx.services.analyticsServices.analyticsActionService.create(c.ctx.creds, c.arg(dataFieldsArg))(td)
      }, dataFieldsArg),
      unitField(name = "update", desc = None, t = OptionType(analyticsActionType), f = (c, td) => {
        c.ctx.services.analyticsServices.analyticsActionService.update(c.ctx.creds, c.arg(analyticsActionIdArg), c.arg(dataFieldsArg))(td).map(_._1)
      }, analyticsActionIdArg, dataFieldsArg),
      unitField(name = "remove", desc = None, t = analyticsActionType, f = (c, td) => {
        c.ctx.services.analyticsServices.analyticsActionService.remove(c.ctx.creds, c.arg(analyticsActionIdArg))(td)
      }, analyticsActionIdArg)
    )
  )

  val mutationFields = fields(unitField(name = "analyticsAction", desc = None, t = analyticsActionMutationType, f = (_, _) => scala.concurrent.Future.successful(())))

  private[this] def toResult(r: GraphQLSchemaHelper.SearchResult[AnalyticsAction]) = {
    AnalyticsActionResult(paging = r.paging, filters = r.args.filters, orderBys = r.args.orderBys, totalCount = r.count, results = r.results, durationMs = r.dur)
  }
}
