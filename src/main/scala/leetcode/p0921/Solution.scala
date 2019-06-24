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
    val stacks = S.foldLeft((0, 0))((stack, p) => (stack, p) match {
      case (_, '(') => (stack._1, stack._2 + 1)
      case (sk, ')') if sk._2 > 0 => (stack._1, stack._2 - 1)
      case _ => (stack._1 + 1, stack._2)
    })

    stacks._1 + stacks._2
  }

}
