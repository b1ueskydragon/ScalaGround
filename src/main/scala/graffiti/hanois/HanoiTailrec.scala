package graffiti.hanois

case class Pos(n: Int, from: String, to: String, via: String)

object Pos {

  @scala.annotation.tailrec
  def move(pos: Pos, rest: List[Pos]): Unit = {
    val Pos(n, from, to, via) = pos
    if (n < 1) return

    if (n == 1) {
      println(s"$from -> $to")
      if (rest.nonEmpty) move(rest.head, rest.tail)
    } else {
      val pos1 = Pos(n - 1, from, via, to)
      val pos2 = Pos(1, from, to, via)
      val pos3 = Pos(n - 1, via, to, from)
      move(pos1, pos2 :: pos3 :: rest)
    }
  }

}

object HanoiTailrec {
  def main(args: Array[String]): Unit = {
    Pos.move(Pos(3, "left", "middle", "right"), Nil)
  }
}
