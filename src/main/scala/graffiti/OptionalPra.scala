package graffiti

object OptionalPra {
  val naaame =
    Map("Me" -> "Aleeex", "You" -> "Rick")

  def show(x: Option[String]): String = x match {
    case Some(s) => s
    case None => "?"
  }

  def main(args: Array[String]): Unit = {
    println(show(naaame get "Me"))
    println(show(naaame get "She"))

    lazy val some = Some('a)
    println(some.isDefined)
    lazy val none = None
    println(none.isDefined)
  }
}
