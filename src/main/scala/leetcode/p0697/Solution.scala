package leetcode.p0697

object Solution {
  def findShortestSubArray(nums: Array[Int]): Int = {
    val inter = nums.zipWithIndex.groupBy(_._1).values
    val maxDegree = inter.map(_.length).max
    inter.filter(_.length == maxDegree).map(x => x.last._2 - x.head._2 + 1).min
  }
}