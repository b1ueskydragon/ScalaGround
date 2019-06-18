package leetcode.p1078

object Solution {
  def findOcurrences(text: String, first: String, second: String): Array[String] = {
    val words = text.split(" ")
    val n = words.length
    (for {
      i <- 0 until n
      j <- i + 1 until i + 2
      if j + 1 < n && words(i) == first && words(j) == second
    } yield words(j + 1)).toArray
  }

  def findOcurrences_(text: String, first: String, second: String): Array[String] = {
    val words = text.split(" ")
    val n = words.length
    Range(0, n).flatMap { i =>
      Range(i + 1, i + 2).collect {
        case j if j + 1 < n && words(i) == first && words(j) == second => words(j + 1)
      }
    }.toArray
  }

}
