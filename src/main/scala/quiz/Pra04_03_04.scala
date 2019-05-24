package quiz

object Pra04_03_04 {
  def main(args: Array[String]): Unit = {
    val res = (0 to 10).map(n => Integer.parseInt("1" * n + "0" + "1" * n, 2))
    println(res)
  }
}
