package leetcode.p0617

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

object Solution {
  def mergeTrees(root1: TreeNode, root2: TreeNode): TreeNode = {
    if (root1 == null && root2 == null) {
      return null
    }

    if (root1 == null) {
      // just return current root2 as the result
      return root2
    }

    if (root2 == null) {
      // just return current root1 as the result
      return root1
    }

    root1.value += root2.value
    root1.left = mergeTrees(root1.left, root2.left)
    root1.right = mergeTrees(root1.right, root2.right)

    root1
  }
}
