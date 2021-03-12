package leetcode.p0617

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

object Solution {
  def mergeTrees(root1: TreeNode, root2: TreeNode): TreeNode = {
    if (root1 == null && root2 == null) null else mergeTrees(root1, root2, new TreeNode())
  }

  def mergeTrees(root1: TreeNode, root2: TreeNode, merged: TreeNode): TreeNode = {
    if (root1 == null && root2 == null) {
      return merged
    }

    if (root1 == null) {
      // just copy current root2 to the result
      merged.value = root2.value
      merged.left = root2.left
      merged.right = root2.right
      return merged
    }

    if (root2 == null) {
      // just copy current root1 to the result
      merged.value = root1.value
      merged.left = root1.left
      merged.right = root1.right
      return merged
    }

    merged.value = root1.value + root2.value
    // only build a new node if either left child is exists
    merged.left = mergeTrees(root1.left, root2.left, if (root1.left == null && root2.left == null) null else new TreeNode())
    // only build a new node if either right child is exists
    merged.right = mergeTrees(root1.right, root2.right, if (root1.right == null && root2.right == null) null else new TreeNode())

    merged
  }
}
