package leetcode.p0001

/** each input would have exactly one solution,
  * and you may not use the same element twice
  */
object Solution {
  def twoSum_(nums: Array[Int], target: Int): Array[Int] = {
    val halfs = nums.zipWithIndex.filter(_._1 * 2 == target)
    if (halfs.length == 2) halfs.map(_._2)
    else {
      val dict = nums.toSet
      nums.zipWithIndex.filter { p =>
        p._1 != target - p._1 && dict.contains(target - p._1)
      }.map(_._2)
    }
  }

  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    val dict = nums.zipWithIndex.toMap
    nums.zipWithIndex.collectFirst { // filter with map and return found at first
      case (v, i) if dict.contains(target - v) && dict(target - v) != i => (i, dict(target - v))
    }.map { case (a, b) => Array(a, b) }.getOrElse(Array(-1))
  }

}
