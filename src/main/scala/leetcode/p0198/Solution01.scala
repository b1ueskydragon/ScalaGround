package leetcode.p0198

object Solution01 {
  def rob(nums: Array[Int]): Int = {
    val p = nums.foldLeft((0, 0)) { (acc, x) =>
      val (exc, inc) = acc // inc has a chance to include previous num. exc must exclude previous num.
      (inc, Math.max(inc, exc + x))
    }
    Math.max(p._1, p._2)
  }
}
