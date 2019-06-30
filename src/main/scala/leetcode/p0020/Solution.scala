package leetcode.p0020

object Solution {
  def isValid(s: String): Boolean = {
    @scala.annotation.tailrec
    def openStack(s: List[Char], stack: List[Char], rules: Map[Char, Char]): List[Char] =
      s match {
        case Nil => stack
        case h :: tail if rules.contains(h) => openStack(tail, h :: stack, rules)
        case h :: tail if stack.nonEmpty && h == rules(stack.head) => openStack(tail, stack.tail, rules)
        case _ => '#' :: stack
      }

    openStack(s.toCharArray.toList, Nil, Map('(' -> ')', '[' -> ']', '{' -> '}')).isEmpty
  }
}