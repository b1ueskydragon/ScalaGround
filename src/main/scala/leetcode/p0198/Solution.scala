package leetcode.p0198

object Solution {
  def rob(nums: Array[Int]): Int = loop(nums, 0, 0, 0, 0)

  @scala.annotation.tailrec
  def loop(nums: Array[Int], currInc: Int, currExc: Int, prevInc: Int, prevExc: Int): Int = {
    if (nums.isEmpty) Math.max(currExc, currInc)
    else {
      /*
       * a6's currInc := a6 + prevExc
       *                      prevExc := a1 + a3        or a1 + a4 or a2 + a4
       *                              := a5's prevExc           a5's prevInc
       */
      loop(nums.tail, nums.head + prevExc, prevInc, currInc, Math.max(prevExc, prevInc))
    }
  }
}
