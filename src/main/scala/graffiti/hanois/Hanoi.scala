package graffiti.hanois

/** H(n) = H(n-1) + H(1) + H(n-1) */
object Hanoi {
  /** A `move`
    *
    * @param n    disk. 1 is the smallest, n is the biggest
    * @param from peg move from. init is left
    * @param to   peg to go. init is middle
    * @param via  peg via. init is right
    */
  def move(n: Int, from: String, to: String, via: String): Unit = {
    if (n < 1) return
    move(n - 1, from, via, to)
    println(s"$n, $from -> $to") // H(1)
    move(n - 1, via, to, from)
  }

  def main(args: Array[String]): Unit = {
    val disks = 3
    move(disks, "left", "middle", "right")
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
