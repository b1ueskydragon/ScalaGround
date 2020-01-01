package leetcode.p0297

import scala.collection.immutable.Queue

// Definition for a binary tree node (Solution A)
case class MutableTreeNode(private val _value: Int) {
  val value: Int = _value
  var left: MutableTreeNode = _
  var right: MutableTreeNode = _
}

// Definition for a binary tree node (Solution B)
case class TreeNode[A](
  value: A,
  left: Option[TreeNode[A]] = None,
  right: Option[TreeNode[A]] = None
)

// Definition for a binary tree node (Solution C)
sealed trait Tree[+A]

case class Empty[A]() extends Tree[A] // kind of a `None` type.

case class Leaf[A](value: A) extends Tree[A]

case class Branch[A](value: A, left: Tree[A], right: Tree[A]) extends Tree[A]

object Solution {

  lazy val nullStr = "n"

  // Solution A
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

  // Solution B
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

  // Solution C
  def serialize[A](root: Tree[A]): String = {
    @scala.annotation.tailrec
    def bfs(q: Queue[Tree[A]], res: String): String = {
      if (q.isEmpty) res
      else {
        val (parent, rem) = q.dequeue
        parent match {
          case Branch(v, left, right) => bfs(rem.enqueue(List(left, right)), res + s"$v,")
          case Leaf(v) => bfs(rem, res + s"$v,")
          case Empty() => bfs(rem, res + s"$nullStr,")
        }
      }
    }

    bfs(Queue(root), "")
  }

  def deserialize(data: String): Tree[Int] = {
    val nums = data.split(",").map(x => if (x == "n") None else Some(x.toInt))

    def bfs(queue: Queue[Tree[Int]], res: Tree[Int], xs: Array[Option[Int]]): Tree[Int] = {
      ???
    }

    bfs(Queue(), Empty(), nums)
  }

  def main(args: Array[String]): Unit = {
    val mutableTreeNode = MutableTreeNode(1)
    mutableTreeNode.left = MutableTreeNode(2)
    mutableTreeNode.right = MutableTreeNode(3)
    mutableTreeNode.left.right = MutableTreeNode(5)
    mutableTreeNode.right.right = MutableTreeNode(7)

    // A : List(1, 2, 3, n, 5, n, 7, n, n, n, n)
    println(serialize(mutableTreeNode).split(",").toList)

    val treeNode = TreeNode(1,
      Some(TreeNode(2, None, Some(TreeNode(5)))),
      Some(TreeNode(3, None, Some(TreeNode(7))))
    )

    // B : List(1, 2, 3, n, 5, n, 7, n, n, n, n)
    println(serialize(treeNode).split(",").toList)

    val tree = Branch(1,
      Branch(2, Empty(), Leaf(5)),
      Branch(3, Empty(), Leaf(7))
    )

    // C : List(1, 2, 3, n, 5, n, 7)
    println(serialize(tree).split(",").toList)

    println(deserialize("1,2,3,n,5,n,7"))
  }

}
