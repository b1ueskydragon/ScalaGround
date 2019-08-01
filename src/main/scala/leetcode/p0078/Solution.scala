package leetcode.p0078

object Solution {
  def subsets(nums: Array[Int]): List[List[Int]] = {
    @scala.annotation.tailrec
    def rec(xs: List[Int], subs: List[List[Int]]): List[List[Int]] = {
      if (xs.isEmpty) subs else rec(xs.tail, subs ::: subs.map(xs.head :: _))
    }

    rec(nums.toList, List(Nil))
  }

  def subsets_(nums: Array[Int]): List[List[Int]] = {
    def rec(xs: Array[Int], head: Int): List[List[Int]] = ???

    rec(nums, 0)
  }

}