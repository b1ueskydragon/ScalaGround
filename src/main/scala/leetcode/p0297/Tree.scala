package leetcode.p0297

sealed trait Tree[+A]

case class Leaf[A](value: A) extends Tree[A]

case class Branch[A](value: A, left: Tree[A], right: Tree[A]) extends Tree[A]

object ImmutableTree {

  def main(args: Array[String]): Unit = {
    //      1,
    //   2,   3,
    // N, 5,  N, 7
    val tree = Branch(
      1,
      Branch(2, Leaf(), Leaf(5)),
      Branch(3, Leaf(), Leaf(7))
    )
  }
}
