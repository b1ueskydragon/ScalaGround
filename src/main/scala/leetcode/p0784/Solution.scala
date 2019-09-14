package leetcode.p0784

sealed case class Letter(
  alpha: Option[(Char, Char)] = None,
  digit: Option[Int] = None
)

object Solution {
  def letterCasePermutation(S: String) = { // List[String]
    val pairs = S.map(s => if (s.isLetter) (s.toLower, s.toUpper) else s)
    pairs
  }

  def main(args: Array[String]): Unit = {
    val res = letterCasePermutation("ab") // (a, A) (b, B)
    println(res) // ab, aB, Ab, AB
  }
}
