package quiz

// 文字 a,b,c のそれぞれを1文字から3文字まで繰り返した文字列から成るリストを求めよ.
// すなわち "a", "aa", "aaa", "b", "bb", "bbb", "c", "cc", "ccc" を求める．
object Pra04_07_03 {
  def main(args: Array[String]): Unit = {
    val sample = List("a", "b", "c")
    // recursion
    println(generates(sample, 3).flatten)
    // functional
    println(for (s <- sample; n <- 1 to 3) yield s * n)
  }

  def generates(words: List[String], n: Int): List[List[String]] = {
    for {
      word <- words
    } yield generate3(word, n)
  }

  def generate3(word: String, n: Int): List[String] = {
    def _rec(stack: String, rst: List[String], n: Int): List[String] = {
      if (n == 0) rst.reverse
      else _rec(word ++ stack, stack :: rst, n - 1)
    }

    _rec(word, Nil, n)
  }
}
