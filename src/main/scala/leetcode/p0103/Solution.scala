package leetcode.p0103


class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

object Solution {
  def zigzagLevelOrder(root: TreeNode): List[List[Int]] = {

    @scala.annotation.tailrec
    def bfs(parents: List[TreeNode], res: List[List[Int]], vector: Int): List[List[Int]] =
      if (parents.isEmpty) res
      else {
        val children = parents.foldLeft(List.empty[TreeNode]) { case (acc, parent) =>
          if (parent.left == null && parent.right == null) acc
          else if (parent.left == null) parent.right :: acc
          else if (parent.right == null) parent.left :: acc
          else {
            if (vector == 1) parent.right :: parent.left :: acc
            else parent.left :: parent.right :: acc
          }
        }
        bfs(children, res :+ parents.map(_.value), vector * -1)
      }

    if (root == null) List.empty[List[Int]]
    else bfs(List(root), List.empty[List[Int]], 1)
  }
}