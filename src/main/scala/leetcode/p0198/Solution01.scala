package leetcode.p0198

object Solution01 {
  def rob(nums: Array[Int]): Int = {
    // TODO sentinel
    if (nums.isEmpty) return 0
    if (nums.length == 1) return nums(0)
    if (nums.length < 3) return Math.max(nums(0), nums(1))
    val xs = nums.tail.tail
    val p = xs.foldLeft((nums(0), Math.max(nums(0), nums(1)))) { (acc, x) =>
      val (exc, inc) = acc // inc has a chance to include previous num. exc must exclude previous num.
      (inc, Math.max(inc, exc + x))
    }
    Math.max(p._1, p._2)
  }
}
