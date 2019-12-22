package graffiti

object Factorials {

  def fact00(n: Int): Int = {
    if (n == 0) 1 else n * fact00(n - 1)
  }

  @scala.annotation.tailrec
  def fact01(n: Int, stack: Int = 1): Int = {
    if (n == 0) stack else fact01(n - 1, stack * n)
  }

  // cps
  // TODO comment
  @scala.annotation.tailrec
  def fact02[A](n: Int, f: Int => A): A = {
    if (n == 0) f(1) else fact02(n - 1, (stack: Int) => f(stack * n))
  }

  // TODO

  def main(args: Array[String]): Unit = {
    assert(fact00(6) == 720)
    assert(fact01(6) == 720)
    assert(fact02(6, (stack: Int) => 1 * stack) == 720)
    assert(fact02(6, identity) == 720)
  }
}
