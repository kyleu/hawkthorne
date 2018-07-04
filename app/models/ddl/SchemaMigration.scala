/* Generated File */
package models.ddl

import java.time.LocalDateTime
import models.result.data.{DataField, DataFieldModel, DataSummary}
import util.JsonSerializers._

object SchemaMigration {
  implicit val jsonEncoder: Encoder[SchemaMigration] = deriveEncoder
  implicit val jsonDecoder: Decoder[SchemaMigration] = deriveDecoder
}

final case class SchemaMigration(
    installedRank: Long = 0L,
    version: Option[String] = None,
    description: String = "",
    typ: String = "",
    script: String = "",
    checksum: Option[Long] = None,
    installedBy: String = "",
    installedOn: LocalDateTime = util.DateUtils.now,
    executionTime: Long = 0L,
    success: Boolean = false
) extends DataFieldModel {
  override def toDataFields = Seq(
    DataField("installedRank", Some(installedRank.toString)),
    DataField("version", version),
    DataField("description", Some(description)),
    DataField("typ", Some(typ)),
    DataField("script", Some(script)),
    DataField("checksum", checksum.map(_.toString)),
    DataField("installedBy", Some(installedBy)),
    DataField("installedOn", Some(installedOn.toString)),
    DataField("executionTime", Some(executionTime.toString)),
    DataField("success", Some(success.toString))
  )

  def toSummary = DataSummary(model = "schemaMigration", pk = Seq(installedRank.toString), title = s"$version / $description / $typ / $success ($installedRank)")
}
