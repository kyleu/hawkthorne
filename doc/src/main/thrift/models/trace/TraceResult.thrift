// Generated File
namespace java models.trace

include "../../common.thrift"
include "../../result.thrift"

struct TraceResult {
  1: required common.UUID id;
  2: required string t;
  3: required string data;
  4: optional common.UUID author;
  5: required common.LocalDateTime occurred;
}

struct TraceResultResult {
  1: required list<result.Filter> filters;
  2: required list<result.OrderBy> orderBys;
  3: required common.int totalCount;
  4: required result.PagingOptions paging;
  5: required list<TraceResult> results;
  6: required common.int durationMs;
  7: required common.LocalDateTime occurred;
}
