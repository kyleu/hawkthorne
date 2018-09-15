/* Generated File */
package models.table

import models.TraceTypeEnum
import services.database.SlickQueryService.imports._
import slick.jdbc.JdbcType

object TraceTypeEnumColumnType {
  implicit val traceTypeEnumColumnType: JdbcType[TraceTypeEnum] = MappedColumnType.base[TraceTypeEnum, String](_.value, TraceTypeEnum.withValue)
}
