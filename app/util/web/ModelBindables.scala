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

  /* End model bindables */
}
