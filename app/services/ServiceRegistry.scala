package services

import services.analytics.AnalyticsService

@javax.inject.Singleton
class ServiceRegistry @javax.inject.Inject() (
    /* Start model service files */
    val analyticsServices: services.analytics.AnalyticsServiceRegistry,
    val auditServices: services.audit.AuditServiceRegistry,
    val ddlServices: services.ddl.DdlServiceRegistry,
    val historyServices: services.history.HistoryServiceRegistry,
    val noteServices: services.note.NoteServiceRegistry,
    val syncServices: services.sync.SyncServiceRegistry,
    val taskServices: services.task.TaskServiceRegistry,
    val traceServices: services.trace.TraceServiceRegistry,
    val userServices: services.user.UserServiceRegistry,
    /* End model service files */

    val analyticsService: AnalyticsService
)
