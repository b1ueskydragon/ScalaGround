package leetcode.p0404

case class TreeNode(_value: Int) {
  // TODO make to optional after all cases passed. We don't want to deal with NPE.
  var value: Int = _value
  var left: TreeNode = _
  var right: TreeNode = _
}

object Solution {
  def sumOfLeftLeaves(root: TreeNode): Int = {
    if (root == null) 0
    else dfs(List((root, false)), 0)
  }

  @scala.annotation.tailrec
  def dfs(nodeStack: List[(TreeNode, Boolean)], acc: Int): Int = nodeStack match {
    case Nil => acc
    case h :: rem =>
      val (node, isLeft) = h
      if (node == null) dfs(rem, acc)
      else {
        if (isLeft && node.left == null && node.right == null) dfs(rem, acc + node.value)
        else dfs((node.left, true) :: (node.right, false) :: rem, acc)
      }
  }
}
