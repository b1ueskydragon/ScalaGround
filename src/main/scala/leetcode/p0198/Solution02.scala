package leetcode.p0198

object Solution02 {
  def rob(nums: Array[Int]): Int = {
    val N = nums.length

    // mutable Array
    @scala.annotation.tailrec
    def dp(i: Int, cache: Array[Int]): Int = {
      if (i > N - 1) cache.last
      else {
        cache(i) = Math.max(nums(i) + cache(i - 2), cache(i - 1))
        dp(i + 1, cache)
      }
    }

    if (nums.isEmpty) 0 else if (N < 2) nums.head
    else {
      val cache = Array.fill(N)(0)
      cache(0) = nums(0)
      cache(1) = Math.max(cache(0), nums(1))
      dp(2, cache)
    }
  }
}
