package models.map

import models.data.map.TiledMap
import org.scalatest._
import services.map.ServerMapCache

class ServerMapCacheTest extends FlatSpec with Matchers {
  "ServerMapCache" should "load all maps correctly" in {
    TiledMap.values.foreach(ServerMapCache.apply)
  }
  it should "have no unused fields" in {
    ServerMapCache.unused._2.map(_._2.size).sum shouldBe 0
  }
  it should "have no unused properties" in {
    ServerMapCache.unused._3.map(_._2.size).sum shouldBe 0
  }
}
