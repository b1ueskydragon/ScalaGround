package leetcode.p0090

object Solution {
  def subsetsWithDup(nums: Array[Int]): List[List[Int]] = {
    @scala.annotation.tailrec
    def rec(t: List[Int], ps: List[List[Int]]): List[List[Int]] =
      if (t.isEmpty) ps else rec(t.tail, ps ::: ps.map(t.head :: _))

    scala.util.Sorting.quickSort(nums)
    rec(nums.toList, List(List[Int]())).distinct
  }
}
