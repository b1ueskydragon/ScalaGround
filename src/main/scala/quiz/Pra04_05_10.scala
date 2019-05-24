package quiz

// 整数のリスト a0, a1, a2, …, an で，正則連分数を表すことにする.
// a0 + ( 1 / (a1 + (1 / a2)))
// 正則連分数を表すリストから，その実数値を求める関数cfracを定義せよ.
// ヒント: 与えられた整数リストに対し，まず map(_.toDouble) で実数のリストに変換しておく
object Pra04_05_10 {
  def main(args: Array[String]): Unit = {
    lazy val from = 1
    lazy val to = 4
    lazy val step = 1
    lazy val list = (from to to by step).toList
    println(cfrac(list))

    println(cfrac((1 to 20).map(_ => 1).toList)) //  黄金数 φ に収束
    println(cfrac((1 to 20).map(_ => 2).toList)) // 1+ √ 2 に収束
    println(cfrac(List(2, 1, 2, 1, 1, 4, 1, 1, 6, 1, 1, 8, 1, 1, 10))) // Math.E に収束

    println(cfracFuctional(List(2, 1, 2, 1, 1, 4, 1, 1, 6, 1, 1, 8, 1, 1, 10)))
  }

  /**
    * 正則連分数を表すリストから，その実数値を求める.
    *
    * @param list list of Integer
    * @return list of regular continued fraction
    */
  def cfrac(list: List[Int]): Double = {
    def _rec(list: List[Double]): Double = list match {
      case Nil => Double.PositiveInfinity
      case h :: tail => h + (1.0 / _rec(tail))
    }

    _rec(list.map(_.toDouble))
  }

  def cfracFuctional(list: List[Int]): Double = list.map(_.toDouble).reduceRight(_ + 1 / _)

}
