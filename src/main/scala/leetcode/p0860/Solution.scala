package leetcode.p0860

object Solution {
  def lemonadeChange(bills: Array[Int]): Boolean = {
    @scala.annotation.tailrec
    def _count(bills: List[Int], fives: Int, tens: Int): Boolean = bills match {
      case Nil => fives >= 0 && tens >= 0
      case h :: tail if h == 5 => _count(tail, fives + 1, tens)
      case h :: tail if h == 10 => _count(tail, fives - 1, tens + 1)
      case _ if fives > 0 && tens > 0 => _count(bills.tail, fives - 1, tens - 1) // 5, 10
      case _ if fives >= 3 => _count(bills.tail, fives - 3, tens) // 5, 5, 5
      case _ => false
    }

    _count(bills.toList, 0, 0)
  }
}