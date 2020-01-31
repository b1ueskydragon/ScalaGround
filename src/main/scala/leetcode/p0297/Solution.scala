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

//  def deserialize(data: String): Tree[Int] = {
//    val nums = data.split(",").map(x => if (x == "n") None else Some(x.toInt))
//
//    @scala.annotation.tailrec
//    def bfs(queue: Queue[Tree[Int]], res: Tree[Int], pos: Int): Tree[Int] = {
//      if (pos < nums.length - 2) {
//        val (parent, rem) = queue.dequeue
//        val lNode = if (nums(pos + 1).isEmpty) Empty() else Leaf(nums(pos + 1).get)
//        val rNode = if (nums(pos + 2).isEmpty) Empty() else Leaf(nums(pos + 2).get)
//
//        if (parent != Empty()) {
//          val newNode = parent match {
//            case Branch(v, l: Leaf[Int], r) => Branch(v, Branch(l.value, lNode, rNode), r)
//            case Branch(v, l, r: Leaf[Int]) => Branch(v, l, Branch(r.value, lNode, rNode))
//            case Leaf(v) => Branch(v, lNode, rNode)
//          }
//          val parentLeft = newNode.left
//          val parentRight = newNode.right
//
//          res match {
//            case Branch(v, l: Leaf[Int], r) =>
//              bfs(rem.enqueue(List(parentLeft, parentRight)),
//                Branch(v, Branch(l.value, parentLeft, parentRight), r),
//                pos + 2)
//            case Branch(v, l, r: Leaf[Int]) =>
//              bfs(rem.enqueue(List(parentLeft, parentRight)),
//                Branch(v, l, Branch(r.value, parentLeft, parentRight)),
//                pos + 2)
//            case Leaf(v) =>
//              bfs(rem.enqueue(List(parentLeft, parentRight)),
//                Branch(v, parentLeft, parentRight),
//                pos + 2)
//          }
//
//        } else {
//          bfs(rem, res, pos + 2)
//        }
//
//      } else res
//    }
//
//    if (nums.head.isEmpty) Empty()
//    else {
//      val base = Leaf(nums.head.get)
//      bfs(Queue(base), base, 0)
//    }
//  }

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

    println(serialize(Branch(1,
      Branch(2, Leaf(4), Leaf(5)),
      Leaf(3)
    )))

    // println(deserialize("1,2,3,4,5,6,7"))

    // println(deserialize("1,2,3,4,5,6,7,8,9"))
    // println(deserialize("1,2,3,n,n,4,5,6,7,n,8"))
    // println(deserialize("1,2,3,4,5,6,7,8,9,10,11,12,13,14,15"))
  }

}
