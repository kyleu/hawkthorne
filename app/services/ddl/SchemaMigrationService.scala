/* Generated File */
package services.ddl

import models.auth.Credentials
import models.ddl.SchemaMigration
import models.queries.ddl.SchemaMigrationQueries
import models.result.data.DataField
import models.result.filter.Filter
import models.result.orderBy.OrderBy
import scala.concurrent.Future
import services.ModelServiceHelper
import services.database.ApplicationDatabase
import util.FutureUtils.serviceContext
import util.tracing.{TraceData, TracingService}

@javax.inject.Singleton
class SchemaMigrationService @javax.inject.Inject() (override val tracing: TracingService) extends ModelServiceHelper[SchemaMigration]("schemaMigration") {
  def getByPrimaryKey(creds: Credentials, installedRank: Long)(implicit trace: TraceData) = {
    traceF("get.by.primary.key")(td => ApplicationDatabase.queryF(SchemaMigrationQueries.getByPrimaryKey(installedRank))(td))
  }
  def getByPrimaryKeyRequired(creds: Credentials, installedRank: Long)(implicit trace: TraceData) = getByPrimaryKey(creds, installedRank).map { opt =>
    opt.getOrElse(throw new IllegalStateException(s"Cannot load schemaMigration with installedRank [$installedRank]."))
  }
  def getByPrimaryKeySeq(creds: Credentials, installedRankSeq: Seq[Long])(implicit trace: TraceData) = {
    traceF("get.by.primary.key.seq")(td => ApplicationDatabase.queryF(SchemaMigrationQueries.getByPrimaryKeySeq(installedRankSeq))(td))
  }

  override def countAll(creds: Credentials, filters: Seq[Filter] = Nil)(implicit trace: TraceData) = {
    traceF("get.all.count")(td => ApplicationDatabase.queryF(SchemaMigrationQueries.countAll(filters))(td))
  }
  override def getAll(creds: Credentials, filters: Seq[Filter] = Nil, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None)(implicit trace: TraceData) = {
    traceF("get.all")(td => ApplicationDatabase.queryF(SchemaMigrationQueries.getAll(filters, orderBys, limit, offset))(td))
  }

  // Search
  override def searchCount(creds: Credentials, q: Option[String], filters: Seq[Filter] = Nil)(implicit trace: TraceData) = {
    traceF("search.count")(td => ApplicationDatabase.queryF(SchemaMigrationQueries.searchCount(q, filters))(td))
  }
  override def search(
    creds: Credentials, q: Option[String], filters: Seq[Filter] = Nil, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None
  )(implicit trace: TraceData) = {
    traceF("search")(td => ApplicationDatabase.queryF(SchemaMigrationQueries.search(q, filters, orderBys, limit, offset))(td))
  }

  def searchExact(
    creds: Credentials, q: String, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None
  )(implicit trace: TraceData) = {
    traceF("search.exact")(td => ApplicationDatabase.queryF(SchemaMigrationQueries.searchExact(q, orderBys, limit, offset))(td))
  }

  def countByDescription(creds: Credentials, description: String)(implicit trace: TraceData) = traceF("count.by.description") { td =>
    ApplicationDatabase.queryF(SchemaMigrationQueries.CountByDescription(description))(td)
  }
  def getByDescription(creds: Credentials, description: String, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None)(implicit trace: TraceData) = traceF("get.by.description") { td =>
    ApplicationDatabase.queryF(SchemaMigrationQueries.GetByDescription(description, orderBys, limit, offset))(td)
  }
  def getByDescriptionSeq(creds: Credentials, descriptionSeq: Seq[String])(implicit trace: TraceData) = traceF("get.by.description.seq") { td =>
    ApplicationDatabase.queryF(SchemaMigrationQueries.GetByDescriptionSeq(descriptionSeq))(td)
  }

  def countByInstalledRank(creds: Credentials, installedRank: Long)(implicit trace: TraceData) = traceF("count.by.installedRank") { td =>
    ApplicationDatabase.queryF(SchemaMigrationQueries.CountByInstalledRank(installedRank))(td)
  }
  def getByInstalledRank(creds: Credentials, installedRank: Long, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None)(implicit trace: TraceData) = traceF("get.by.installedRank") { td =>
    ApplicationDatabase.queryF(SchemaMigrationQueries.GetByInstalledRank(installedRank, orderBys, limit, offset))(td)
  }
  def getByInstalledRankSeq(creds: Credentials, installedRankSeq: Seq[Long])(implicit trace: TraceData) = traceF("get.by.installedRank.seq") { td =>
    ApplicationDatabase.queryF(SchemaMigrationQueries.GetByInstalledRankSeq(installedRankSeq))(td)
  }

