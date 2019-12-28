package leetcode.p0297

import scala.collection.mutable

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
    def bfs(q: mutable.Queue[TreeNode], res: String): String = {
      if (q.isEmpty) res
      else {
        val parent = q.dequeue()
        if (parent == null) {
          bfs(q, res + s"$nullStr,")
        } else {
          q.enqueue(parent.left)
          q.enqueue(parent.right)
          bfs(q, res + s"${parent.value},")
        }
      }
    }
    // TODO immutable queue
    bfs(mutable.Queue(root), "")
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
