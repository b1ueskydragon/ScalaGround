package graffiti

object VariableBindingPattern {
  def main(args: Array[String]): Unit = {
    lazy val given = Option('a)
    lazy val res00 = optionToList(given)
    println(res00)
    lazy val res01 = optionToListAny(given)
    println(res01)
  }

  // same as .toList
  def optionToList[A](ls: Option[A]): List[A] = ls match {
    case Some(el) => List(el)
    case _ => Nil
  }

  def optionToListAny[A](ls: Option[A]): List[Any] = ls match {
    case bindedVal@Some(el) => List(bindedVal, el) // List(Some('a), 'a)
    case _ => Nil
  }
}