  def countBySuccess(creds: Credentials, success: Boolean)(implicit trace: TraceData) = traceF("count.by.success") { td =>
    ApplicationDatabase.queryF(SchemaMigrationQueries.CountBySuccess(success))(td)
  }
  def getBySuccess(creds: Credentials, success: Boolean, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None)(implicit trace: TraceData) = traceF("get.by.success") { td =>
    ApplicationDatabase.queryF(SchemaMigrationQueries.GetBySuccess(success, orderBys, limit, offset))(td)
  }
  def getBySuccessSeq(creds: Credentials, successSeq: Seq[Boolean])(implicit trace: TraceData) = traceF("get.by.success.seq") { td =>
    ApplicationDatabase.queryF(SchemaMigrationQueries.GetBySuccessSeq(successSeq))(td)
  }

  def countByTyp(creds: Credentials, typ: String)(implicit trace: TraceData) = traceF("count.by.typ") { td =>
    ApplicationDatabase.queryF(SchemaMigrationQueries.CountByTyp(typ))(td)
  }
  def getByTyp(creds: Credentials, typ: String, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None)(implicit trace: TraceData) = traceF("get.by.typ") { td =>
    ApplicationDatabase.queryF(SchemaMigrationQueries.GetByTyp(typ, orderBys, limit, offset))(td)
  }
  def getByTypSeq(creds: Credentials, typSeq: Seq[String])(implicit trace: TraceData) = traceF("get.by.typ.seq") { td =>
    ApplicationDatabase.queryF(SchemaMigrationQueries.GetByTypSeq(typSeq))(td)
  }

  def countByVersion(creds: Credentials, version: String)(implicit trace: TraceData) = traceF("count.by.version") { td =>
    ApplicationDatabase.queryF(SchemaMigrationQueries.CountByVersion(version))(td)
  }
  def getByVersion(creds: Credentials, version: String, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None)(implicit trace: TraceData) = traceF("get.by.version") { td =>
    ApplicationDatabase.queryF(SchemaMigrationQueries.GetByVersion(version, orderBys, limit, offset))(td)
  }
  def getByVersionSeq(creds: Credentials, versionSeq: Seq[String])(implicit trace: TraceData) = traceF("get.by.version.seq") { td =>
    ApplicationDatabase.queryF(SchemaMigrationQueries.GetByVersionSeq(versionSeq))(td)
  }

  // Mutations
  def insert(creds: Credentials, model: SchemaMigration)(implicit trace: TraceData) = traceF("insert") { td =>
    ApplicationDatabase.executeF(SchemaMigrationQueries.insert(model))(td).flatMap {
      case 1 => getByPrimaryKey(creds, model.installedRank)(td)
      case _ => throw new IllegalStateException("Unable to find newly-inserted Schema Migration.")
    }
  }
  def insertBatch(creds: Credentials, models: Seq[SchemaMigration])(implicit trace: TraceData) = {
    traceF("insertBatch")(td => ApplicationDatabase.executeF(SchemaMigrationQueries.insertBatch(models))(td))
  }
  def create(creds: Credentials, fields: Seq[DataField])(implicit trace: TraceData) = traceF("create") { td =>
    ApplicationDatabase.executeF(SchemaMigrationQueries.create(fields))(td).flatMap { _ =>
      getByPrimaryKey(creds, fieldVal(fields, "installedRank").toLong)
    }
  }

  def remove(creds: Credentials, installedRank: Long)(implicit trace: TraceData) = {
    traceF("remove")(td => getByPrimaryKey(creds, installedRank)(td).flatMap {
      case Some(current) =>
        ApplicationDatabase.executeF(SchemaMigrationQueries.removeByPrimaryKey(installedRank))(td).map(_ => current)
      case None => throw new IllegalStateException(s"Cannot find SchemaMigration matching [$installedRank].")
    })
  }

  def update(creds: Credentials, installedRank: Long, fields: Seq[DataField])(implicit trace: TraceData) = {
    traceF("update")(td => getByPrimaryKey(creds, installedRank)(td).flatMap {
      case Some(current) if fields.isEmpty => Future.successful(current -> s"No changes required for Schema Migration [$installedRank].")
      case Some(_) => ApplicationDatabase.executeF(SchemaMigrationQueries.update(installedRank, fields))(td).flatMap { _ =>
        getByPrimaryKey(creds, installedRank)(td).map {
          case Some(newModel) =>
            newModel -> s"Updated [${fields.size}] fields of Schema Migration [$installedRank]."
          case None => throw new IllegalStateException(s"Cannot find SchemaMigration matching [$installedRank].")
        }
      }
      case None => throw new IllegalStateException(s"Cannot find SchemaMigration matching [$installedRank].")
    })
  }

  def csvFor(totalCount: Int, rows: Seq[SchemaMigration])(implicit trace: TraceData) = {
    traceB("export.csv")(td => util.CsvUtils.csvFor(Some(key), totalCount, rows, SchemaMigrationQueries.fields)(td))
  }
}
