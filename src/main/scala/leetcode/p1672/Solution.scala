package leetcode.p1672

object Solution {
  def maximumWealth(accounts: Array[Array[Int]]): Int =
    accounts.foldLeft(0)((acc, x) => Math.max(acc, x.sum))
}
