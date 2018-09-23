/* Generated File */
package services.history

@javax.inject.Singleton
class HistoryServiceRegistry @javax.inject.Inject() (
    val gameHistoryService: services.history.GameHistoryService,
    val gamePlayerService: services.history.GamePlayerService,
    val gameSnapshotService: services.history.GameSnapshotService
)
