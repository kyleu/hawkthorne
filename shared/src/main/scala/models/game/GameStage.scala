package models.game

import models.data.map.TiledMap

final case class GameStage(sourceMap: TiledMap, var objects: IndexedSeq[GameObject]) {

}
