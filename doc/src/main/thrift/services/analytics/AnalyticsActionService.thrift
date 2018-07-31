// Generated File
namespace java services.analytics

include "../../common.thrift"
include "../../result.thrift"
include "../../models/analytics/AnalyticsAction.thrift"

service AnalyticsActionService {
  AnalyticsAction.AnalyticsAction getByPrimaryKey(
    1: common.Credentials creds,
    2: required common.UUID id
  )
  AnalyticsAction.AnalyticsAction getByPrimaryKeySeq(
    1: common.Credentials creds,
    2: required list<common.UUID> id
  )

  common.int countAll(
    1: common.Credentials creds,
    2: list<result.Filter> filters
  )
  list<AnalyticsAction.AnalyticsAction> getAll(
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
  list<AnalyticsAction.AnalyticsAction> search(
    1: common.Credentials creds,
    2: required string q,
    3: list<result.Filter> filters,
    4: list<result.OrderBy> orderBys,
    5: common.int limit,
    6: common.int offset
  )
  list<AnalyticsAction.AnalyticsAction> searchExact(
    1: common.Credentials creds,
    2: required string q,
    3: list<result.OrderBy> orderBys,
    4: common.int limit,
    5: common.int offset
  )


  AnalyticsAction.AnalyticsAction insert(
    1: common.Credentials creds,
    2: required AnalyticsAction.AnalyticsAction model
  )
  common.int insertBatch(
    1: common.Credentials creds,
    2: required list<AnalyticsAction.AnalyticsAction> models
  )
  AnalyticsAction.AnalyticsAction create(
    1: common.Credentials creds,
    2: required  common.UUID id,
    3: list<common.DataField> fields
  )
  AnalyticsAction.AnalyticsAction remove(
    1: common.Credentials creds,
    2: required  common.UUID id
  )
  AnalyticsAction.AnalyticsAction update(
    1: common.Credentials creds,
    2: required  common.UUID id,
    3: list<common.DataField> fields
  )
}
