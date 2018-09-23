// Generated File
namespace java models.history

include "../../common.thrift"
include "../../result.thrift"

struct GamePlayer {
  1: required common.UUID gameId;
  2: required common.UUID userId;
  3: required common.long idx;
  4: required common.LocalDateTime joined;
}

struct GamePlayerResult {
  1: required list<result.Filter> filters;
  2: required list<result.OrderBy> orderBys;
  3: required common.int totalCount;
  4: required result.PagingOptions paging;
  5: required list<GamePlayer> results;
  6: required common.int durationMs;
  7: required common.LocalDateTime occurred;
}
