package graffiti

object Closured05 {
 //  def cons[T, U](a: T, b: U): F = (p: (T, U) => _) => p(a, b)
}

class F[T,U](a: T, b: U) {
  (p: (T, U) => Any) => p(a, b)
}