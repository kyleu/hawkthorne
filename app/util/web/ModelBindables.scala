package util.web

import models.user.Role
import play.api.mvc.{PathBindable, QueryStringBindable}

object ModelBindables {
  private[this] def roleExtractor(v: Either[String, String]) = v match {
    case Right(s) => Right(Role.withValue(s))
    case Left(x) => throw new IllegalStateException(x)
  }
  implicit def rolePathBindable(implicit stringBinder: PathBindable[String]): PathBindable[Role] = new PathBindable[Role] {
    override def bind(key: String, value: String) = roleExtractor(stringBinder.bind(key, value))
    override def unbind(key: String, x: Role) = x.value
  }
  implicit def roleQueryStringBindable(implicit stringBinder: QueryStringBindable[String]): QueryStringBindable[Role] = new QueryStringBindable[Role] {
    override def bind(key: String, params: Map[String, Seq[String]]) = stringBinder.bind(key, params).map(roleExtractor)
    override def unbind(key: String, x: Role): String = x.value
  }

  /* Begin model bindables */
  import models.analytics.AnalyticsActionType
  private[this] def analyticsActionTypeExtractor(v: Either[String, String]) = v match {
    case Right(s) => Right(AnalyticsActionType.withValue(s))
    case Left(x) => throw new IllegalStateException(x)
  }
  implicit def analyticsActionTypePathBindable(implicit stringBinder: PathBindable[String]): PathBindable[AnalyticsActionType] = new PathBindable[AnalyticsActionType] {
    override def bind(key: String, value: String) = analyticsActionTypeExtractor(stringBinder.bind(key, value))
    override def unbind(key: String, x: AnalyticsActionType) = x.value
  }
  implicit def analyticsActionTypeQueryStringBindable(implicit stringBinder: QueryStringBindable[String]): QueryStringBindable[AnalyticsActionType] = new QueryStringBindable[AnalyticsActionType] {
    override def bind(key: String, params: Map[String, Seq[String]]) = stringBinder.bind(key, params).map(analyticsActionTypeExtractor)
    override def unbind(key: String, x: AnalyticsActionType) = x.value
  }

  import models.GameHistoryType
  private[this] def gameHistoryTypeExtractor(v: Either[String, String]) = v match {
    case Right(s) => Right(GameHistoryType.withValue(s))
    case Left(x) => throw new IllegalStateException(x)
  }
  implicit def gameHistoryTypePathBindable(implicit stringBinder: PathBindable[String]): PathBindable[GameHistoryType] = new PathBindable[GameHistoryType] {
    override def bind(key: String, value: String) = gameHistoryTypeExtractor(stringBinder.bind(key, value))
    override def unbind(key: String, x: GameHistoryType) = x.value
  }
  implicit def gameHistoryTypeQueryStringBindable(implicit stringBinder: QueryStringBindable[String]): QueryStringBindable[GameHistoryType] = new QueryStringBindable[GameHistoryType] {
    override def bind(key: String, params: Map[String, Seq[String]]) = stringBinder.bind(key, params).map(gameHistoryTypeExtractor)
    override def unbind(key: String, x: GameHistoryType) = x.value
  }

  import models.GameSnapshotType
  private[this] def gameSnapshotTypeExtractor(v: Either[String, String]) = v match {
    case Right(s) => Right(GameSnapshotType.withValue(s))
    case Left(x) => throw new IllegalStateException(x)
  }
  implicit def gameSnapshotTypePathBindable(implicit stringBinder: PathBindable[String]): PathBindable[GameSnapshotType] = new PathBindable[GameSnapshotType] {
    override def bind(key: String, value: String) = gameSnapshotTypeExtractor(stringBinder.bind(key, value))
    override def unbind(key: String, x: GameSnapshotType) = x.value
  }
  implicit def gameSnapshotTypeQueryStringBindable(implicit stringBinder: QueryStringBindable[String]): QueryStringBindable[GameSnapshotType] = new QueryStringBindable[GameSnapshotType] {
    override def bind(key: String, params: Map[String, Seq[String]]) = stringBinder.bind(key, params).map(gameSnapshotTypeExtractor)
    override def unbind(key: String, x: GameSnapshotType) = x.value
  }

  import models.settings.SettingKey
  private[this] def settingKeyExtractor(v: Either[String, String]) = v match {
    case Right(s) => Right(SettingKey.withValue(s))
    case Left(x) => throw new IllegalStateException(x)
  }
  implicit def settingKeyPathBindable(implicit stringBinder: PathBindable[String]): PathBindable[SettingKey] = new PathBindable[SettingKey] {
    override def bind(key: String, value: String) = settingKeyExtractor(stringBinder.bind(key, value))
    override def unbind(key: String, x: SettingKey) = x.value
  }
  implicit def settingKeyQueryStringBindable(implicit stringBinder: QueryStringBindable[String]): QueryStringBindable[SettingKey] = new QueryStringBindable[SettingKey] {
    override def bind(key: String, params: Map[String, Seq[String]]) = stringBinder.bind(key, params).map(settingKeyExtractor)
    override def unbind(key: String, x: SettingKey) = x.value
  }

  import models.TraceTypeEnum
  private[this] def traceTypeEnumExtractor(v: Either[String, String]) = v match {
    case Right(s) => Right(TraceTypeEnum.withValue(s))
    case Left(x) => throw new IllegalStateException(x)
  }
  implicit def traceTypeEnumPathBindable(implicit stringBinder: PathBindable[String]): PathBindable[TraceTypeEnum] = new PathBindable[TraceTypeEnum] {
    override def bind(key: String, value: String) = traceTypeEnumExtractor(stringBinder.bind(key, value))
    override def unbind(key: String, x: TraceTypeEnum) = x.value
  }
  implicit def traceTypeEnumQueryStringBindable(implicit stringBinder: QueryStringBindable[String]): QueryStringBindable[TraceTypeEnum] = new QueryStringBindable[TraceTypeEnum] {
    override def bind(key: String, params: Map[String, Seq[String]]) = stringBinder.bind(key, params).map(traceTypeEnumExtractor)
    override def unbind(key: String, x: TraceTypeEnum) = x.value
  }

  /* End model bindables */
}
