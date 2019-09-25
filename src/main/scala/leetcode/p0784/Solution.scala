package leetcode.p0784

object Solution {

  def product[T](lists: List[List[T]]): List[List[T]] = lists match {
    case Nil => Nil
    case xs :: Nil => xs.map(List(_)) // to list's list
    case x :: xs => for {
      i <- x
      j <- product(xs)
    } yield i :: j
  }

  def letterCasePermutation(S: String): List[String] = {
    val pairs = S.map(s => if (s.isLetter) List(s.toLower, s.toUpper) else List(s)).toList
    product(pairs).map(_.mkString)
  }

}
