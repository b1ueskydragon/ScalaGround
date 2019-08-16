package graffiti.hanois

/** H(n) = H(n-1) + H(1) + H(n-1) */
object Hanoi {
  /** A `move`
    *
    * @param n disk. 1 is the smallest, n is the biggest
    * @param x peg move from. init is left
    * @param y peg to go. init is middle
    * @param z peg via. init is right
    */
  def move(n: Int, x: String, y: String, z: String): Unit = {
    if (n > 0) {
      move(n - 1, x, z, y)
      println(s"$n, $x -> $y")
      move(n - 1, z, y, x)
    }
  }

  def move_(n: Int, from: String, to: String, via: String): Unit = {
    if (n < 1) return

    if (n == 1) {
      println(s"$from -> $to")
    } else {
      move_(n - 1, from, via, to)
      move_(1, from, to, via)
      move_(n - 1, via, to, from)
    }
  }

  def main(args: Array[String]): Unit = {
    move(3, "left", "middle", "right")
    println()
    move_(3, "left", "middle", "right")
  }

  def hanoi(n: Int): Array[String] = {
    val buff = scala.collection.mutable.ArrayBuffer.empty[String]

    def _move(n: Int, from: String, to: String, via: String) {
      if (n > 0) {
        _move(n - 1, from, via, to)
        buff.append(s"$from -> $to")
        _move(n - 1, via, to, from)
      }
    }

    _move(n, "left", "middle", "right")
    buff.toArray
  }

  def hanoiList(n: Int, from: String, to: String, via: String): List[String] = {
    if (n < 1) Nil
    else if (n == 1) List(s"$from -> $to")
    else hanoiList(n - 1, from, via, to) ::: hanoiList(1, from, to, via) ::: hanoiList(n - 1, via, to, from)
  }

}
