package wiki

object MarkdownUtils {
  private[this] val baseUrl = "https://github.com/KyleU/hawkthorne"

  def img(path: String, alt: String) = s"""[[$baseUrl/blob/master/public/game/images/$path|alt=$alt]]"""
}
