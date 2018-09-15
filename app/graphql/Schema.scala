package graphql

import sangria.execution.deferred.DeferredResolver
import sangria.schema._
import util.Config

import scala.concurrent.Future

object Schema {
  // Fetchers
  val baseFetchers = Seq(models.user.SystemUserSchema.systemUserByRoleFetcher, models.audit.AuditSchema.auditByUserIdFetcher)

  val modelFetchers = {
    // Start model fetchers
    Seq(
      models.analytics.AnalyticsActionSchema.analyticsActionByAuthorFetcher,
      models.analytics.AnalyticsActionSchema.analyticsActionByPrimaryKeyFetcher,
      models.audit.AuditRecordSchema.auditRecordByAuditIdFetcher,
      models.audit.AuditRecordSchema.auditRecordByPrimaryKeyFetcher,
      models.audit.AuditSchema.auditByPrimaryKeyFetcher,
      models.ddl.SchemaMigrationSchema.schemaMigrationByPrimaryKeyFetcher,
      models.note.NoteSchema.noteByAuthorFetcher,
      models.note.NoteSchema.noteByPrimaryKeyFetcher,
      models.sync.SyncProgressSchema.syncProgressByPrimaryKeyFetcher,
      models.task.ScheduledTaskRunSchema.scheduledTaskRunByPrimaryKeyFetcher,
      models.trace.TraceResultSchema.traceResultByAuthorFetcher,
      models.trace.TraceResultSchema.traceResultByPrimaryKeyFetcher,
      models.user.SystemUserSchema.systemUserByPrimaryKeyFetcher
    )
    // End model fetchers
  }

  val resolver = DeferredResolver.fetchers(baseFetchers ++ modelFetchers: _*)

  private[this] val customQueryFields = fields[GraphQLContext, Unit](
    Field(name = "status", fieldType = StringType, resolve = _ => Future.successful("OK")),
    Field(name = "version", fieldType = StringType, resolve = _ => Future.successful(Config.version))
  )

  // Query Types
  val baseQueryFields = customQueryFields ++
    models.supervisor.ConnectionDescriptionSchema.queryFields ++
    models.supervisor.GameDescriptionSchema.queryFields ++
    models.settings.SettingsSchema.queryFields ++
    models.sandbox.SandboxSchema.queryFields

  val modelQueryFields = {
    // Start model query fields
    models.analytics.AnalyticsActionSchema.queryFields ++
      models.audit.AuditRecordSchema.queryFields ++
      models.audit.AuditSchema.queryFields ++
      models.ddl.SchemaMigrationSchema.queryFields ++
      models.note.NoteSchema.queryFields ++
      models.sync.SyncProgressSchema.queryFields ++
      models.task.ScheduledTaskRunSchema.queryFields ++
      models.trace.TraceResultSchema.queryFields ++
      models.user.SystemUserSchema.queryFields
    // End model query fields
  }

  val enumQueryFields = {
    // Start enum query fields
    models.TraceTypeEnumSchema.queryFields ++
      models.analytics.AnalyticsActionTypeSchema.queryFields ++
      models.settings.SettingKeySchema.queryFields
    // End enum query fields
  }

  val queryType = ObjectType(
    name = "Query",
    description = "The main query interface.",
    fields = (baseQueryFields ++ modelQueryFields ++ enumQueryFields).sortBy(_.name)
  )

  // Mutation Types
  val baseMutationFields = models.sandbox.SandboxSchema.mutationFields

  val modelMutationFields = {
    // Start model mutation fields
    models.analytics.AnalyticsActionSchema.mutationFields ++
      models.audit.AuditRecordSchema.mutationFields ++
      models.audit.AuditSchema.mutationFields ++
      models.ddl.SchemaMigrationSchema.mutationFields ++
      models.note.NoteSchema.mutationFields ++
      models.sync.SyncProgressSchema.mutationFields ++
      models.task.ScheduledTaskRunSchema.mutationFields ++
      models.trace.TraceResultSchema.mutationFields ++
      models.user.SystemUserSchema.mutationFields
    // End model mutation fields
  }

  val mutationType = ObjectType(
    name = "Mutation",
    description = "The main mutation interface.",
    fields = (baseMutationFields ++ modelMutationFields).sortBy(_.name)
  )

  // Schema
  val schema = sangria.schema.Schema(
    query = queryType,
    mutation = Some(mutationType),
    subscription = None,
    additionalTypes = Nil
  )
}
