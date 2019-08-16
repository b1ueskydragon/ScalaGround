package graffiti.hanois

object HanoiLazy {
  def move(n: Int, from: String, to: String, via: String): Stream[String] =
    if (n < 1) Stream.empty
    else if (n == 1) Stream(s"$from -> $to")
    else move(n - 1, from, via, to) #::: move(1, from, to, via) #::: move(n - 1, via, to, from)

  def main(args: Array[String]): Unit = {
    val stream = HanoiLazy.move(3, "left", "middle", "right")
    stream.foreach(println)
  }
}
