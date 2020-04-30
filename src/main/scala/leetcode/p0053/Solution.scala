package leetcode.p0053

object Solution {
  def maxSubArray(nums: Array[Int]): Int = {
    val N = nums.length

    @scala.annotation.tailrec
    def loop(i: Int, soFar: Int, incl: Int): Int = {
      if (i == N) soFar
      else {
        val newIncl = Math.max(nums(i), incl + nums(i))
        val newSoFar = Math.max(soFar, newIncl)
        loop(i + 1, newSoFar, newIncl)
      }
    }

    loop(1, nums(0), nums(0))
  }
}