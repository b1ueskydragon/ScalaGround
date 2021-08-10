package leetcode.p0415

object Solution {
  def addStrings(num1: String, num2: String): String = {
    val zipped = num1.reverse.zipAll(num2.reverse, '0', '0')

    val res = zipped.foldLeft((0, "")) { (acc, z) =>
      val (prevCarry, prevAcc) = (acc._1, acc._2)
      val (x, y) = (z._1, z._2)
      val sum = (x - '0' + y - '0') + prevCarry
      val (carry, base) = (sum / 10, sum % 10)

      (carry, s"$base$prevAcc")
    }

    if (res._1 == 0) res._2 else s"${res._1}${res._2}"
  }
}
