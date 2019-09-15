package leetcode.p0784

sealed case class Letter(
  alpha: Option[(Char, Char)] = None,
  digit: Option[Int] = None
)

object Solution {
  def letterCasePermutation(S: String): List[String] = {
    val pairs = S.map(s => if (s.isLetter) List(s.toLower, s.toUpper) else List(s))
    pairs.flatten.combinations(S.length).map(_.mkString).toList // not combination, direct product
  }

  def main(args: Array[String]): Unit = {
    val res = letterCasePermutation("ab") // (a, A) (b, B)
    println(res) // ab, aB, Ab, AB
  }
}



