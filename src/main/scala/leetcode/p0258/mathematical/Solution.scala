package leetcode.p0258.mathematical

object Solution {
  // All possible results are non-negative one-digit integer.
  // and, it cycles periodically.
  def addDigits(num: Int): Int = {
    if (num == 0) 0
    else if (num % 9 == 0) 9
    else num % 9
  }
}
