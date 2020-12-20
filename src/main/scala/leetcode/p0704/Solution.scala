package leetcode.p0704

object Solution {
  // sorted nums
  def search(nums: Array[Int], target: Int): Int = {
    search(nums, target, 0, nums.length - 1)
  }

  @scala.annotation.tailrec
  def search(nums: Array[Int],
             target: Int,
             l: Int,
             r: Int): Int = {
    if (l > r) return -1

    val m: Int = l + (r - l) / 2
    if (nums(m) == target) m
    else if (nums(m) < target) search(nums, target, m + 1, r)
    else search(nums, target, l, m - 1)
  }
}
