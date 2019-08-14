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


  def move(pos: Pos, rest: List[Pos]): Unit = {
    val Pos(n, from, to, via) = pos
    if (n == 1) {
      println(s"$from -> $to")
      move(rest.head, rest.tail)
    } else {
      val pos1 = Pos(n - 1, from, via, to)
      val pos2 = Pos(1, from, to, via)
      val pos3 = Pos(n - 1, via, to, from)
      move(pos1, pos2 :: pos3 :: rest)
    }
  }


  def main(args: Array[String]): Unit = {
    hanoi(3, "left", "middle", "right")
    println()
  }

}

case class Pos(n: Int, from: Int, to: Int, via: Int)
