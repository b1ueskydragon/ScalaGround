package quiz

// Pra04_05_04, Pra04_05_05
object ReducePra {
  def main(args: Array[String]): Unit = {
    lazy val list = List(2, 7, 1, 8)

    val left = list.reduceLeft((a, b) => 100 * a + b)
    val right00 = list.reduceRight((a, b) => 100 * a + b)
    val right01 = list.reduceRight((a, b) => a + 100 * b)

    println(left)
    println(right00)
    println(right01)
  }
}
