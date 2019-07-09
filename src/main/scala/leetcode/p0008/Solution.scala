package leetcode.p0008

object Solution {
  def myAtoi(str: String): Int = new scala.util.matching.Regex("""^[+|-]?\d+""")
    .findFirstIn(str.trim.split(" ").head).fold(0) { res =>
    val number = BigDecimal(res)
    if (number > Int.MaxValue) Int.MaxValue else if (number < Int.MinValue) Int.MinValue else number.toInt
  }

  def myAtoi_(str: String): Int = {
    @scala.annotation.tailrec
    def rec(charArray: List[Char], res: List[Char]): List[Char] = charArray match {
      case Nil => res
      case h :: tail if (res.isEmpty && Set('-', '+').contains(h)) || (48 <= h && h <= 57) => rec(tail, h :: res)
      case _ => if (res.nonEmpty && Set('-', '+').contains(res.head)) Nil else res
    }

    val res = rec(str.trim.split(" ").head.toList, Nil)
    if (res.isEmpty || Set('-', '+').contains(res.head)) return 0

    val isNeg = res.last == '-'
    val num = res.foldRight(0) { (x, acc) =>
      val n = x.asDigit
      if (n == -1) acc else if (acc == 0) n else acc * 10 + n
    }
    if (isNeg) -num else num
  }

}
