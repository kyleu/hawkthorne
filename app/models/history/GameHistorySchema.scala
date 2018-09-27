/* Generated File */
package models.history

import graphql.{GraphQLContext, GraphQLSchemaHelper}
import graphql.GraphQLUtils._
import java.util.UUID
import models.GameHistoryTypeSchema.gameHistoryTypeEnumType
import models.note.NoteSchema
import models.user.SystemUserSchema
import sangria.execution.deferred.{Fetcher, HasId, Relation}
import sangria.schema._

object GameHistorySchema extends GraphQLSchemaHelper("gameHistory") {
  implicit val gameHistoryPrimaryKeyId: HasId[GameHistory, UUID] = HasId[GameHistory, UUID](_.id)
  private[this] def getByPrimaryKeySeq(c: GraphQLContext, idSeq: Seq[UUID]) = {
    c.services.historyServices.gameHistoryService.getByPrimaryKeySeq(c.creds, idSeq)(c.trace)
  }
  val gameHistoryByPrimaryKeyFetcher = Fetcher(getByPrimaryKeySeq)

  val gameHistoryIdArg = Argument("id", uuidType)
  val gameHistoryIdSeqArg = Argument("ids", ListInputType(uuidType))

  val gameHistoryGameHistoryTypeArg = Argument("t", gameHistoryTypeEnumType)
  val gameHistoryGameHistoryTypeSeqArg = Argument("ts", ListInputType(gameHistoryTypeEnumType))
  val gameHistoryCreatorArg = Argument("creator", OptionInputType(uuidType))
  val gameHistoryCreatorSeqArg = Argument("creators", ListInputType(uuidType))

  val gameHistoryByCreatorRelation = Relation[GameHistory, Option[UUID]]("byCreator", x => Seq(x.creator))
  val gameHistoryByCreatorFetcher = Fetcher.rel[GraphQLContext, GameHistory, GameHistory, UUID](
    getByPrimaryKeySeq, (c, rels) => c.services.historyServices.gameHistoryService.getByCreatorSeq(c.creds, rels(gameHistoryByCreatorRelation).flatten)(c.trace)
  )

  implicit lazy val gameHistoryType: sangria.schema.ObjectType[GraphQLContext, GameHistory] = deriveObjectType(
    sangria.macros.derive.AddFields(
      Field(
        name = "players",
        fieldType = ListType(GamePlayerSchema.gamePlayerType),
        resolve = c => GamePlayerSchema.gamePlayerByGameIdFetcher.deferRelSeq(
          GamePlayerSchema.gamePlayerByGameIdRelation, c.value.id
        )
      ),
      Field(
        name = "snapshots",
        fieldType = ListType(GameSnapshotSchema.gameSnapshotType),
        resolve = c => GameSnapshotSchema.gameSnapshotByGameIdFetcher.deferRelSeq(
          GameSnapshotSchema.gameSnapshotByGameIdRelation, c.value.id
        )
      ),
      Field(
        name = "creatorRel",
        fieldType = OptionType(SystemUserSchema.systemUserType),
        resolve = ctx => SystemUserSchema.systemUserByPrimaryKeyFetcher.deferOpt(ctx.value.creator)
      ),
      Field(
        name = "relatedNotes",
        fieldType = ListType(NoteSchema.noteType),
        resolve = c => c.ctx.app.coreServices.notes.getFor(c.ctx.creds, "gameHistory", c.value.id)(c.ctx.trace)
      )
    )
  )

  implicit lazy val gameHistoryResultType: sangria.schema.ObjectType[GraphQLContext, GameHistoryResult] = deriveObjectType()

