package quiz

//整数 i, j, k がそれぞれ 1 から 3 まで変化する時, 100*i+10*j+k を要素とするリスト(あるいはVector)を求める.
object Pra08_03_02 {
  def main(args: Array[String]): Unit = {

    val res =
      for {
        i <- 1 to 3
        j <- 1 to 3
        k <- 1 to 3
      } yield 100 * i + 10 * j + k

    println(res)


    val res01 =
      (1 to 3).flatMap { i =>
        (1 to 3).flatMap { j =>
          (1 to 3).map { k =>
            100 * i + 10 * j + k
          }
        }
      }

    println(res01)
  }
}
