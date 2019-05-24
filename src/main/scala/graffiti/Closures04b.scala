package graffiti

// Change type parameters to `Any` overall.
object Closures04b {
  def cons(a: Any, b: Any) = (p: (Any, Any) => Any) => p(a, b)

  def cons_(a: Any, b: Any) = (p: Any) => p.asInstanceOf[(Any, Any) => Any](a, b)

  def car(p: Any) = p.asInstanceOf[Any => Any]((a: Any, b: Any) => a)

  def cdr(p: Any) = p.asInstanceOf[Any => Any]((a: Any, b: Any) => b)

  def main(args: Array[String]): Unit = {
    print(car(cdr(cdr(cons(1, cons_('a, cons("s", "b")))))))
  }
}
