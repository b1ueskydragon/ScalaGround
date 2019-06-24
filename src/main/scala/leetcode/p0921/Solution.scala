package leetcode.p0921

object Solution {
  def minAddToMakeValid(S: String): Int = {
    /** Put ')' in rstack if needed.
      * Put '(' in lstack if needed. */
    def count(S: List[Char], rstack: Int, lstack: Int): Int = S match {
      case Nil => rstack + lstack
      case h :: tail if h == '(' => count(tail, rstack + 1, lstack)
      case h :: tail if h == ')' && rstack > 0 => count(tail, rstack - 1, lstack)
      case _ :: tail => count(tail, rstack, lstack + 1)
    }

    count(S.toList, 0, 0)
  }

  def minAddToMakeValid_(S: String): Int = {
    val cache = S.foldLeft((0, 0))((lr, p) => (lr, p) match {
      case ((l, r), '(') => (l, r + 1)
      case ((l, r), ')') if r > 0 => (l, r - 1)
      case ((l, r), _) => (l + 1, r)
    })

    cache._1 + cache._2
  }

}
