package leetcode.p0020

object Solution {
  def isValid(s: String): Boolean = {
    val rules = Map('(' -> ')', '[' -> ']', '{' -> '}')

    @scala.annotation.tailrec
    def openStack(s: List[Char], stack: List[Char]): List[Char] =
      s match {
        case Nil => stack
        case h :: tail if rules.contains(h) => openStack(tail, h :: stack)
        case h :: tail if stack.nonEmpty && h == rules(stack.head) => openStack(tail, stack.tail)
        case _ => '#' :: stack
      }

    openStack(s.toList, Nil).isEmpty
  }
}