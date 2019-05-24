package graffiti

object ForallAndExists {
  def main(args: Array[String]): Unit = {
    // Option における forall exists の挙動の比較.
    inOptionCases()
  }

  private def inOptionCases(): Unit = {
    lazy val datum = (1 to 9 by 2).toList // odd num list

    println(datum.forall(_ % 2 == 0))
    println(datum.exists(_ % 2 == 0))

    lazy val optionBoolean: Option[Boolean] = Some(true)

    println(optionBoolean.forall(_.self)) // true
    println(optionBoolean.exists(_.self)) // true

    lazy val optionNone: Option[Boolean] = None

    println(optionNone.forall(_.self)) // true
    println(optionNone.exists(_.self)) // false

    println(None.forall(_.equals("anyObj"))) // true
    println(None.exists(_.equals("anyObj"))) // false
  }
}
