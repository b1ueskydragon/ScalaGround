package leetcode.p0322

object Solution {
  def coinChange(coins: Array[Int], amount: Int): Int = {
    val limit = amount + 1
    val countMap = Array.fill(amount + 1)(limit) // MaxValue will cause overflow on JVM language.
    countMap(0) = 0 // base case

    coins.foreach { coin =>
      (coin to amount).foreach {
        currAmount =>
          countMap(currAmount) =
            Math.min(countMap(currAmount), countMap(currAmount - coin) + 1)
      }
    }
    if (countMap(amount) != limit) countMap(amount) else -1
  }
}
