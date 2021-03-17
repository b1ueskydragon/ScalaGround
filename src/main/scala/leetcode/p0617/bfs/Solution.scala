package leetcode.p0617.bfs

import scala.collection.immutable.Queue

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

object Solution {
  def mergeTrees(root1: TreeNode, root2: TreeNode): TreeNode = (root1, root2) match {
    case (null, r2) => r2
    case (r1, null) => r1
    case (r1, r2) =>
      @scala.annotation.tailrec
      def bfs(queue: Queue[(TreeNode, TreeNode)]): TreeNode = {
        queue match {
          case q if q.isEmpty => r1
          case q =>
            val (nodes, rems) = q.dequeue
            nodes match {
              case (null, null) => bfs(rems)
              case (n1, null) => bfs(rems.enqueue((n1.left, null)).enqueue((n1.right, null))) // to keep the structure
              case (null, n2) => bfs(rems.enqueue((null, n2.left)).enqueue(null, n2.right)) // to keep the structure
              case (n1, n2) =>
                n1.value += n2.value

                // move to root1
                if (n1.right == null && n2.right != null) {
                  n1.right = n2.right
                  n2.right = null
                }
                if (n1.left == null && n2.left != null) {
                  n1.left = n2.left
                  n2.left = null
                }

                bfs(rems.enqueue((n1.left, n2.left)).enqueue((n1.right, n2.right)))
            }
        }
      }

      bfs(Queue((r1, r2)))
  }

}
