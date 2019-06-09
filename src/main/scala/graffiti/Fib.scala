package graffiti

import scala.annotation.tailrec

object Fib {

  // 1 1 2 3 5 ...
  // F3 = F2 + F1
  private[graffiti] def fib(n: Int): Int = if (n <= 1) 1 else fib(n - 2) + fib(n - 1)

  @tailrec private[graffiti] def fibTail(n: Int, curr: Int = 1, prev: Int = 1): Int =
    if (n <= 1) curr else fibTail(n - 1, curr + prev, curr)

}
