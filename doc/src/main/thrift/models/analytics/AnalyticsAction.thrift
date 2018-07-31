// Generated File
namespace java models.analytics

include "../../common.thrift"
include "../../result.thrift"

struct AnalyticsAction {
  1: required common.UUID id;
  2: required string t;
  3: required string arg;
  4: required common.UUID author;
  5: required string status;
  6: required common.LocalDateTime occurred;
}

struct AnalyticsActionResult {
  1: required list<result.Filter> filters;
  2: required list<result.OrderBy> orderBys;
  3: required common.int totalCount;
  4: required result.PagingOptions paging;
  5: required list<AnalyticsAction> results;
  6: required common.int durationMs;
  7: required common.LocalDateTime occurred;
}
