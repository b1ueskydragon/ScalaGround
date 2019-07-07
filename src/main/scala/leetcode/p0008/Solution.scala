package leetcode.p0008

object Solution {
  def myAtoi(str: String): Int = new scala.util.matching.Regex("""^[+|-]?\d+""")
    .findFirstIn(str.trim.split(" ").head).fold(0) { res =>
    val number = BigDecimal(res)
    if (number > Int.MaxValue) Int.MaxValue else if (number < Int.MinValue) Int.MinValue else number.toInt
  }
}
