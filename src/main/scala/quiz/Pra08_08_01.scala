package quiz

// 要素リストの長さの最大値を求める.
object Pra08_08_01 {
  def main(args: Array[String]): Unit = {
    val lists = List(List(3, 1, 4), List(2, 7, 1, 8, 2, 8), List(0, 5, 7, 7))

    val res = lists.map(_.size).max

    val res01 = (for (lst <- lists) yield lst.size).max

    println(res)
    println(res01)
  }
}
