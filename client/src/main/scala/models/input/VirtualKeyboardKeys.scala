package models.input

object VirtualKeyboardKeys {
  val keySize = 36.0
  val padding = 6.0
  val paddedSize = keySize + padding

  case class Key(k: Char, u: Char, r: Char, d: Char, l: Char)

  val keys = Seq(
    Key(k = 'q', u = '_', r = 'w', d = 'a', l = '9'),
    Key(k = 'q', u = '_', r = 'w', d = 'a', l = '9'),
    Key(k = 'w', u = '_', r = 'e', d = 's', l = 'q'),
    Key(k = 'e', u = '_', r = 'r', d = 'd', l = 'w'),
    Key(k = 'r', u = '_', r = 't', d = 'f', l = 'e'),
    Key(k = 't', u = '_', r = 'y', d = 'g', l = 'r'),
    Key(k = 'y', u = '_', r = 'u', d = 'h', l = 't'),
    Key(k = 'u', u = '_', r = 'i', d = 'j', l = 'y'),
    Key(k = 'i', u = '_', r = 'o', d = 'k', l = 'u'),
    Key(k = 'o', u = '_', r = 'p', d = 'l', l = 'i'),
    Key(k = 'p', u = '_', r = '7', d = 'l', l = 'o'),
    Key(k = 'a', u = 'q', r = 's', d = 'z', l = '6'),
    Key(k = 's', u = 'w', r = 'd', d = 'x', l = 'a'),
    Key(k = 'd', u = 'e', r = 'f', d = 'c', l = 's'),
    Key(k = 'f', u = 'r', r = 'g', d = 'v', l = 'd'),
    Key(k = 'g', u = 't', r = 'h', d = 'b', l = 'f'),
    Key(k = 'h', u = 'y', r = 'j', d = 'n', l = 'g'),
    Key(k = 'j', u = 'u', r = 'k', d = 'm', l = 'h'),
    Key(k = 'k', u = 'i', r = 'l', d = '|', l = 'j'),
    Key(k = 'l', u = 'o', r = '4', d = '|', l = 'k'),
    Key(k = 'z', u = 'a', r = 'x', d = '_', l = '3'),
    Key(k = 'x', u = 's', r = 'c', d = '_', l = 'z'),
    Key(k = 'c', u = 'd', r = 'v', d = '_', l = 'x'),
    Key(k = 'v', u = 'f', r = 'b', d = '_', l = 'c'),
    Key(k = 'b', u = 'g', r = 'n', d = '_', l = 'v'),
    Key(k = 'n', u = 'h', r = 'm', d = '_', l = 'b'),
    Key(k = 'm', u = 'j', r = '|', d = '_', l = 'n'),
    Key(k = '_', u = 'v', r = '0', d = 't', l = '0'),
    Key(k = '|', u = 'l', r = '1', d = '_', l = 'm'),
    Key(k = '0', u = '2', r = '_', d = '8', l = '_'),
    Key(k = '1', u = '4', r = '2', d = '0', l = '|'),
    Key(k = '2', u = '5', r = '3', d = '0', l = '1'),
    Key(k = '3', u = '6', r = 'z', d = '0', l = '2'),
    Key(k = '4', u = '7', r = '5', d = '1', l = 'l'),
    Key(k = '5', u = '8', r = '6', d = '2', l = '4'),
    Key(k = '6', u = '9', r = 'a', d = '3', l = '5'),
    Key(k = '7', u = '0', r = '8', d = '4', l = 'p'),
    Key(k = '8', u = '0', r = '9', d = '5', l = '7'),
    Key(k = '9', u = '0', r = 'q', d = '6', l = '8')
  )

  val layout = Seq("qwertyuiop 789", "-asdfghjkl- 456", " zxcvbnm| 123", "- _-  0")
}
