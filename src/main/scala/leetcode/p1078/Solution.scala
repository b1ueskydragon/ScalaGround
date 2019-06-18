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
    @scala.annotation.tailrec
    def rec(res: List[String], words: List[String]): Array[String] =
      (words, words.tail) match {
        case (_, Nil) => res.reverse.toArray
        case (h1 :: tail1, h2 :: tail2)
          if tail2.nonEmpty && h1 == first && h2 == second => rec(tail2.head :: res, tail1)
        case _ => rec(res, words.tail)
      }

    rec(Nil, text.split(" ").toList)
  }

}
