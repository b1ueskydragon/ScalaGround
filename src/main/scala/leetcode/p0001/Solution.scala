package leetcode.p0001

/** each input would have exactly one solution,
  * and you may not use the same element twice
  */
object Solution {
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    val halfs = nums.zipWithIndex.filter(_._1 * 2 == target)
    if (halfs.length == 2) halfs.map(_._2)
    else {
      val dict = nums.toSet
      nums.zipWithIndex.filter { p =>
        p._1 != target - p._1 && dict.contains(target - p._1)
      }.map(_._2)
    }
  }
}
