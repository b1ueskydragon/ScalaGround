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

  //  almost same at above
  def isValid01(s: String): Boolean = {
    val rules = Map('(' -> ')', '[' -> ']', '{' -> '}')

    @scala.annotation.tailrec
    def openStack(xs: List[Char], stack: List[Char]): List[Char] =
      xs match {
        case Nil => stack
        case h :: tail => h match {
          case '(' | '[' | '{' => openStack(tail, h :: stack)
          case ')' | ']' | '}' if stack.nonEmpty && h == rules(stack.head) => openStack(tail, stack.tail)
          case _ => h :: stack
        }
      }

    openStack(s.toList, Nil).isEmpty
  }
}