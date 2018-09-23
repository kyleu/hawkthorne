// Generated File
namespace java services.history

include "../../common.thrift"
include "../../result.thrift"
include "../../models/history/GameSnapshot.thrift"

service GameSnapshotService {
  GameSnapshot.GameSnapshot getByPrimaryKey(
    1: common.Credentials creds,
    2: required common.UUID id
  )
  GameSnapshot.GameSnapshot getByPrimaryKeySeq(
    1: common.Credentials creds,
    2: required list<common.UUID> id
  )

  common.int countAll(
    1: common.Credentials creds,
    2: list<result.Filter> filters
  )
  list<GameSnapshot.GameSnapshot> getAll(
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
  list<GameSnapshot.GameSnapshot> search(
    1: common.Credentials creds,
    2: required string q,
    3: list<result.Filter> filters,
    4: list<result.OrderBy> orderBys,
    5: common.int limit,
    6: common.int offset
  )
  list<GameSnapshot.GameSnapshot> searchExact(
    1: common.Credentials creds,
    2: required string q,
    3: list<result.OrderBy> orderBys,
    4: common.int limit,
    5: common.int offset
  )


  GameSnapshot.GameSnapshot insert(
    1: common.Credentials creds,
    2: required GameSnapshot.GameSnapshot model
  )
  common.int insertBatch(
    1: common.Credentials creds,
    2: required list<GameSnapshot.GameSnapshot> models
  )
  GameSnapshot.GameSnapshot create(
    1: common.Credentials creds,
    2: required  common.UUID id,
    3: list<common.DataField> fields
  )
  GameSnapshot.GameSnapshot remove(
    1: common.Credentials creds,
    2: required  common.UUID id
  )
  GameSnapshot.GameSnapshot update(
    1: common.Credentials creds,
    2: required  common.UUID id,
    3: list<common.DataField> fields
  )
}
