package leetcode.p0344

object Solution {
  def reverseString(s: Array[Char]): Unit = {
    @scala.annotation.tailrec
    def rec(s: Array[Char], l: Int, r: Int, tmp: Char): Unit = {
      if (l >= r) return
      s(l) = s(r)
      s(r) = tmp
      rec(s, l + 1, r - 1, s(l + 1))
    }

    rec(s, 0, s.length - 1, s(0))
  }
}
