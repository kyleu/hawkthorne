// Generated File
namespace java services.trace

include "../../common.thrift"
include "../../result.thrift"
include "../../models/trace/TraceResult.thrift"

service TraceResultService {
  TraceResult.TraceResult getByPrimaryKey(
    1: common.Credentials creds,
    2: required common.UUID id
  )
  TraceResult.TraceResult getByPrimaryKeySeq(
    1: common.Credentials creds,
    2: required list<common.UUID> id
  )

  common.int countAll(
    1: common.Credentials creds,
    2: list<result.Filter> filters
  )
  list<TraceResult.TraceResult> getAll(
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
  list<TraceResult.TraceResult> search(
    1: common.Credentials creds,
    2: required string q,
    3: list<result.Filter> filters,
    4: list<result.OrderBy> orderBys,
    5: common.int limit,
    6: common.int offset
  )
  list<TraceResult.TraceResult> searchExact(
    1: common.Credentials creds,
    2: required string q,
    3: list<result.OrderBy> orderBys,
    4: common.int limit,
    5: common.int offset
  )


  TraceResult.TraceResult insert(
    1: common.Credentials creds,
    2: required TraceResult.TraceResult model
  )
  common.int insertBatch(
    1: common.Credentials creds,
    2: required list<TraceResult.TraceResult> models
  )
  TraceResult.TraceResult create(
    1: common.Credentials creds,
    2: required  common.UUID id,
    3: list<common.DataField> fields
  )
  TraceResult.TraceResult remove(
    1: common.Credentials creds,
    2: required  common.UUID id
  )
  TraceResult.TraceResult update(
    1: common.Credentials creds,
    2: required  common.UUID id,
    3: list<common.DataField> fields
  )
}
