package leetcode.p0921

case class Parentheses(
  ret: Either[Char, Char]
) {
  def toChar: Char = ret.fold(_ => '(', _ => ')')
}

object Parentheses {
  def apply(p: Char): Parentheses =
    if (p == '(') Parentheses(Left(p)) else Parentheses(Right(p))

  def apply(ps: String): Seq[Parentheses] = ps.map(Parentheses(_))

  def needToBalance(ps: String): (Int, Int) =
    Parentheses(ps).foldLeft((0, 0))((acc, x) => (acc, x.ret) match {
      case ((l, r), Left(_)) => (l, r + 1)
      case ((l, r), Right(_)) if r > 0 => (l, r - 1)
      case ((l, r), _) => (l + 1, r)
    })
}

object MyApp {
  def main(args: Array[String]): Unit = {
    val ps = "()))(("
    val res = Parentheses.needToBalance(ps)
    println(res._1 + res._2)
  }
}