package graffiti

object CaseMatch {
  private def flag(isTrue: Option[Boolean]): Option[String] = isTrue match {
    case Some(true) => Some("1")
    case _ => Some("0")
  }

  private def flagMap(isTrue: Option[Boolean]): Option[Int] = isTrue.map(f => if (f) 1 else 0)

  def main(args: Array[String]): Unit = {
    println(flag(Some(true)))
    println(flag(Some(false)))
  //  println(flag(None)) // case None 処理せずに None が return されるので例外.

    println(flagMap(Some(true)))
    println(flagMap(Some(false)))
    println(flagMap(None))
  }
}
