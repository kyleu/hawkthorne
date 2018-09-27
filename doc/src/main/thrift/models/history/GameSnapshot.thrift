// Generated File
namespace java models.history

include "../../common.thrift"
include "../../result.thrift"

struct GameSnapshot {
  1: required common.UUID id;
  2: required common.UUID gameId;
  3: required string t;
  4: required string snapshot;
  5: required common.LocalDateTime occurred;
}

struct GameSnapshotResult {
  1: required list<result.Filter> filters;
  2: required list<result.OrderBy> orderBys;
  3: required common.int totalCount;
  4: required result.PagingOptions paging;
  5: required list<GameSnapshot> results;
  6: required common.int durationMs;
  7: required common.LocalDateTime occurred;
}
