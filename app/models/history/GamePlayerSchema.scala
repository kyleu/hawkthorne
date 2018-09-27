/* Generated File */
package models.history

import graphql.{GraphQLContext, GraphQLSchemaHelper}
import graphql.GraphQLUtils._
import java.util.UUID
import models.note.NoteSchema
import models.user.SystemUserSchema
import sangria.execution.deferred.{Fetcher, HasId, Relation}
import sangria.schema._

object GamePlayerSchema extends GraphQLSchemaHelper("gamePlayer") {
  implicit val gamePlayerPrimaryKeyId: HasId[GamePlayer, (UUID, Int)] = HasId[GamePlayer, (UUID, Int)](x => (x.gameId, x.idx))
  private[this] def getByPrimaryKeySeq(c: GraphQLContext, idSeq: Seq[(UUID, Int)]) = {
    c.services.historyServices.gamePlayerService.getByPrimaryKeySeq(c.creds, idSeq)(c.trace)
  }
  val gamePlayerByPrimaryKeyFetcher = Fetcher(getByPrimaryKeySeq)

  val gamePlayerGameIdArg = Argument("gameId", uuidType)
  val gamePlayerGameIdSeqArg = Argument("gameIds", ListInputType(uuidType))
  val gamePlayerIdxArg = Argument("idx", IntType)
  val gamePlayerIdxSeqArg = Argument("idxs", ListInputType(IntType))

  val gamePlayerUserIdArg = Argument("userId", uuidType)
  val gamePlayerUserIdSeqArg = Argument("userIds", ListInputType(uuidType))

  val gamePlayerByGameIdRelation = Relation[GamePlayer, UUID]("byGameId", x => Seq(x.gameId))
  val gamePlayerByGameIdFetcher = Fetcher.rel[GraphQLContext, GamePlayer, GamePlayer, (UUID, Int)](
    getByPrimaryKeySeq, (c, rels) => c.services.historyServices.gamePlayerService.getByGameIdSeq(c.creds, rels(gamePlayerByGameIdRelation))(c.trace)
  )

  val gamePlayerByUserIdRelation = Relation[GamePlayer, UUID]("byUserId", x => Seq(x.userId))
  val gamePlayerByUserIdFetcher = Fetcher.rel[GraphQLContext, GamePlayer, GamePlayer, (UUID, Int)](
    getByPrimaryKeySeq, (c, rels) => c.services.historyServices.gamePlayerService.getByUserIdSeq(c.creds, rels(gamePlayerByUserIdRelation))(c.trace)
  )

  implicit lazy val gamePlayerType: sangria.schema.ObjectType[GraphQLContext, GamePlayer] = deriveObjectType(
    sangria.macros.derive.AddFields(
      Field(
        name = "gameIdRel",
        fieldType = GameHistorySchema.gameHistoryType,
        resolve = ctx => GameHistorySchema.gameHistoryByPrimaryKeyFetcher.defer(ctx.value.gameId)
      ),
      Field(
        name = "userIdRel",
        fieldType = SystemUserSchema.systemUserType,
        resolve = ctx => SystemUserSchema.systemUserByPrimaryKeyFetcher.defer(ctx.value.userId)
      ),
      Field(
        name = "relatedNotes",
        fieldType = ListType(NoteSchema.noteType),
        resolve = c => c.ctx.app.coreServices.notes.getFor(c.ctx.creds, "gamePlayer", c.value.gameId, c.value.idx)(c.ctx.trace)
      )
    )
  )

  implicit lazy val gamePlayerResultType: sangria.schema.ObjectType[GraphQLContext, GamePlayerResult] = deriveObjectType()

  val queryFields = fields(
    unitField(name = "gamePlayer", desc = None, t = OptionType(gamePlayerType), f = (c, td) => {
      c.ctx.services.historyServices.gamePlayerService.getByPrimaryKey(c.ctx.creds, c.arg(gamePlayerGameIdArg), c.arg(gamePlayerIdxArg))(td)
    }, gamePlayerGameIdArg, gamePlayerIdxArg),
    unitField(name = "gamePlayerSearch", desc = None, t = gamePlayerResultType, f = (c, td) => {
      runSearch(c.ctx.services.historyServices.gamePlayerService, c, td).map(toResult)
    }, queryArg, reportFiltersArg, orderBysArg, limitArg, offsetArg),
    unitField(name = "gamePlayersByGameId", desc = None, t = ListType(gamePlayerType), f = (c, td) => {
      c.ctx.services.historyServices.gamePlayerService.getByGameId(c.ctx.creds, c.arg(gamePlayerGameIdArg))(td)
    }, gamePlayerGameIdArg),
    unitField(name = "gamePlayersByGameIdSeq", desc = None, t = ListType(gamePlayerType), f = (c, td) => {
      c.ctx.services.historyServices.gamePlayerService.getByGameIdSeq(c.ctx.creds, c.arg(gamePlayerGameIdSeqArg))(td)
    }, gamePlayerGameIdSeqArg),
    unitField(name = "gamePlayersByUserId", desc = None, t = ListType(gamePlayerType), f = (c, td) => {
      c.ctx.services.historyServices.gamePlayerService.getByUserId(c.ctx.creds, c.arg(gamePlayerUserIdArg))(td)
    }, gamePlayerUserIdArg),
    unitField(name = "gamePlayersByUserIdSeq", desc = None, t = ListType(gamePlayerType), f = (c, td) => {
      c.ctx.services.historyServices.gamePlayerService.getByUserIdSeq(c.ctx.creds, c.arg(gamePlayerUserIdSeqArg))(td)
    }, gamePlayerUserIdSeqArg)
  )

  val gamePlayerMutationType = ObjectType(
    name = "GamePlayerMutations",
    fields = fields(
      unitField(name = "create", desc = None, t = OptionType(gamePlayerType), f = (c, td) => {
        c.ctx.services.historyServices.gamePlayerService.create(c.ctx.creds, c.arg(dataFieldsArg))(td)
      }, dataFieldsArg),
      unitField(name = "update", desc = None, t = OptionType(gamePlayerType), f = (c, td) => {
        c.ctx.services.historyServices.gamePlayerService.update(c.ctx.creds, c.arg(gamePlayerGameIdArg), c.arg(gamePlayerIdxArg), c.arg(dataFieldsArg))(td).map(_._1)
      }, gamePlayerGameIdArg, gamePlayerIdxArg, dataFieldsArg),
      unitField(name = "remove", desc = None, t = gamePlayerType, f = (c, td) => {
        c.ctx.services.historyServices.gamePlayerService.remove(c.ctx.creds, c.arg(gamePlayerGameIdArg), c.arg(gamePlayerIdxArg))(td)
      }, gamePlayerGameIdArg, gamePlayerIdxArg)
    )
  )

  val mutationFields = fields(unitField(name = "gamePlayer", desc = None, t = gamePlayerMutationType, f = (_, _) => scala.concurrent.Future.successful(())))

  private[this] def toResult(r: GraphQLSchemaHelper.SearchResult[GamePlayer]) = {
    GamePlayerResult(paging = r.paging, filters = r.args.filters, orderBys = r.args.orderBys, totalCount = r.count, results = r.results, durationMs = r.dur)
  }
}
