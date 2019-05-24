package graffiti

object MyRecursion {

  def mutualRecursion(a: Int): Int = {

    def f(x: Int): Int = if (x <= 1) 1 else g(x + 2)

    def g(x: Int): Int = f(x - 3) + 4

    f(a)
  }

  def main(args: Array[String]): Unit = {
    println(mutualRecursion(2))
  }
}
