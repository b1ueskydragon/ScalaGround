package leetcode.p0404.immutable

sealed trait Tree

case class Empty() extends Tree

case class Leaf(value: Int) extends Tree

case class Branch(value: Int, left: Tree, right: Tree) extends Tree


object SumOfLeftLeaves {
  def apply(root: Tree): Int = sumOfLeftLeaves(root)

  def sumOfLeftLeaves(root: Tree): Int = root match {
    case branch: Branch => rec(branch, 0)
    case _ => 0
  }

  // @scala.annotation.tailrec
  def rec(branch: Branch, acc: Int): Int = branch match {
    case Branch(_, _: Empty, _: Empty) => acc // base case to return final acc
    case Branch(_, _: Empty, right: Leaf) => rec(Branch(right.value, Empty(), Empty()), acc)
    case Branch(_, _: Empty, right: Branch) => rec(right, acc)
    case Branch(_, left: Leaf, _: Empty) => rec(Branch(left.value, Empty(), Empty()), acc + left.value)
    case Branch(_, left: Leaf, _: Leaf) => rec(Branch(left.value, Empty(), Empty()), acc + left.value)
    case Branch(_, left: Leaf, right: Branch) => rec(right, acc + left.value)
    case Branch(_, left: Branch, _: Empty) => rec(left, acc)
    case Branch(_, left: Branch, _: Leaf) => rec(left, acc)
    case Branch(_, left: Branch, right: Branch) => rec(left, acc) + rec(right, acc)
  }

}
