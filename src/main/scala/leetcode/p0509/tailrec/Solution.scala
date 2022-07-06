package leetcode.p0509.tailrec

object Solution {
  // f(n) = f(n-1) + f(n-2)
  //      = f(n-2) + f(n-3) + f(n-2)
  def fib(n: Int): Int = {
    @scala.annotation.tailrec
    def rec(k: Int, prev: Int, acc: Int): Int = {
      if (k == 0) 0
      else if (k == 1) acc
      else rec(k - 1, acc, acc + prev)
    }

    rec(n, 0, 1)
  }
}
