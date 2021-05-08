package leetcode.p0561

/**
  * Given an integer array nums of 2n integers, group these integers into n pairs (a1, b1), (a2, b2), ..., (an, bn)
  * such that the sum of min(ai, bi) for all i is maximized. Return the maximized sum.
  */
object Solution {
  def arrayPairSum(nums: Array[Int]): Int = {
    nums.sorted.zipWithIndex.foldLeft(0)((acc, x) => if (x._2 % 2 == 0) acc + x._1 else acc)
  }
}
