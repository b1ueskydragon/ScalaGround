package quiz

// 最初の10個の2進単眼数(http://oeis.org/A138148)の文字列から成るリストを求めよ．
object Pra04_03_03 {
  def main(args: Array[String]): Unit = {
    val res = (0 to 10).map(n => "1" * n + "0" + "1" * n)
    println(res)
  }
}
