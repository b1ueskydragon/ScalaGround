package quiz

// Option 型 ...
object Pra_10_01 {
  def main(args: Array[String]): Unit = {
    val names: Seq[String] = Seq("A", "B", "C")
    val ageMap: Map[String, Int] = Map("A" -> 24, "B" -> 21, "C" -> 22)

    // Map.get(p) returns Some(a) or None.
    // Some(a) は長さ 1 のリスト, None は空リストと同様.

    val res = names.map(p => ageMap.get(p).filter(_ >= 22).map(_ + 1))
    println(res)

    // flatMap, for comprehension
    // 値が定義されてるものだけを簡潔に取り出す
    val res01 = names.flatMap(p => ageMap.get(p).filter(_ >= 22).map(_ + 1))
    println(res01)

    val res02 = for {
      p <- names
      a <- ageMap.get(p)

      if a >= 22
    } yield a + 1

    println(res02)
  }
}
