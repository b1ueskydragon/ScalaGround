package graffiti

// Something like Tuple
case class Pair[T, U](t: T, u: U)

object Closures {

  def cons[T, U](a: T, b: U): Pair[T, U] = Pair(a, b)

  def car[T, U](pair: Pair[T, U]): T = pair.t

  def cdr[T, U](pair: Pair[T, U]): U = pair.u

  def main(args: Array[String]): Unit = {
    val pair = cons('a, 'b)
    val pairPair = cons(cons(0, 1), cons(99, 100))
    println(car(pair))
    println(cdr(pair))
    println(cdr(car(pairPair)))
  }
}
