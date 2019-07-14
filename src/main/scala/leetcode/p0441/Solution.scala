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

  /** Linear search with subtract and break off */
  def arrangeCoins__(n: Int): Int = (1 to n).foldLeft(n) { (acc, k) =>
    if (acc - k > 0) acc - k else if (acc - k == 0) return acc else return k - 1
  }

}
