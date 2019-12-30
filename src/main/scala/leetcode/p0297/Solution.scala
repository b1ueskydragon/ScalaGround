package leetcode.p0297

import scala.collection.immutable.Queue

// Definition for a binary tree node.
case class TreeNode(private val _value: Int) {
  // TODO immutable Node
  val value: Int = _value
  var left: TreeNode = _
  var right: TreeNode = _
}

// TODO something like below ..... no more var.
// case class TreeNode(value: Int, left: TreeNode = _, right: TreeNode = _)

object Solution {

  lazy val nullStr = "n"

  def serialize(root: TreeNode): String = {
    @scala.annotation.tailrec
    def bfs(q: Queue[TreeNode], res: String): String = {
      if (q.isEmpty) res
      else {
        val (parent, rem) = q.dequeue
        if (parent == null) bfs(rem, res + s"$nullStr,")
        else bfs(rem.enqueue(List(parent.left, parent.right)), res + s"${parent.value},")
      }
    }

    bfs(Queue(root), "")
  }

  def main(args: Array[String]): Unit = {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    // root.left.left = TreeNode(4)
    root.left.right = TreeNode(5)
    // root.right.left = TreeNode(6)
    root.right.right = TreeNode(7)

    println(serialize(root).split(",").map(x => if (x == nullStr) None else Some(x)).toList)
  }

}
