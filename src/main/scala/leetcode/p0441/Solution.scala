package leetcode.p0441

object Solution {

  /** Pure math
    *
    * n.toLong prevents Integer overflow
    *
    * @param n coins
    * @return final step that completed
    */
  def arrangeCoins(n: Int): Int = ((Math.sqrt(1 + 8 * n.toLong) - 1) * 0.5).toInt

  /** Linear search
    *
    * @param n coins
    * @return final step that completed
    */
  def arrangeCoins_(n: Int): Int = {
    (1 to n).foldLeft((0L, 0)) { (tup, x) =>
      val (sum, k) = tup
      val nextSum = sum + x // why Long? since may cause Integer overflow
      if (sum <= n) (nextSum, k + 1) else (nextSum, k)
    }._2 - 1
  }

}
