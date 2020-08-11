package leetcode.p0258.recursion

object Solution {
  def addDigits(num: Int): Int = {
    @scala.annotation.tailrec
    def loop(num: Int, acc: Int): Int = {
      if (num == 0) acc
      else loop((num - num % 10) / 10, acc + num % 10)
    }

    @scala.annotation.tailrec
    def res(num: Int, acc: Int): Int = {
      val cache = loop(num, 0)
      if (cache >= 10) res(cache, 0)
      else cache
    }

    res(num, 0)
  }
}
