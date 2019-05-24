package quiz

// 要素である全整数の合計を求める.
object Pra08_08_02 {
  def main(args: Array[String]): Unit = {
    val lists = List(List(3, 1, 4), List(2, 7, 1, 8, 2, 8), List(0, 5, 7, 7))

    val res = lists.map(_.sum).sum

    val res01 = (for (lst <- lists) yield lst.sum).sum

    println(res)
    println(res01)
  }
}
