package graffiti

import scala.annotation.tailrec

/** Continuation passing style
  *
  * http://www.geocities.jp/m_hiroi/java/scala23.html
  */
object Cps {

  // 1
  def foo(): Unit = println("foo")

  def bar(): Unit = println("bar")

  def baz(): Unit = println("baz")

  def testCps(cont: () => Unit): Unit = {
    foo()
    bar()

    cont()
  }

  // 2
  def addCps(a: Int, b: Int, cont: Int => Int): Int = cont(a + b)

  // 3
  @tailrec
  def factCps[A](n: Int, cont: BigInt => A): A = {
    if (n == 0) cont(1)
    else factCps(n - 1, x => cont(n * x))
  }


  def main(args: Array[String]): Unit = {
    // 1
    testCps(baz)

    // 2
    println(addCps(1, 2, x => x))

    addCps(1, 2, x => {
      println(x)
      x
    })

    // 3
    factCps(5, println)

    println((1 to 20).map(factCps(_, x => x)))
    (1 to 20).foreach(factCps(_, println))
  }
}
