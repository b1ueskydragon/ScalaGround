package graffiti

// Apply ideas from Closures, Closures01, Closures02
object Closures03 {

  def cons[T, U](a: T, b: U) = (p: (T, U) => _) => p(a, b)

  def car[T, U, F](p: F) = p.asInstanceOf[((T, U) => _) => T]((a: T, b: U) => a)

  def cdr[T, U, F](p: F) = p.asInstanceOf[((T, U) => _) => U]((a: T, b: U) => b)

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
