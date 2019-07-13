package leetcode.p0441

object Solution {

  /** Pure math.
    * n.toLong (toDouble, 64bit numeric type anyway) prevents Integer overflow
    *
    * @param n coins
    * @return final step that completed
    */
  def arrangeCoins(n: Int): Int = ((Math.sqrt(1 + 8 * n.toLong) - 1) * 0.5).toInt

  /** Recursion with subtract */
  def arrangeCoins_(n: Int): Int = {
    /** @param n n coins
      * @param k k coins that each row has
      * @return k
      */
    @scala.annotation.tailrec def rec(n: Int, k: Int): Int = if (n > 0) rec(n - k, k + 1) else if (n == 0) k - 1 else k - 2

    rec(n, 1)
  }

  /** Linear search */
  def arrangeCoinsSlow(n: Int): Int = {
    (1 to n).foldLeft((0L, 0)) { (tup, x) =>
      val (sum, k) = tup
      val nextSum = sum + x // why Long? since may cause Integer overflow
      if (sum <= n) (nextSum, k + 1) else (nextSum, k)
    }._2 - 1
  }

}
