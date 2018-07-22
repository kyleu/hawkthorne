package pipeline.file

import pipeline.{ExportHelper, PipelineConfig}

object ListingFile {
  def listingFile(cfg: PipelineConfig, key: String, instances: Seq[String]) = {
    val pkg = Seq("models", "template", key)
    val n = ExportHelper.toClassName(key)
    val file = ScalaFile(pkg = pkg, key = n + "Listing", root = Some("shared/src/main/scala"))

    file.addImport(s"models.data.$key", "_")

    file.add(s"object ${n}Listing {", 1)
    file.add("val all = Seq(", 1)
    file.add(instances.mkString(", "))
    file.add(")", -1)
    file.add()
    file.add(s"""def withKey(key: String) = all.find(_.key == key).getOrElse(throw new IllegalStateException(s"No $key [$$key]."))""")
    file.add("}", -1)

    cfg.writeScalaResult(s"$key/${n}Listing", file.path -> file.rendered).toSeq
  }
}
