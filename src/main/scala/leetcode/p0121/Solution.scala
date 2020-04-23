package leetcode.p0121

object Solution {
  def maxProfit(prices: Array[Int]): Int = {
    val N = prices.length

    @scala.annotation.tailrec
    def loop(minPoint: Int, maxDiff: Int, i: Int): Int = {
      if (i == N) maxDiff
      else loop(Math.min(minPoint, prices(i)), Math.max(maxDiff, prices(i) - minPoint), i + 1)
    }

    if (N == 0) 0 else loop(prices(0), 0, 1)
  }
}
