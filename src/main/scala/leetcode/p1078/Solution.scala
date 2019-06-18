package leetcode.p1078

object Solution {
  def findOcurrences(text: String, first: String, second: String): Array[String] = {
    val words = text.split(" ")
    val n = words.length
    (for {
      i <- 0 until n
      if i + 2 < n && words(i) == first && words(i + 1) == second
    } yield words(i + 2)).toArray
  }

  def findOcurrences_(text: String, first: String, second: String): Array[String] = {
    val words = text.split(" ")
    val n = words.length
    Range(0, n).collect {
      case i if i + 2 < n && words(i) == first && words(i + 1) == second => words(i + 2)
    }.toArray
  }

  def findOcurrences__(text: String, first: String, second: String): Array[String] = {
    val words = text.split(" ").toList
    val wordsNext = words.tail

    def rec(res: List[String], words: List[String], wordsNext: List[String]): List[String] =
      (words, wordsNext) match {
        case (_, Nil) => res
        case (h1 :: tail1, h2 +: tail2) if h1 == first && h2 == second =>
          if (tail2.nonEmpty) rec(tail2.head :: res, tail1, tail2)
          else rec(res, tail1, tail2)
        case _ => rec(res, words.tail, wordsNext.tail)
      }

    rec(Nil, words, wordsNext).reverse.toArray
  }

}
