package leetcode.p0455.recursion

object Solution {
  def findContentChildren(g: Array[Int], s: Array[Int]): Int = {
    @scala.annotation.tailrec
    def count(xs: List[Int], ys: List[Int], acc: Int): Int = (xs, ys) match {
      case (Nil, _) => acc
      case (_, Nil) => acc
      case (x :: tx, y :: ty) if x <= y => count(tx, ty, acc + 1)
      case _ => count(xs.tail, ys, acc)
    }

    count(g.sorted.reverse.toList, s.sorted.reverse.toList, 0)
  }
}
