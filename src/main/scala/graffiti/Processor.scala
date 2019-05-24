package graffiti

case class Result(something: Option[Something], flag: Boolean = false)

class Processor {
  def condition(conA: Option[String], conB: Int, param: AnotherThing): Result = (conA, conB) match {
    case (_, 0) => Result(None)
    case (Some(_), _) => Result(None, flag = true)
    case _ => Result(Some(param.thing))
  }
}

class Something {
  // omit
}

class AnotherThing {
  lazy val thing = new Something
  // omit
}