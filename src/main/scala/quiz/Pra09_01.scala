package quiz

object Pra09_01 {
  def main(args: Array[String]): Unit = {

    // pairs について...
    val pairs = for (x <- 1 to 3; y <- 1 to 3) yield (x, y)
    println("ori   : " + pairs)

    // 1. 各対の第1要素と第2要素を交換したリストを求める.
    val res01 = pairs.map(p => (p._2, p._1))
    val res0101 = for ((x, y) <- pairs) yield (y, x)

    println("res01 : " + res01)
    println("res01 : " + res0101)

    // 2. 各対の第1要素から成る集合を求める
    val res02 = pairs.map(_._1).toSet

    println("res02 : " + res02)

    // 3. 第1要素と第2要素の和の昇順にソートしたリストを求める.
    val res03 = pairs.sortBy(p => p._1 + p._2)

    println("res03 : " + res03)
  }
}
