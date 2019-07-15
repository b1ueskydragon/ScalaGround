package leetcode.p0090

object Solution {
  def subsetsWithDup(nums: Array[Int]): List[List[Int]] = {
    /** Generate the power set.
      *
      * T = S ∪ {x} ( T = S ++ {x} )
      * P(T) = P(S) ∪ { p ∈ P(S) | p ∪ {x} }
      *
      * @param t  group T
      * @param ps group of subsets
      * @tparam A
      * @return ps
      */
    @scala.annotation.tailrec
    def rec[A](t: List[A], ps: List[List[A]]): List[List[A]] =
      if (t.isEmpty) ps else rec(t.tail, ps ::: ps.map(t.head :: _))

    rec(nums.toList, List(List[Int]())).distinct
  }

  def main(args: Array[String]): Unit = {
    val res = subsetsWithDup(Array(1, 2, 2))
    println(res)
  }
}