package leetcode.p0409

object Solution {
  def longestPalindrome(s: String): Int = {
    val pair = s.toCharArray
                .groupBy(x => x)
                .values
                .map(_.length)
                .foldLeft(0, 0) { (res, x) => // (acc, odd)
                  if (x % 2 == 0) (x + res._1, res._2) else (x - 1 + res._1, res._2 + 1)
                }
    if (pair._2 > 0) pair._1 + 1 else pair._1
  }
}
