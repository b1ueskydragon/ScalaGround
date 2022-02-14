package leetcode.p0104

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

object Solution {
  def maxDepth(root: TreeNode): Int = {
    def rec(node: TreeNode, depth: Int): Int = {
      if (node == null) return 0
      if (node.left == null && node.right == null) return depth

      val leftMaxDepth = rec(node.left, depth + 1)
      val rightMaxDepth = rec(node.right, depth + 1)

      Math.max(leftMaxDepth, rightMaxDepth)
    }

    rec(root, 1)
  }
}
