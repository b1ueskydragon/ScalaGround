package leetcode.p0784

sealed case class Letter(
  alpha: Option[(Char, Char)] = None,
  digit: Option[Int] = None
)

object Solution {

  def product[T](list: List[List[T]]): List[List[T]] = list match {
    case Nil => Nil
    case xs :: Nil => xs.map(List(_)) // to list's list
    case x :: xs => for {
      i <- x
      j <- product(xs)
    } yield List(i) ::: j
  }

  def letterCasePermutation(S: String): List[String] = {
    val pairs = S.map(s => if (s.isLetter) List(s.toLower, s.toUpper) else List(s)).toList
    product(pairs).map(_.mkString)
  }

  def main(args: Array[String]): Unit = {
    val res = letterCasePermutation("ab") // (a, A) (b, B)
    println(res) // ab, aB, Ab, AB
  }

}
