package graffiti

// Since type parameter does not take parameters occurs,
// use asInstanceOf.
object Closures02 {

  def cons[T, U, F](a: T, b: U) = (p: F) => p.asInstanceOf[(T, U) => F](a, b)

  def car(p: Any) = p.asInstanceOf[((Any, Any) => Any) => Any]((a: Any, b: Any) => a)

  def cdr(p: Any) = p.asInstanceOf[((Any, Any) => Any) => Any]((a: Any, b: Any) => b)

  def main(args: Array[String]): Unit = {
    val pair = cons('a, 'b)
    val pairPair = cons(cons(0, 1), cons('i, 'j))
    println(car(cdr(pairPair)))
  }
}
