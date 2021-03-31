package leetcode.p0062.forComprehension

object Solution {
  def uniquePaths(m: Int, n: Int): Int = {
    val ary = Array.fill(m, n)(0)
    for {
      i <- 0 until m
      j <- 0 until n
    } yield ary(i)(j) = if (i == 0 || j == 0) 1 else ary(i - 1)(j) + ary(i)(j - 1)

    ary(m - 1)(n - 1)
  }
}
