package quiz

// 行列をリストのリストで表す.転置行列(transposed matrix)を求えよ.
object Pra08_01_07 {
  def main(args: Array[String]): Unit = {
    val matrix = List(List(3, 1, 4, 1), List(2, 7, 1, 8), List(0, 5, 7, 7))
    // (3, 2, 0) (1, 7, 5) (4, 1, 7) (1, 8, 7)

    val res = for {
      idx <- matrix.head.indices
    } yield matrix.map(_ (idx))

    println(res)
  }
}
