package models.map

import models.data.map.TiledMap
import org.scalatest._
import services.map.ServerMapCache

class ServerMapCacheTest extends FlatSpec with Matchers {
  "ServerMapCache" should "load all maps correctly" in {
    TiledMap.values.foreach(m => ServerMapCache(m.value))
  }
  it should "have no unused fields" in {
    ServerMapCache.unusedFields.map(_._2.size).sum shouldBe 0
  }
  it should "have no unused properties" in {
    ServerMapCache.unusedProperties.map(_._2.size).sum shouldBe 0
  }
}
