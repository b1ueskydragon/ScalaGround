package graffiti

/** Traversable means `たどれる (走査可能)`
  *
  * N (葉の数)
  * N - 1 (Branch クラスの内部ノードの数)
  *
  * N + N - 1 (木の要素の全探索に必要な step 数)
  */
sealed abstract class Tree extends Traversable[Int] {
  // override
  def foreach[U](f: Int => U): Unit = this match {
    case Node(elem) => f(elem)
    case Branch(l, r) =>
      l foreach f
      r foreach f
  }
}

/** `++` で l.iterator ++ r.iterator を作るたびに,
  * l.iterator または r.iterator を得ることとなる.
  *
  * そのため, 1つの葉にたどりつくために log(N) 回の関節処理(step)が発生する.
  *
  * N log(N)
  */
//sealed abstract class Tree extends Iterable[Int] {
//  def iterator: Iterator[Int] = this match {
//    case Node(elem) => Iterator.single(elem)
//    case Branch(l, r) => l.iterator ++ r.iterator
//  }
//}

case class Branch(left: Tree, right: Tree) extends Tree

case class Node(elem: Int) extends Tree
