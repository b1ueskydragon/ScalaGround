package quiz

import SeriesCalcTr._

// ∑n i=0 1/i! は n→∞ で e に収束する.
// n=20 の場合の値を求めよ. (1/0! + 1/1! + 1/2! + ... + 1/20!)
object Pra04_03_13 {
  def main(args: Array[String]): Unit = {

    lazy val n = 20

    // error exists
    val res = 1 + (for (i <- 1 to n) yield 1.0 / (1 to i).product).sum
    println(res)

    // Use manual definition ver.
    // error exists
    val res_ = 1 + sum((for (i <- 1 to n) yield 1.0 / product(i)).toList)
    println(res_)


    //Number of Napier.
    val rst = (n to 0 by -1).map { i =>
      (1 to i).map {
        1.0 / _
      }.product
    }
    println(rst.sum)
    println(Math.E)
  }
}
