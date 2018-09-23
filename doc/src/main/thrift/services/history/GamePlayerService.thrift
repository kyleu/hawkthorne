// Generated File
namespace java services.history

include "../../common.thrift"
include "../../result.thrift"
include "../../models/history/GamePlayer.thrift"

service GamePlayerService {

  common.int countAll(
    1: common.Credentials creds,
    2: list<result.Filter> filters
  )
  list<GamePlayer.GamePlayer> getAll(
    1: common.Credentials creds,
    2: list<result.Filter> filters,
    3: list<result.OrderBy> orderBys,
    4: common.int limit,
    5: common.int offset
  )

  common.int searchCount(
    1: common.Credentials creds,
    2: required string q,
    3: list<result.Filter> filters
  )
  list<GamePlayer.GamePlayer> search(
    1: common.Credentials creds,
    2: required string q,
    3: list<result.Filter> filters,
    4: list<result.OrderBy> orderBys,
    5: common.int limit,
    6: common.int offset
  )
  list<GamePlayer.GamePlayer> searchExact(
    1: common.Credentials creds,
    2: required string q,
    3: list<result.OrderBy> orderBys,
    4: common.int limit,
    5: common.int offset
  )


  GamePlayer.GamePlayer insert(
    1: common.Credentials creds,
    2: required GamePlayer.GamePlayer model
  )
  common.int insertBatch(
    1: common.Credentials creds,
    2: required list<GamePlayer.GamePlayer> models
  )
}
