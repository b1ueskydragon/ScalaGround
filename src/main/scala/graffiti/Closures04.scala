package graffiti

// Use type `Any` from Closures03
object Closures04 {

  def cons[T, U](a: T, b: U): Any = (p: (T, U) => _) => p(a, b)

  def car[T, U](p: Any): T = p.asInstanceOf[Any => T]((a: T, b: U) => a)

  def cdr[T, U](p: Any): U = p.asInstanceOf[Any => U]((a: T, b: U) => b)

  def main(args: Array[String]) {
    val pair = cons('a, 'b)
    val pairPair = cons(cons(0, 1), cons('i, 'j))
    val pairPairPair = cons(pair, pairPair)

    println(car(pair))
    println(cdr(pair))
    println(car(cdr(pairPair)))
    println(cdr(car(cdr(pairPairPair))))
  }
}
