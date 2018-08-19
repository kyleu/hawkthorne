package models.collision

import enumeratum.values.{CharCirceEnum, CharEnum, CharEnumEntry}

sealed abstract class CollisionBlockType(override val value: Char) extends CharEnumEntry

object CollisionBlockType extends CharEnum[CollisionBlockType] with CharCirceEnum[CollisionBlockType] {
  case object Block extends CollisionBlockType('b')
  case object OneWay extends CollisionBlockType('o')
  case object NoDrop extends CollisionBlockType('n')
  case object IceBlock extends CollisionBlockType('i')

  override val values = findValues

  def fromInt(i: Int) = i match {
    case _ if i >= 0 && i < 26 => Block
    case _ if i >= 26 && i < 52 => OneWay
    case _ if i >= 52 && i < 78 => NoDrop
    case _ if i >= 78 && i < 104 => IceBlock
    case _ if i >= 104 && i < 130 => Block
    case _ => throw new IllegalStateException(s"Unknown collision block index [$i].")
  }

  def slopeEdges(i: Int) = i % 26 match {
    case 1 => Some(23 -> 0)
    case 2 => Some(0 -> 23)
    case 3 => Some(23 -> 12)
    case 4 => Some(11 -> 0)
    case 5 => Some(0 -> 11)
    case 6 => Some(12 -> 23)
    case 7 => Some(23 -> 16)
    case 8 => Some(15 -> 8)
    case 9 => Some(7 -> 0)
    case 10 => Some(0 -> 7)
    case 11 => Some(8 -> 15)
    case 12 => Some(16 -> 23)
    case 13 => Some(23 -> 18)
    case 14 => Some(17 -> 12)
    case 15 => Some(11 -> 7)
    case 16 => Some(6 -> 0)
    case 17 => Some(0 -> 6)
    case 18 => Some(7 -> 11)
    case 19 => Some(12 -> 17)
    case 20 => Some(18 -> 23)
    case _ => None
  }

  // format {x, y, x + width, y + height}
  private[this] val specials = IndexedSeq(
    (0, 12, 24, 24),
    (0, 12, 12, 24),
    (12, 12, 24, 24),
    (0, 0, 12, 24),
    (12, 0, 24, 24)
  )

  def special(i: Int) = i % 26 match {
    case x if 20 < x && x < 26 => Some(specials(x - 21))
    case _ => None
  }
}
