package leetcode.p0169

/**
  * The array is non-empty and the majority element always exist in the array.
  *
  * Let's focus on the target:
  * [2,2,1,1,1,2,2] or [2,2,1,3,1,2,2] or [2,2,4,1,5,2,2] ... and anything else,
  *
  * could be represented
  * [x,x,y,y,y,x,x]
  *
  * Align to clarify
  * [x,x,x,x,y,y,y]
  *
  * A bit of generalization
  * [x,x....,x, y,y....y]
  * (N/2 +1)     (N/2 -1)
  *
  * Since the target always exists,
  * x exists (N/2 +1) at least,
  * non-x exists (N/2 -1) at most.
  *
  * As long as only one x exists, the count (This is not the number of x) never be zero.
  */
object Solution01 {
  def majorityElement(nums: Array[Int]): Int = {
    val N = nums.length

    @scala.annotation.tailrec
    def loop(candidate: Int, count: Int, i: Int): Int = {
      if (i == N) candidate
      else {
        val x = nums(i)
        val newCandidate = if (count == 0) x else candidate // set the current candidate before increase the count.
        if (x == newCandidate) loop(newCandidate, count + 1, i + 1)
        else loop(newCandidate, count - 1, i + 1)
      }
    }

    loop(nums(0), 0, 0)
  }
}
