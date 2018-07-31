/* Generated File */
package models.ddl

import graphql.{GraphQLContext, GraphQLSchemaHelper}
import graphql.GraphQLUtils._
import models.note.NoteSchema
import sangria.execution.deferred.{Fetcher, HasId}
import sangria.schema._

object SchemaMigrationSchema extends GraphQLSchemaHelper("schemaMigration") {
  implicit val schemaMigrationPrimaryKeyId: HasId[SchemaMigration, Long] = HasId[SchemaMigration, Long](_.installedRank)
  private[this] def getByPrimaryKeySeq(c: GraphQLContext, idSeq: Seq[Long]) = {
    c.services.ddlServices.schemaMigrationService.getByPrimaryKeySeq(c.creds, idSeq)(c.trace)
  }
  val schemaMigrationByPrimaryKeyFetcher = Fetcher(getByPrimaryKeySeq)

  val schemaMigrationInstalledRankArg = Argument("installedRank", LongType)
  val schemaMigrationInstalledRankSeqArg = Argument("installedRanks", ListInputType(LongType))

  val schemaMigrationSuccessArg = Argument("success", BooleanType)
  val schemaMigrationSuccessSeqArg = Argument("successs", ListInputType(BooleanType))

  implicit lazy val schemaMigrationType: sangria.schema.ObjectType[GraphQLContext, SchemaMigration] = deriveObjectType()

  implicit lazy val schemaMigrationResultType: sangria.schema.ObjectType[GraphQLContext, SchemaMigrationResult] = deriveObjectType()

  val queryFields = fields(
    unitField(name = "schemaMigration", desc = None, t = OptionType(schemaMigrationType), f = (c, td) => {
      c.ctx.services.ddlServices.schemaMigrationService.getByPrimaryKey(c.ctx.creds, c.arg(schemaMigrationInstalledRankArg))(td)
    }, schemaMigrationInstalledRankArg),
    unitField(name = "schemaMigrationSeq", desc = None, t = ListType(schemaMigrationType), f = (c, td) => {
      c.ctx.services.ddlServices.schemaMigrationService.getByPrimaryKeySeq(c.ctx.creds, c.arg(schemaMigrationInstalledRankSeqArg))(td)
    }, schemaMigrationInstalledRankSeqArg),
    unitField(name = "schemaMigrationSearch", desc = None, t = schemaMigrationResultType, f = (c, td) => {
      runSearch(c.ctx.services.ddlServices.schemaMigrationService, c, td).map(toResult)
    }, queryArg, reportFiltersArg, orderBysArg, limitArg, offsetArg),
    unitField(name = "schemaMigrationByInstalledRank", desc = None, t = OptionType(schemaMigrationType), f = (c, td) => {
      c.ctx.services.ddlServices.schemaMigrationService.getByInstalledRank(c.ctx.creds, c.arg(schemaMigrationInstalledRankArg))(td).map(_.headOption)
    }, schemaMigrationInstalledRankArg),
    unitField(name = "schemaMigrationByInstalledRankSeq", desc = None, t = ListType(schemaMigrationType), f = (c, td) => {
      c.ctx.services.ddlServices.schemaMigrationService.getByInstalledRankSeq(c.ctx.creds, c.arg(schemaMigrationInstalledRankSeqArg))(td)
    }, schemaMigrationInstalledRankSeqArg),
    unitField(name = "schemaMigrationsBySuccess", desc = None, t = ListType(schemaMigrationType), f = (c, td) => {
      c.ctx.services.ddlServices.schemaMigrationService.getBySuccess(c.ctx.creds, c.arg(schemaMigrationSuccessArg))(td)
    }, schemaMigrationSuccessArg),
    unitField(name = "schemaMigrationsBySuccessSeq", desc = None, t = ListType(schemaMigrationType), f = (c, td) => {
      c.ctx.services.ddlServices.schemaMigrationService.getBySuccessSeq(c.ctx.creds, c.arg(schemaMigrationSuccessSeqArg))(td)
    }, schemaMigrationSuccessSeqArg)
  )

  val schemaMigrationMutationType = ObjectType(
    name = "SchemaMigrationMutations",
    fields = fields(
      unitField(name = "create", desc = None, t = OptionType(schemaMigrationType), f = (c, td) => {
        c.ctx.services.ddlServices.schemaMigrationService.create(c.ctx.creds, c.arg(dataFieldsArg))(td)
      }, dataFieldsArg),
      unitField(name = "update", desc = None, t = OptionType(schemaMigrationType), f = (c, td) => {
        c.ctx.services.ddlServices.schemaMigrationService.update(c.ctx.creds, c.arg(schemaMigrationInstalledRankArg), c.arg(dataFieldsArg))(td).map(_._1)
      }, schemaMigrationInstalledRankArg, dataFieldsArg),
      unitField(name = "remove", desc = None, t = schemaMigrationType, f = (c, td) => {
        c.ctx.services.ddlServices.schemaMigrationService.remove(c.ctx.creds, c.arg(schemaMigrationInstalledRankArg))(td)
      }, schemaMigrationInstalledRankArg)
    )
  )

  val mutationFields = fields(unitField(name = "schemaMigration", desc = None, t = schemaMigrationMutationType, f = (_, _) => scala.concurrent.Future.successful(())))

  private[this] def toResult(r: GraphQLSchemaHelper.SearchResult[SchemaMigration]) = {
    SchemaMigrationResult(paging = r.paging, filters = r.args.filters, orderBys = r.args.orderBys, totalCount = r.count, results = r.results, durationMs = r.dur)
  }
}
