package leetcode.p0202

object Solution {
  def isHappy(n: Int): Boolean = {
    @scala.annotation.tailrec
    def calc(x: Int, res: Int): Int =
      if (x <= 0) res
      else {
        val digit = x % 10
        val next = (x - digit) / 10
        calc(next, Math.pow(digit, 2).toInt + res)
      }

    // 1^2 + 3^2 = 10
    // 6^2 + 8^2 = 100
    // 1000 ... impossible in Int range
    val limit = 1000
    val visited = Array.fill(limit)(false)

    @scala.annotation.tailrec
    def _isHappy(n: Int): Boolean = {
      if (n == 1) true
      else if (limit > n && visited(n)) false
      else {
        if (limit > n) visited(n) = true
        _isHappy(calc(n, 0))
      }
    }

    _isHappy(n)
  }
}
