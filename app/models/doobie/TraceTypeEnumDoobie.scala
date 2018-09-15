/* Generated File */
package models.doobie

import models.TraceTypeEnum
import services.database.DoobieQueryService.Imports._

object TraceTypeEnumDoobie {
  implicit val traceTypeEnumMeta: Meta[TraceTypeEnum] = pgEnumStringOpt("TraceTypeEnum", TraceTypeEnum.withValueOpt, _.value)
}
