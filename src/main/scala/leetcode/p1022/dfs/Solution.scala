package leetcode.p1022.dfs

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

object Solution {
  def sumRootToLeaf(root: TreeNode): Int = {
    def sumRootToLeaf(root: TreeNode, acc: Int): Int = {
      if (root == null) return 0
      val currAcc = (acc << 1) + root.value
      if (root.left == null && root.right == null) return currAcc
      sumRootToLeaf(root.left, currAcc) + sumRootToLeaf(root.right, currAcc)
    }

    sumRootToLeaf(root, 0)
  }
}
