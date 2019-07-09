package leetcode.p0008

object Solution {
  def myAtoi(str: String): Int = new scala.util.matching.Regex("""^[+|-]?\d+""")
    .findFirstIn(str.trim.split(" ").head).fold(0) { res =>
    val number = BigDecimal(res)
    if (number > Int.MaxValue) Int.MaxValue else if (number < Int.MinValue) Int.MinValue else number.toInt
  }

  def myAtoi_(str: String): Int = {
    val signs = Set('-', '+')

    @scala.annotation.tailrec
    def rec(xs: List[Char], res: List[Char], isPos: Boolean = true): (List[Char], Boolean) = xs match {
      case Nil => (res, isPos)
      case h :: tail if res.isEmpty && h == '-' => rec(tail, h :: res, !isPos)
      case h :: tail if res.isEmpty && h == '+' || 48 <= h && h <= 57 => rec(tail, h :: res, isPos)
      case _ => if (res.nonEmpty && signs.contains(res.head)) (Nil, isPos) else (res, isPos)
    }

    val (res, isPos) = rec(str.trim.split(" ").head.toList, Nil)
    if (res.isEmpty || signs.contains(res.head)) return 0

    try {
      val num = res.foldRight(0) { (x, acc) =>
        val n = x.asDigit
        if (n == -1) acc else if (acc == 0) n
        else Math.addExact(Math.multiplyExact(acc, 10), n) // has integer overflow
      }
      if (isPos) num else -num
    } catch {
      case _: ArithmeticException => if (isPos) Integer.MAX_VALUE else Integer.MIN_VALUE
    }
  }

  def myAtoi__(str: String): Int = {
    @scala.annotation.tailrec
    def rec(str: String, acc: String): String = {
      str.headOption match {
        case None => acc // str.isEmpty
        case Some(h) => h match {
          case ' ' if acc.isEmpty => rec(str.tail, acc)
          case x@('-' | '+') if acc.isEmpty => rec(str.tail, x.toString)
          case x if 48 <= x && x <= 57 => rec(str.tail, acc + x)
          case _ => acc
        }
      }
    }

    val res = rec(str, "")
    scala.util.Try(res.toInt).getOrElse(if (res.length < 2) 0 else if (res.head == '-') Int.MinValue else Int.MaxValue)
  }

}
