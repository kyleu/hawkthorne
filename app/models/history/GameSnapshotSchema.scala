/* Generated File */
package models.history

import graphql.{GraphQLContext, GraphQLSchemaHelper}
import graphql.GraphQLUtils._
import java.util.UUID
import models.GameSnapshotTypeSchema.gameSnapshotTypeEnumType
import models.note.NoteSchema
import sangria.execution.deferred.{Fetcher, HasId, Relation}
import sangria.schema._

object GameSnapshotSchema extends GraphQLSchemaHelper("gameSnapshot") {
  implicit val gameSnapshotPrimaryKeyId: HasId[GameSnapshot, UUID] = HasId[GameSnapshot, UUID](_.id)
  private[this] def getByPrimaryKeySeq(c: GraphQLContext, idSeq: Seq[UUID]) = {
    c.services.historyServices.gameSnapshotService.getByPrimaryKeySeq(c.creds, idSeq)(c.trace)
  }
  val gameSnapshotByPrimaryKeyFetcher = Fetcher(getByPrimaryKeySeq)

  val gameSnapshotIdArg = Argument("id", uuidType)
  val gameSnapshotIdSeqArg = Argument("ids", ListInputType(uuidType))

  val gameSnapshotByGameIdRelation = Relation[GameSnapshot, Option[UUID]]("byGameId", x => Seq(x.gameId))
  val gameSnapshotByGameIdFetcher = Fetcher.rel[GraphQLContext, GameSnapshot, GameSnapshot, UUID](
    getByPrimaryKeySeq, (c, rels) => c.services.historyServices.gameSnapshotService.getByGameIdSeq(c.creds, rels(gameSnapshotByGameIdRelation).flatten)(c.trace)
  )

  implicit lazy val gameSnapshotType: sangria.schema.ObjectType[GraphQLContext, GameSnapshot] = deriveObjectType(
    sangria.macros.derive.AddFields(
      Field(
        name = "gameIdRel",
        fieldType = OptionType(GameHistorySchema.gameHistoryType),
        resolve = ctx => GameHistorySchema.gameHistoryByPrimaryKeyFetcher.deferOpt(ctx.value.gameId)
      ),
      Field(
        name = "relatedNotes",
        fieldType = ListType(NoteSchema.noteType),
        resolve = c => c.ctx.app.coreServices.notes.getFor(c.ctx.creds, "gameSnapshot", c.value.id)(c.ctx.trace)
      )
    )
  )

  implicit lazy val gameSnapshotResultType: sangria.schema.ObjectType[GraphQLContext, GameSnapshotResult] = deriveObjectType()

  val queryFields = fields(
    unitField(name = "gameSnapshot", desc = None, t = OptionType(gameSnapshotType), f = (c, td) => {
      c.ctx.services.historyServices.gameSnapshotService.getByPrimaryKey(c.ctx.creds, c.arg(gameSnapshotIdArg))(td)
    }, gameSnapshotIdArg),
    unitField(name = "gameSnapshotSeq", desc = None, t = ListType(gameSnapshotType), f = (c, td) => {
      c.ctx.services.historyServices.gameSnapshotService.getByPrimaryKeySeq(c.ctx.creds, c.arg(gameSnapshotIdSeqArg))(td)
    }, gameSnapshotIdSeqArg),
    unitField(name = "gameSnapshotSearch", desc = None, t = gameSnapshotResultType, f = (c, td) => {
      runSearch(c.ctx.services.historyServices.gameSnapshotService, c, td).map(toResult)
    }, queryArg, reportFiltersArg, orderBysArg, limitArg, offsetArg),
    unitField(name = "gameSnapshotById", desc = None, t = OptionType(gameSnapshotType), f = (c, td) => {
      c.ctx.services.historyServices.gameSnapshotService.getById(c.ctx.creds, c.arg(gameSnapshotIdArg))(td).map(_.headOption)
    }, gameSnapshotIdArg),
    unitField(name = "gameSnapshotByIdSeq", desc = None, t = ListType(gameSnapshotType), f = (c, td) => {
      c.ctx.services.historyServices.gameSnapshotService.getByIdSeq(c.ctx.creds, c.arg(gameSnapshotIdSeqArg))(td)
    }, gameSnapshotIdSeqArg)
  )

  val gameSnapshotMutationType = ObjectType(
    name = "GameSnapshotMutations",
    fields = fields(
      unitField(name = "create", desc = None, t = OptionType(gameSnapshotType), f = (c, td) => {
        c.ctx.services.historyServices.gameSnapshotService.create(c.ctx.creds, c.arg(dataFieldsArg))(td)
      }, dataFieldsArg),
      unitField(name = "update", desc = None, t = OptionType(gameSnapshotType), f = (c, td) => {
        c.ctx.services.historyServices.gameSnapshotService.update(c.ctx.creds, c.arg(gameSnapshotIdArg), c.arg(dataFieldsArg))(td).map(_._1)
      }, gameSnapshotIdArg, dataFieldsArg),
      unitField(name = "remove", desc = None, t = gameSnapshotType, f = (c, td) => {
        c.ctx.services.historyServices.gameSnapshotService.remove(c.ctx.creds, c.arg(gameSnapshotIdArg))(td)
      }, gameSnapshotIdArg)
    )
  )

  val mutationFields = fields(unitField(name = "gameSnapshot", desc = None, t = gameSnapshotMutationType, f = (_, _) => scala.concurrent.Future.successful(())))

  private[this] def toResult(r: GraphQLSchemaHelper.SearchResult[GameSnapshot]) = {
    GameSnapshotResult(paging = r.paging, filters = r.args.filters, orderBys = r.args.orderBys, totalCount = r.count, results = r.results, durationMs = r.dur)
  }
}
