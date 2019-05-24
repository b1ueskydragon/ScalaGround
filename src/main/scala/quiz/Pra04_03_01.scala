package quiz

// 142857 を 1 倍から 7 倍までした結果のリストを求めよ.
// Cyclic Number
object Pra04_03_01 {
  def main(args: Array[String]): Unit = {
    lazy val s = 1; lazy val e = 7; lazy val datum = 142857
    println((s to e).map(datum * _))
  }
}
