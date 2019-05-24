package quiz

// 3桁の整数で，各桁の数の和が10に等しいものを求めよ．
object Pra04_07_04 {
  def main(args: Array[String]): Unit = {
    // recursive search
    println((100 to 999 toList).filter(n => sum3digit(n) == 10))

    // simply generate
    println(
      for {
        i3 <- 1 to 9
        i2 <- 0 to 9
        i1 <- 0 to 9

        if i3 + i2 + i1 == 10
      } yield 100 * i3 + 10 * i2 + i1
    )

    // same as above
    println(
      for {
        i3 <- 1 to 9
        i2 <- 0 to 9
        i1 <- 0 to 9

        if i3 + i2 + i1 == 10
        stack <- Vector(100 * i3 + 10 * i2 + i1)
      } yield stack
    )
  }

  // each num
  // Math.ceil can be omitted
  def sum3digit(n: Int): Int = {
    def _rec(n: Int, stack: Int): Int = n.toString.length match {
      case 3 => _rec(n - (n / 100) * 100, stack + (n / 100))
      case 2 => _rec(n - (n / 10) * 10, stack + (n / 10))
      case 1 => stack + n
    }

    _rec(n, 0)
  }
}
