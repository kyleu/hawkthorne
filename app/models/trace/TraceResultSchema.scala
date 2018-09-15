/* Generated File */
package models.trace

import graphql.{GraphQLContext, GraphQLSchemaHelper}
import graphql.GraphQLUtils._
import java.util.UUID
import models.TraceTypeEnumSchema.traceTypeEnumEnumType
import models.note.NoteSchema
import models.user.SystemUserSchema
import sangria.execution.deferred.{Fetcher, HasId, Relation}
import sangria.schema._

object TraceResultSchema extends GraphQLSchemaHelper("traceResult") {
  implicit val traceResultPrimaryKeyId: HasId[TraceResult, UUID] = HasId[TraceResult, UUID](_.id)
  private[this] def getByPrimaryKeySeq(c: GraphQLContext, idSeq: Seq[UUID]) = {
    c.services.traceServices.traceResultService.getByPrimaryKeySeq(c.creds, idSeq)(c.trace)
  }
  val traceResultByPrimaryKeyFetcher = Fetcher(getByPrimaryKeySeq)

  val traceResultIdArg = Argument("id", uuidType)
  val traceResultIdSeqArg = Argument("ids", ListInputType(uuidType))

  val traceResultTraceTypeEnumArg = Argument("t", traceTypeEnumEnumType)
  val traceResultTraceTypeEnumSeqArg = Argument("ts", ListInputType(traceTypeEnumEnumType))
  val traceResultAuthorArg = Argument("author", OptionInputType(uuidType))
  val traceResultAuthorSeqArg = Argument("authors", ListInputType(uuidType))

  val traceResultByAuthorRelation = Relation[TraceResult, Option[UUID]]("byAuthor", x => Seq(x.author))
  val traceResultByAuthorFetcher = Fetcher.rel[GraphQLContext, TraceResult, TraceResult, UUID](
    getByPrimaryKeySeq, (c, rels) => c.services.traceServices.traceResultService.getByAuthorSeq(c.creds, rels(traceResultByAuthorRelation).flatten)(c.trace)
  )

  implicit lazy val traceResultType: sangria.schema.ObjectType[GraphQLContext, TraceResult] = deriveObjectType(
    sangria.macros.derive.AddFields(
      Field(
        name = "authorRel",
        fieldType = OptionType(SystemUserSchema.systemUserType),
        resolve = ctx => SystemUserSchema.systemUserByPrimaryKeyFetcher.deferOpt(ctx.value.author)
      ),
      Field(
        name = "relatedNotes",
        fieldType = ListType(NoteSchema.noteType),
        resolve = c => c.ctx.app.coreServices.notes.getFor(c.ctx.creds, "traceResult", c.value.id)(c.ctx.trace)
      )
    )
  )

  implicit lazy val traceResultResultType: sangria.schema.ObjectType[GraphQLContext, TraceResultResult] = deriveObjectType()

  val queryFields = fields(
    unitField(name = "traceResult", desc = None, t = OptionType(traceResultType), f = (c, td) => {
      c.ctx.services.traceServices.traceResultService.getByPrimaryKey(c.ctx.creds, c.arg(traceResultIdArg))(td)
    }, traceResultIdArg),
    unitField(name = "traceResultSeq", desc = None, t = ListType(traceResultType), f = (c, td) => {
      c.ctx.services.traceServices.traceResultService.getByPrimaryKeySeq(c.ctx.creds, c.arg(traceResultIdSeqArg))(td)
    }, traceResultIdSeqArg),
    unitField(name = "traceResultSearch", desc = None, t = traceResultResultType, f = (c, td) => {
      runSearch(c.ctx.services.traceServices.traceResultService, c, td).map(toResult)
    }, queryArg, reportFiltersArg, orderBysArg, limitArg, offsetArg),
    unitField(name = "traceResultById", desc = None, t = OptionType(traceResultType), f = (c, td) => {
      c.ctx.services.traceServices.traceResultService.getById(c.ctx.creds, c.arg(traceResultIdArg))(td).map(_.headOption)
    }, traceResultIdArg),
    unitField(name = "traceResultByIdSeq", desc = None, t = ListType(traceResultType), f = (c, td) => {
      c.ctx.services.traceServices.traceResultService.getByIdSeq(c.ctx.creds, c.arg(traceResultIdSeqArg))(td)
    }, traceResultIdSeqArg),
    unitField(name = "traceResultsByTraceTypeEnum", desc = None, t = ListType(traceResultType), f = (c, td) => {
      c.ctx.services.traceServices.traceResultService.getByTraceTypeEnum(c.ctx.creds, c.arg(traceResultTraceTypeEnumArg))(td)
    }, traceResultTraceTypeEnumArg),
    unitField(name = "traceResultsByTraceTypeEnumSeq", desc = None, t = ListType(traceResultType), f = (c, td) => {
      c.ctx.services.traceServices.traceResultService.getByTraceTypeEnumSeq(c.ctx.creds, c.arg(traceResultTraceTypeEnumSeqArg))(td)
    }, traceResultTraceTypeEnumSeqArg),
    unitField(name = "traceResultsByAuthor", desc = None, t = ListType(traceResultType), f = (c, td) => {
      c.ctx.services.traceServices.traceResultService.getByAuthor(c.ctx.creds, c.arg(traceResultAuthorArg).getOrElse(throw new IllegalStateException("No [author] provided")))(td)
    }, traceResultAuthorArg),
    unitField(name = "traceResultsByAuthorSeq", desc = None, t = ListType(traceResultType), f = (c, td) => {
      c.ctx.services.traceServices.traceResultService.getByAuthorSeq(c.ctx.creds, c.arg(traceResultAuthorSeqArg))(td)
    }, traceResultAuthorSeqArg)
  )

  val traceResultMutationType = ObjectType(
    name = "TraceResultMutations",
    fields = fields(
      unitField(name = "create", desc = None, t = OptionType(traceResultType), f = (c, td) => {
        c.ctx.services.traceServices.traceResultService.create(c.ctx.creds, c.arg(dataFieldsArg))(td)
      }, dataFieldsArg),
      unitField(name = "update", desc = None, t = OptionType(traceResultType), f = (c, td) => {
        c.ctx.services.traceServices.traceResultService.update(c.ctx.creds, c.arg(traceResultIdArg), c.arg(dataFieldsArg))(td).map(_._1)
      }, traceResultIdArg, dataFieldsArg),
      unitField(name = "remove", desc = None, t = traceResultType, f = (c, td) => {
        c.ctx.services.traceServices.traceResultService.remove(c.ctx.creds, c.arg(traceResultIdArg))(td)
      }, traceResultIdArg)
    )
  )

  val mutationFields = fields(unitField(name = "traceResult", desc = None, t = traceResultMutationType, f = (_, _) => scala.concurrent.Future.successful(())))

  private[this] def toResult(r: GraphQLSchemaHelper.SearchResult[TraceResult]) = {
    TraceResultResult(paging = r.paging, filters = r.args.filters, orderBys = r.args.orderBys, totalCount = r.count, results = r.results, durationMs = r.dur)
  }
}
