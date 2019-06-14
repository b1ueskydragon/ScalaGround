package leetcode.p0720

object Solution {

  def longestWord(words: Array[String]): String = {
    val dict = words.toSet
    words.filter(wordPrefixes(_).forall(dict.contains)).sortWith(condition).head
  }

  private def wordPrefixes(word: String) = (1 until word.length).map(word.substring(0, _))

  private def condition(x: String, y: String) = (x.length, y.length) match {
    case (xl, yl) if xl == yl => x < y
    case (xl, yl) => xl > yl
  }

}
