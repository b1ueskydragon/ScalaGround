package leetcode.p0297

import scala.collection.immutable.Queue

// Definition for a binary tree node.
case class MutableTreeNode(private val _value: Int) {
  val value: Int = _value
  var left: MutableTreeNode = _
  var right: MutableTreeNode = _
}

// TODO
// sealed trait Tree[+A]
// case class Leaf[A](value: A) extends Tree[A]
// case class Branch[A](value: A, left: Tree[A], right: Tree[A]) extends Tree[A]

case class TreeNode[A](
  value: A,
  left: Option[TreeNode[A]] = None,
  right: Option[TreeNode[A]] = None
)

object Solution {

  lazy val nullStr = "n"

  def serialize(root: MutableTreeNode): String = {
    @scala.annotation.tailrec
    def bfs(q: Queue[MutableTreeNode], res: String): String = {
      if (q.isEmpty) res
      else {
        val (parent, rem) = q.dequeue
        if (parent == null) bfs(rem, res + s"$nullStr,")
        else bfs(rem.enqueue(List(parent.left, parent.right)), res + s"${parent.value},")
      }
    }

    bfs(Queue(root), "")
  }

  def serialize(root: TreeNode[Int]): String = {
    @scala.annotation.tailrec
    def bfs(q: Queue[Option[TreeNode[Int]]], res: String): String = {
      if (q.isEmpty) res
      else {
        val (parent, rem) = q.dequeue
        parent match {
          case Some(x) => bfs(rem.enqueue(List(x.left, x.right)), res + s"${x.value},")
          case _ => bfs(rem, res + s"$nullStr,")
        }
      }
    }

    bfs(Queue(Option(root)), "")
  }

  def main(args: Array[String]): Unit = {
    val mutableRoot = MutableTreeNode(1)
    mutableRoot.left = MutableTreeNode(2)
    mutableRoot.right = MutableTreeNode(3)
    // root.left.left = TreeNode(4)
    mutableRoot.left.right = MutableTreeNode(5)
    // root.right.left = TreeNode(6)
    mutableRoot.right.right = MutableTreeNode(7)

    // List(1, 2, 3, n, 5, n, 7, n, n, n, n)
    println(serialize(mutableRoot).split(",").toList)

    val root = TreeNode(1,
      Some(TreeNode(2, None, Some(TreeNode(5)))),
      Some(TreeNode(3, None, Some(TreeNode(7)))))

    println(serialize(root).split(",").toList)
  }

}
