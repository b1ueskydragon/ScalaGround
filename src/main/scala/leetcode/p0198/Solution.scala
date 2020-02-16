package leetcode.p0198

object Solution {
  def rob(nums: Array[Int]): Int = loop(nums, 0, 0, 0)

  // a6's currInc := a6 + prevExc
  //                      prevExc := a1 + a3        or a1 + a4 or a2 + a4
  //                              := a5's prevExc           a5's prevInc (currInc)
  @scala.annotation.tailrec
  private def loop(nums: Array[Int], currInc: Int, currExc: Int, prevExc: Int): Int = {
    if (nums.isEmpty) Math.max(currExc, currInc)
    else loop(nums.tail, nums.head + prevExc, currInc, Math.max(prevExc, currInc))
  }
}
