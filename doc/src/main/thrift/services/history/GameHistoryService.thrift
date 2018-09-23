// Generated File
namespace java services.history

include "../../common.thrift"
include "../../result.thrift"
include "../../models/history/GameHistory.thrift"

service GameHistoryService {
  GameHistory.GameHistory getByPrimaryKey(
    1: common.Credentials creds,
    2: required common.UUID id
  )
  GameHistory.GameHistory getByPrimaryKeySeq(
    1: common.Credentials creds,
    2: required list<common.UUID> id
  )

  common.int countAll(
    1: common.Credentials creds,
    2: list<result.Filter> filters
  )
  list<GameHistory.GameHistory> getAll(
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
  list<GameHistory.GameHistory> search(
    1: common.Credentials creds,
    2: required string q,
    3: list<result.Filter> filters,
    4: list<result.OrderBy> orderBys,
    5: common.int limit,
    6: common.int offset
  )
  list<GameHistory.GameHistory> searchExact(
    1: common.Credentials creds,
    2: required string q,
    3: list<result.OrderBy> orderBys,
    4: common.int limit,
    5: common.int offset
  )


  GameHistory.GameHistory insert(
    1: common.Credentials creds,
    2: required GameHistory.GameHistory model
  )
  common.int insertBatch(
    1: common.Credentials creds,
    2: required list<GameHistory.GameHistory> models
  )
  GameHistory.GameHistory create(
    1: common.Credentials creds,
    2: required  common.UUID id,
    3: list<common.DataField> fields
  )
  GameHistory.GameHistory remove(
    1: common.Credentials creds,
    2: required  common.UUID id
  )
  GameHistory.GameHistory update(
    1: common.Credentials creds,
    2: required  common.UUID id,
    3: list<common.DataField> fields
  )
}
