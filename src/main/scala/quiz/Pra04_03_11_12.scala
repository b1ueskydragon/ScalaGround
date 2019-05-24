package quiz

// a[i] = (−1)^i / (2i+1) を一般項にする数列 a[0], a[1], … 最初の100項からなるリストを求めよ.
object Pra04_03_11 {
  def main(args: Array[String]): Unit = {
    val max = 99

    // 1, -1/3, 1/5, -1/7, 1/9, …
    println(res00(max))
    println(res01(max))
  }

  def generalTerm(i: Int): Double = Math.pow(-1, i) / (2 * i + 1)

  def res00(r: Int) = (0 to r).map(generalTerm)
  def res01(r: Int) = (0 to r).map(i => if (i % 2 == 0) 1.0 / (2 * i + 1) else -1.0 / (2 * i + 1))
}

// 上のリストの総和の4倍を求めよ. 項数を増やすとどのような値に近づくと思うか.
object Pra04_03_12 {
  def main(args: Array[String]): Unit = {
    import Pra04_03_11._
    val max = 99999
    val res02 = res00(max).sum * 4
    val res03 = res01(max).sum * 4.0

    // π に収束
    println(res02)
    println(res03)
    println(Math.PI)

    // 計算誤差を小さくするため, 小さい値の項から先に和を求める.
    val res04 = (max to 0 by -1).map(generalTerm).sum * 4
    val res05 = (max to 0 by -1).map(i => if (i % 2 == 0) 1.0 / (2 * i + 1) else -1.0 / (2 * i + 1)).sum * 4

    println(res04)
    println(res05)
  }
}
