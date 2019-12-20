package graffiti


object Combination {
  @scala.annotation.tailrec
  def g[T](xs: List[T], res: List[List[T]]): List[List[T]] = xs match {
    case Nil => res
    case h :: tail => g(tail, res ::: tail.map(h :: List(_)))
  }

  // @scala.annotation.tailrec
  def f[T](xs: List[T], k: Int): List[List[T]] = xs match {
    case Nil => Nil
    case h :: tail =>
      val genTail: List[List[T]] = g(tail, Nil)
      // backtracking
      genTail.map(h :: _) ::: f(tail, k)
  }

}
