package quiz

// n=100 の時， ∑n i=1 1/i を計算せよ
object Pra04_03_10 {
  def main(args: Array[String]): Unit = {
    val n = 100

    val res = (1 to n).map(1d / _).sum

    val res01 = (for {
      i <- Range(1, n + 1)
    } yield 1.0 / i).sum

    println(res)
    println(res01)
  }
}
