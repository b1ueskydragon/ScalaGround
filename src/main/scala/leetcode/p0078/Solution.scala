package leetcode.p0078

object Solution {
  def subsets(nums: Array[Int]): List[List[Int]] = {
    @scala.annotation.tailrec
    def rec(xs: List[Int], subs: List[List[Int]]): List[List[Int]] = {
      if (xs.isEmpty) subs else rec(xs.tail, subs ::: subs.map(xs.head :: _))
    }

    rec(nums.toList, List(Nil))
  }

  def subsets_[T](nums: Array[T]): List[List[T]] = {
    def rec(as: Array[T], pos: Int): List[List[T]] = {
      if (pos >= as.length) List(Nil)
      else {
        val rem = rec(as, pos + 1)
        val newRem = rem.map(list => as(pos) :: list)
        newRem ::: rem
      }
    }

    rec(nums, 0)
  }

}
