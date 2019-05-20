package graffiti

object Euclids {

  def lcm(x: Int, y: Int): Int = (x * y) / gcd(x, y)

  def gcd(x: Int, y: Int): Int = if (y == 0) Math.abs(x) else gcd(y, x % y)

  def main(args: Array[String]): Unit = {
    println(gcd(12, 15)) // 3
    println(lcm(12, 15)) // 60
  }

}
