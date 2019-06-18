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

}

