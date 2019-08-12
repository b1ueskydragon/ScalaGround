package graffiti

object Hanoi {
  /** H(n) = H(n-1) + H(1) + H(n-1)
    *
    * @param n 1 is the smallest, n is the biggest
    * @param x peg from
    * @param y peg to go
    * @param z peg remain
    */
  def hanoi(n: Int, x: String, y: String, z: String): Unit = {
    if (n > 0) {
      hanoi(n - 1, x, z, y)
      println(s"""$n, $x -> $y""") // move a biggest one, left to middle (base plate)
      hanoi(n - 1, z, y, x)
    }
  }

  // TODO test code
  def hanoi(ns: List[Int], x: String, y: String, z: String): Unit = {
    // x, y, z stack
    def rec(): Unit = {
      if (ns.nonEmpty) {
        hanoi(ns.tail, x, z, y)
        println(s"""${ns.head}, $x -> $y""")
        hanoi(ns.tail, z, y, x)
      }
    }
  }

  def main(args: Array[String]): Unit = {
    hanoi(3, "left", "middle", "right")
    println()
    hanoi(List(3, 2, 1), "left", "middle", "right") // order
  }

}