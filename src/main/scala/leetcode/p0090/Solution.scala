package leetcode.p0090

object Solution {
  def subsetsWithDup(nums: Array[Int]): List[List[Int]] = {
    @scala.annotation.tailrec
    def rec(t: List[Int], ps: List[List[Int]]): List[List[Int]] =
      if (t.isEmpty) ps else rec(t.tail, ps ::: ps.map(t.head :: _))

    scala.util.Sorting.quickSort(nums)
    rec(nums.toList, List(List[Int]())).distinct
  }

  def subsetsWithDup_(nums: Array[Int]): List[List[Int]] = {
    @scala.annotation.tailrec
    def rec(t: List[Int], n: Int, res: Iterator[List[Int]]): Iterator[List[Int]] =
      if (n == 0) res else rec(t, n - 1, res ++ t.combinations(n))

    rec(nums.toList, nums.length, Iterator(List[Int]())).toList
  }

}
