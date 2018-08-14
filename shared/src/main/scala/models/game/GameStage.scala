package models.game

import models.collision.{CollisionGrid, CollisionPoly}
import models.data.map.TiledMap

final case class GameStage(sourceMap: TiledMap, var objects: IndexedSeq[GameObject], collision: Either[CollisionPoly, CollisionGrid])
