package quiz

object Pra02_05 {
  def main(args: Array[String]): Unit = {
    // 0の階乗 (0個の要素の積) を求める.
    println((1 to 0).product) // 1 (乗算の単位元)

    lazy val n = 100
    lazy val r = 20

    // n 個から r 個取り出す順列の個数 nPr を求める
    val pres = (BigInt(n - r + 1) to n).product
    println(pres)

    // n 個から r 個取り出す組合せの個数 nCr を求める.
    val cres = (BigInt(n - r + 1) to n).product / (BigInt(1) to r).product
    println(cres)
  }
}
