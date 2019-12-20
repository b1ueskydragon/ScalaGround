package graffiti


object Combination {
  @scala.annotation.tailrec
  def g[T](xs: List[T], res: List[List[T]]): List[List[T]] = xs match {
    case Nil => res
    case h :: tail => g(tail, res ::: tail.map(h :: List(_)))
  }

  @scala.annotation.tailrec
  def f[T](xs: List[T], res: List[List[T]]): List[List[T]] = xs match {
    case Nil => res
    case h :: tail =>
      val genTail: List[List[T]] = g(tail, Nil)
      f(tail, res ::: genTail.map(h :: _))
  }

  @scala.annotation.tailrec
  def s[T](xs: List[T], res: List[List[T]]): List[List[T]] = xs match {
    case Nil => res
    case h :: tail =>
      val genTail: List[List[T]] = f(tail, Nil)
      s(tail, res ::: genTail.map(h :: _))
  }

}
