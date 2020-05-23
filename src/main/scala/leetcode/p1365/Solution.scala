package leetcode.p1365

object Solution {
  // mutable
  def smallerNumbersThanCurrent(nums: Array[Int]): Array[Int] = {
    val maxNum = 101
    val frequencies = Array.fill(maxNum)(0)
    nums.foreach(x => frequencies(x) += 1)
    (1 until maxNum).foreach(i => frequencies(i) += frequencies(i - 1))
    nums.map {
      case 0 => 0
      case x => frequencies(x - 1)
    }
  }
}