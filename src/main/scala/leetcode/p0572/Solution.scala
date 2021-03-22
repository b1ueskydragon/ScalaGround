package leetcode.p0572

private class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

object Solution {
  def isSubtree(s: TreeNode, t: TreeNode): Boolean = {
    def isEquivalent(s: TreeNode, t: TreeNode): Boolean = {
      if (s == null && t == null) {
        return true
      }

      // not balanced
      if (s == null || t == null) {
        return false
      }

      s.value == t.value && isEquivalent(s.left, t.left) && isEquivalent(s.right, t.right)
    }

    if (s == null && t == null) {
      return true
    }

    // not balanced
    if (s == null || t == null) {
      return false
    }

    // traverse and compare all nodes to t, from the bottom left
    isSubtree(s.left, t) || isSubtree(s.right, t) || isEquivalent(s, t)
  }
}