  val queryFields = fields(
    unitField(name = "gameHistory", desc = None, t = OptionType(gameHistoryType), f = (c, td) => {
      c.ctx.services.historyServices.gameHistoryService.getByPrimaryKey(c.ctx.creds, c.arg(gameHistoryIdArg))(td)
    }, gameHistoryIdArg),
    unitField(name = "gameHistorySeq", desc = None, t = ListType(gameHistoryType), f = (c, td) => {
      c.ctx.services.historyServices.gameHistoryService.getByPrimaryKeySeq(c.ctx.creds, c.arg(gameHistoryIdSeqArg))(td)
    }, gameHistoryIdSeqArg),
    unitField(name = "gameHistorySearch", desc = None, t = gameHistoryResultType, f = (c, td) => {
      runSearch(c.ctx.services.historyServices.gameHistoryService, c, td).map(toResult)
    }, queryArg, reportFiltersArg, orderBysArg, limitArg, offsetArg),
    unitField(name = "gameHistoryById", desc = None, t = OptionType(gameHistoryType), f = (c, td) => {
      c.ctx.services.historyServices.gameHistoryService.getById(c.ctx.creds, c.arg(gameHistoryIdArg))(td).map(_.headOption)
    }, gameHistoryIdArg),
    unitField(name = "gameHistoryByIdSeq", desc = None, t = ListType(gameHistoryType), f = (c, td) => {
      c.ctx.services.historyServices.gameHistoryService.getByIdSeq(c.ctx.creds, c.arg(gameHistoryIdSeqArg))(td)
    }, gameHistoryIdSeqArg),
    unitField(name = "gameHistoriesByGameHistoryType", desc = None, t = ListType(gameHistoryType), f = (c, td) => {
      c.ctx.services.historyServices.gameHistoryService.getByGameHistoryType(c.ctx.creds, c.arg(gameHistoryGameHistoryTypeArg))(td)
    }, gameHistoryGameHistoryTypeArg),
    unitField(name = "gameHistoriesByGameHistoryTypeSeq", desc = None, t = ListType(gameHistoryType), f = (c, td) => {
      c.ctx.services.historyServices.gameHistoryService.getByGameHistoryTypeSeq(c.ctx.creds, c.arg(gameHistoryGameHistoryTypeSeqArg))(td)
    }, gameHistoryGameHistoryTypeSeqArg),
    unitField(name = "gameHistoriesByCreator", desc = None, t = ListType(gameHistoryType), f = (c, td) => {
      c.ctx.services.historyServices.gameHistoryService.getByCreator(c.ctx.creds, c.arg(gameHistoryCreatorArg).getOrElse(throw new IllegalStateException("No [creator] provided")))(td)
    }, gameHistoryCreatorArg),
    unitField(name = "gameHistoriesByCreatorSeq", desc = None, t = ListType(gameHistoryType), f = (c, td) => {
      c.ctx.services.historyServices.gameHistoryService.getByCreatorSeq(c.ctx.creds, c.arg(gameHistoryCreatorSeqArg))(td)
    }, gameHistoryCreatorSeqArg)
  )

  val gameHistoryMutationType = ObjectType(
    name = "GameHistoryMutations",
    fields = fields(
      unitField(name = "create", desc = None, t = OptionType(gameHistoryType), f = (c, td) => {
        c.ctx.services.historyServices.gameHistoryService.create(c.ctx.creds, c.arg(dataFieldsArg))(td)
      }, dataFieldsArg),
      unitField(name = "update", desc = None, t = OptionType(gameHistoryType), f = (c, td) => {
        c.ctx.services.historyServices.gameHistoryService.update(c.ctx.creds, c.arg(gameHistoryIdArg), c.arg(dataFieldsArg))(td).map(_._1)
      }, gameHistoryIdArg, dataFieldsArg),
      unitField(name = "remove", desc = None, t = gameHistoryType, f = (c, td) => {
        c.ctx.services.historyServices.gameHistoryService.remove(c.ctx.creds, c.arg(gameHistoryIdArg))(td)
      }, gameHistoryIdArg)
    )
  )

  val mutationFields = fields(unitField(name = "gameHistory", desc = None, t = gameHistoryMutationType, f = (_, _) => scala.concurrent.Future.successful(())))

  private[this] def toResult(r: GraphQLSchemaHelper.SearchResult[GameHistory]) = {
    GameHistoryResult(paging = r.paging, filters = r.args.filters, orderBys = r.args.orderBys, totalCount = r.count, results = r.results, durationMs = r.dur)
  }
}
