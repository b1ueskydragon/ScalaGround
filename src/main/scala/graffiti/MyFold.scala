package graffiti

import scala.annotation.tailrec

/** @see https://www.scala-lang.org/api/current/scala/collection/immutable/List.html
  * @see [[ LinearSeqOptimized.scala ]]
  */
object MyFold {

  /** Applies a binary operator to a start value and all elements of this sequence,
    * going left to right.
    *
    * @param seq this sequence.
    * @param z   the start value of accumulation.
    * @param f   the binary operator (function).
    * @tparam A the result type of this sequence.
    * @tparam B the result type of the binary operator.
    * @return returns z if this sequence is empty. or,
    *         returns the result of inserting f between consecutive elements of this sequence,
    *         going left to right with the start value z on the left.
    */
  @tailrec
  def foldLeft[A, B](seq: Seq[A], z: B)(f: (B, A) => B): B =
    seq match {
      case Nil => z
      case x :: xs => foldLeft(xs, f(z, x))(f)
    }

  /** Applies a binary operator to all elements of this list and a start value,
    * going right to left.
    *
    * @param seq this list.
    * @param z   the start value of accumulation.
    * @param f   the binary operator (function).
    * @tparam A the result type of this list.
    * @tparam B the result type of the binary operator.
    * @return returns z if this list is empty. or,
    *         returns the result of inserting op between consecutive elements of this list,
    *         going right to left with the start value z on the right.
    */
  def foldRight[A, B](seq: Seq[A], z: B)(f: (A, B) => B): B =
    seq match {
      case Nil => z
      case x :: xs => f(x, foldRight(xs, z)(f))
    }

}
