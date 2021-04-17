package leetcode.p0189

object Solution {
  def rotate(nums: Array[Int], k: Int): Unit = {
    val n = nums.length
    val kth = k % n

    // cyclic replacement
    // e. g. n = 6, k = 2
    //            i -> i - (n - k) OR  i -> i + k
    //          ----------------------------------
    // 0 start |       0 -> 2, 2 -> 4, 4 -> 0
    // 1 start |       1 -> 3, 3 -> 5, 5 -> 1
    @scala.annotation.tailrec
    def rotate(remaining: Int, fromIndex: Int, toIndex: Int, tmpVal: Int, startIndex: Int) {
      if (remaining == 0) return

      val nextTmpVal = nums(toIndex)

      nums(toIndex) = tmpVal

      val nextToIndex = if (toIndex + kth < n) toIndex + kth else toIndex - (n - kth)

      if (toIndex == startIndex) {
        // proceed to the next cycle
        rotate(remaining - 1, toIndex + 1, nextToIndex + 1, nums((toIndex + 1) % n), startIndex + 1)
      } else {
        // current toIndex is nextFromIndex
        rotate(remaining - 1, toIndex, nextToIndex, nextTmpVal, startIndex)
      }
    }

    rotate(n, 0, kth, nums(0), 0)
  }
}
