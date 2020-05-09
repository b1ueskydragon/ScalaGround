package leetcode.p0169

// The array is non-empty and the majority element always exist in the array.
object Solution {
  def majorityElement(nums: Array[Int]): Int = nums.groupBy(x => x).maxBy(_._2.length)._1
}
