package graffiti

case class WrapperString(rawString: String) {
  lazy val str: Option[String] = try {
    Some(new String(rawString))
  } catch {
    case _: Exception => None
  }

  private[this] val value = "test" // TODO usage of private[this]
}

object WrapperString {
  def apply(rawString: Option[String]): Option[WrapperString] = rawString.map(WrapperString(_))
}