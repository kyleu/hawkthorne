package util

import com.definitelyscala.phaserce.Color

object ColorUtils {
  val blue = 0x0b4f6c
  val green = 0x005117
  val orange = 0xb85325
  val pink = 0xb76e79
  val purple = 0x8e2b4b
  val red = 0x800e13
  val yellow = 0xf5b512
  val white = 0xffffff

  val textColors = Map(
    "blue" -> blue.toDouble,
    "green" -> green.toDouble,
    "orange" -> orange.toDouble,
    "pink" -> pink.toDouble,
    "purple" -> purple.toDouble,
    "red" -> red.toDouble,
    "yellow" -> yellow.toDouble,
    "white" -> white.toDouble,
    "teal" -> Color.getColor(74, 205, 180),
    "blue_light" -> Color.getColor(100, 143, 154),
    "olive" -> Color.getColor(190, 198, 149),
    "green_light" -> Color.getColor(90, 145, 111),
    "green_dark" -> Color.getColor(0, 83, 67),
    "grey" -> Color.getColor(139, 139, 139),
    "peach" -> Color.getColor(238, 212, 191),
    "yellow" -> Color.getColor(235, 207, 82),
    "orange" -> Color.getColor(204, 132, 50),
    "red_light" -> Color.getColor(166, 94, 96),
    "red" -> Color.getColor(157, 26, 18),
    "red_dark" -> Color.getColor(95, 31, 41),
    "purple" -> Color.getColor(96, 21, 99)
  )
}
