package quiz

// 1から100までの整数のうち，3の倍数でなく，また5の倍数でもない数のリストを求めよ
object Pra04_03_02 {
  def main(args: Array[String]): Unit = {

    val res = (1 to 100).filter(n => n % 3 != 0 && n % 5 != 0)
    println(res)

    def flag(n: Int): Boolean = {
      if (n % 3 == 0) false
      else if (n % 5 == 0) false
      else true
    }

    val res01 = (1 to 100).filter(flag)
    println(res01)
  }
}
