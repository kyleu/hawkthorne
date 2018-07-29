package models.input

case class InputUpdate(
    idx: Int,
    x: Double,
    y: Double,
    commands: Seq[String]
)
