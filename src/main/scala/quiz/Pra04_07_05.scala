package quiz

// 1から10の整数nについて10nと10n+1を要素とするリスト 10, 11, 20, 21, …, 100, 101 を求めたい.
object Pra04_07_05 {
  def main(args: Array[String]): Unit = {
    // return nested result
    println((for (n <- 1 to 10) yield Vector(10 * n, 10 * n + 1)).flatten)

    // return each result inside
    println(for (n <- 1 to 10; res <- Vector(10 * n, 10 * n + 1)) yield res)
  }
}
