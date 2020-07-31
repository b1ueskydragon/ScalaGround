package leetcode.p0202

object Solution01 {
  def isHappy(n: Int): Boolean = {
    @scala.annotation.tailrec
    def calc(x: Int, res: Int): Int =
      if (x <= 0) res
      else {
        val digit = x % 10
        calc((x - digit) / 10, digit * digit + res)
      }

    @scala.annotation.tailrec
    def cycle(start: Int, next: Int): Int = {
      val slow = calc(start, 0) // + 1 in cycle.
      val fast = calc(calc(next, 0), 0) // + 2 in cycle (move faster than slow).
      if (fast == 1 || (slow == fast)) fast
      else cycle(slow, fast)
    }

    cycle(n, n) == 1
  }
}
