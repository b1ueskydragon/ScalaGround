package leetcode.p0067.tailrecAndInterpolation

object Solution {
  // All patterns of a[i] + b[j] + carry and its original sum
  // 0 + 0 + 0  base 0 carry 0 (sum 0)
  // 0 + 0 + 1  base 1 carry 0 (sum 1)
  // 0 + 1 + 0  base 1 carry 0 (sum 1)
  // 0 + 1 + 1  base 0 carry 1 (sum 2)
  // 1 + 0 + 0  base 1 carry 0 (sum 1)
  // 1 + 0 + 1  base 0 carry 1 (sum 2)
  // 1 + 1 + 0  base 0 carry 1 (sum 2)
  // 1 + 1 + 1  base 1 carry 1 (sum 3)
  def addBinary(a: String, b: String): String = {
    @scala.annotation.tailrec
    def rec(a: String, b: String, carry: Int, base: String): String = (a, b) match {
      case ("", "") => if (carry == 0) base else s"$carry$base"
      case (s1, s2) =>
        val x = if (s1 == "") 0 else s1.head - '0'
        val y = if (s2 == "") 0 else s2.head - '0'
        val sum = x + y + carry
        rec(s1.tail, s2.tail, sum / 2, s"${sum % 2}$base")
    }

    rec(a.reverse, b.reverse, 0, "")
  }
}
