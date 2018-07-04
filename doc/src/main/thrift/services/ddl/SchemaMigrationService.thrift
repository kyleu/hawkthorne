// Generated File
namespace java services.ddl

include "../../common.thrift"
include "../../result.thrift"
include "../../models/ddl/SchemaMigration.thrift"

service SchemaMigrationService {
  SchemaMigration.SchemaMigration getByPrimaryKey(
    1: common.Credentials creds,
    2: required common.long installedRank
  )
  SchemaMigration.SchemaMigration getByPrimaryKeySeq(
    1: common.Credentials creds,
    2: required list<common.long> installedRank
  )

  common.int countAll(
    1: common.Credentials creds,
    2: list<result.Filter> filters
  )
  list<SchemaMigration.SchemaMigration> getAll(
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
  list<SchemaMigration.SchemaMigration> search(
    1: common.Credentials creds,
    2: required string q,
    3: list<result.Filter> filters,
    4: list<result.OrderBy> orderBys,
    5: common.int limit,
    6: common.int offset
  )
  list<SchemaMigration.SchemaMigration> searchExact(
    1: common.Credentials creds,
    2: required string q,
    3: list<result.OrderBy> orderBys,
    4: common.int limit,
    5: common.int offset
  )


  SchemaMigration.SchemaMigration insert(
    1: common.Credentials creds,
    2: required SchemaMigration.SchemaMigration model
  )
  common.int insertBatch(
    1: common.Credentials creds,
    2: required list<SchemaMigration.SchemaMigration> models
  )
  SchemaMigration.SchemaMigration create(
    1: common.Credentials creds,
    2: required  common.long installedRank,
    3: list<common.DataField> fields
  )
  SchemaMigration.SchemaMigration remove(
    1: common.Credentials creds,
    2: required  common.long installedRank
  )
  SchemaMigration.SchemaMigration update(
    1: common.Credentials creds,
    2: required  common.long installedRank,
    3: list<common.DataField> fields
  )
}
