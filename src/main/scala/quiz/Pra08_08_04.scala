package quiz

// foldLeftを用いて，要素リストを逆順にして連結したリストを求める.

// ヒント: 空リストは List[Int]() で表す．
// foldLeft(init)(func)
object Pra08_08_04 {
  def main(args: Array[String]): Unit = {
    val smp = List(2, 7, 1, 8)
    println(smp.foldLeft(0)(_ + _)) // smp.sum
    println(smp.foldLeft(0)(10 * _ + _))

    val lists = List(List(3, 1, 4), List(2, 7, 1, 8, 2, 8), List(0, 5, 7, 7))

    val res = lists.foldLeft(List[Int]())(_ ++ _.reverse)

    println(res)

    val res01 = for {
      list <- lists
      rist <- list.reverse
    } yield rist

    println(res01)
  }
}
