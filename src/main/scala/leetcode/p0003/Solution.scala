package leetcode.p0003

object Solution {
  def isPalindrome(x: Int): Boolean = {
    if (x < 0) return false

    @scala.annotation.tailrec
    def loop(num: Int, acc: Int): Boolean = {
      if (num == 0) acc == x
      else loop(num / 10, (acc * 10) + (num % 10))
    }

    loop(x, 0)
  }
}
