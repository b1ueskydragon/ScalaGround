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

  def hanoi(stackX: List[Int], stackY: List[Int], stackZ: List[Int]): Unit = {
    hanoi(stackX.init, stackX.head :: stackY, stackZ)
    println()
    hanoi(stackX.init, stackX.head :: stackY, stackZ)
  }

  def main(args: Array[String]): Unit = {
    hanoi(3, "left", "middle", "right")
    println()
    //hanoi(List(3, 2, 1), "left", "middle", "right") // order
  }

}
