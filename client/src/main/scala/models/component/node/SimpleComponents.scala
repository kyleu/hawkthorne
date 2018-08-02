package models.component.node

import com.definitelyscala.phaserce._
import com.definitelyscala.phasercepixi.Texture
import models.component.StaticImage
import models.node.SimpleNode
import util.ColorUtils

import scala.scalajs.js

object SimpleComponents {
  def apply(game: Game, group: Group, n: SimpleNode) = n.polygon match {
    case None => Nil
    case Some(points) =>
      val g = new Graphics(game = game)
      g.beginFill(ColorUtils.green.toDouble)
      val poly = new Polygon(points.map(p => new Point(p.x.toDouble, p.y.toDouble)): _*)
      g.drawPolygon(poly.points.asInstanceOf[js.Array[Point]])
      val t = g.generateTexture().asInstanceOf[Texture]
      val name = s"polygon.${n.actualName}"
      val i = StaticImage(game = game, group = group, name = name, tex = t)
      i.setPositionInt(n.actualX, n.actualY, Some(false))
      Seq(i)
  }
}
