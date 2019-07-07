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

  def lemonadeChange_(bills: Array[Int]): Boolean = {
    val (five, ten) = bills.foldLeft((0, 0)) { (acc, x) =>
      val (f, t) = (acc._1, acc._2)
      if (x == 5) (f + 1, t) else if (x == 10) (f - 1, t + 1)
      else if (f > 0 && t > 0) (f - 1, t - 1) else if (f >= 3) (f - 3, t)
      else return false
    }
    five >= 0 && ten >= 0
  }

}
