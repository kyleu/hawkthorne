// Generated File
namespace java models.history

include "../../common.thrift"
include "../../result.thrift"

struct GameHistory {
  1: required common.UUID id;
  2: required string t;
  3: required string options;
  4: optional common.UUID creator;
  5: required common.LocalDateTime started;
}

struct GameHistoryResult {
  1: required list<result.Filter> filters;
  2: required list<result.OrderBy> orderBys;
  3: required common.int totalCount;
  4: required result.PagingOptions paging;
  5: required list<GameHistory> results;
  6: required common.int durationMs;
  7: required common.LocalDateTime occurred;
}
