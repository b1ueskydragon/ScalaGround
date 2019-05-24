package graffiti

object MyLunch {
  implicit def rnd(): WeightedRandom = new WeightedRandom

  def main(args: Array[String]): Unit = {
    /*
     * sukiyaki
     * 300
     * hamburger
     * 50
     * bento-with-salad
     * 100
     *
     * So what's on the menu today?
     */
    println(rnd().pick(candidates().take(3).toList))
  }

  def candidates(): Stream[(String, Int)] = {
    candidate #:: candidates()
  }

  def candidate(): (String, Int) = {
    import java.util.Scanner
    val sc = new Scanner(System.in)
    (sc.next, sc.nextInt)
  }

  /** only for test.
    *
    * example.
    * (1 to 20).toList foreach (_ => println(tester(rnd())))
    */
  private def tester(rnd: WeightedRandom) = {
    val input = List(("a", 30), ("b", 10), ("c", 40), ("d", 20))
    var a, b, c, d = 0

    (1 to 1000000).toList foreach { _ =>
      val res = rnd.pick(input)
      if (res == "a") a += 1
      if (res == "b") b += 1
      if (res == "c") c += 1
      if (res == "d") d += 1
    }

    ((a, b, c, d), a + b + c + d) // expected 3 : 1 : 4 : 2 , SUM=1000000
  }
}


