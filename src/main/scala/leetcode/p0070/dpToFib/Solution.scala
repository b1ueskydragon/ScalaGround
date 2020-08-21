package leetcode.p0070.dpToFib

object Solution {
  def climbStairs(n: Int): Int = {
    @scala.annotation.tailrec
    def fib(k: Int, prev: Int, self: Int): Int = {
      if (k == 1) self
      else fib(k - 1, self, self + prev)
    }

    fib(n, 1, 1)
  }
}
