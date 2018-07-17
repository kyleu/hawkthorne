package services.state

import com.definitelyscala.phaserce.{BitmapData, Game, Rectangle}
import models.asset.Asset

object TestState {
  def load(phaser: Game) = new LoadingState(
    next = new TestState(phaser),
    phaser = phaser,
    assets = Seq(
      Asset.Image("font.arial", "images/font/arial.png"),
      Asset.Image("font.big", "images/font/big.png"),
      Asset.Image("font.courier", "images/font/courier.png"),
      Asset.Image("font.small", "images/font/small.png")
    )
  )
}

class TestState(phaser: Game) extends GameState("test", phaser) {
  override def create(game: Game) = {
    val fontArial = game.add.sprite(0, 100, "font.arial")
    val fontArialData = game.make.bitmapData(fontArial.width, fontArial.height, "font.arial.data")
    fontArialData.draw(fontArial.generateTexture(), 0, 0, fontArial.width, fontArial.height)
    processFont(fontArialData)

    val fontBig = game.add.sprite(0, 200, "font.big")
    val fontBigData = game.make.bitmapData(fontBig.width, fontBig.height, "font.big.data")
    fontBigData.draw(fontBig.generateTexture(), 0, 0, fontBig.width, fontBig.height)
    processFont(fontBigData)

    val fontCourier = game.add.sprite(0, 300, "font.courier")
    val fontCourierData = game.make.bitmapData(fontCourier.width, fontCourier.height, "font.courier.data")
    fontCourierData.draw(fontCourier.generateTexture(), 0, 0, fontCourier.width, fontCourier.height)
    processFont(fontCourierData)

    val fontSmall = game.add.sprite(0, 400, "font.small")
    val fontSmallData = game.add.bitmapData(fontSmall.width, fontSmall.height, "font.small.data")
    fontSmallData.draw(fontSmall.generateTexture(), 0, 0, fontSmall.width, fontSmall.height)
    processFont(fontSmallData)
  }

  def processFont(data: BitmapData) = {
    (0 until data.width.toInt).foreach { x =>
      val top = data.getPixel(x.toDouble, 4)
      util.Logging.logJs(top)
    }
  }

  override def update(game: Game) = {
  }
}
