package quiz

// reduceLeftを用いて，要素リストを連結したリストを求める.
object Pra08_08_03 {
  def main(args: Array[String]): Unit = {
    val lists = List(List(3, 1, 4), List(2, 7, 1, 8, 2, 8), List(0, 5, 7, 7))

    val res = lists.reduceLeft(_ ++ _)

    val res01 = for {
      list <- lists
      el <- list
    }
      yield el

    val res02 = lists.flatten

    println(res)
    println(res01)
    println(res02)
  }
}
