package graffiti


object Combination {
  // @scala.annotation.tailrec
  def combination[T](xs: List[T], k: Int, res: List[List[T]]): List[List[T]] =
    if (k < 1) List(Nil)
    else {
      val f: List[T] => List[List[T]] =
        ts => combination(ts, k - 1, res) // TODO
      cps(xs, res)(f)
    }

  @scala.annotation.tailrec
  def cps[T](xs: List[T], res: List[List[T]])
    (f: List[T] => List[List[T]]): List[List[T]] = xs match {
    case Nil => res
    case _ :: tail => cps(tail, res ::: f(xs))(f)
  }

  @scala.annotation.tailrec
  def g[T](xs: List[T], res: List[List[T]]): List[List[T]] = xs match {
    case Nil => res
    case h :: tail => g(tail, res ::: tail.map(h :: List(_)))
  }

  @scala.annotation.tailrec
  def f[T](xs: List[T], res: List[List[T]]): List[List[T]] = xs match {
    case Nil => res
    case h :: tail =>
      f(tail, res ::: g(tail, Nil).map(h :: _))
  }

  @scala.annotation.tailrec
  def s[T](xs: List[T], res: List[List[T]]): List[List[T]] = xs match {
    case Nil => res
    case h :: tail =>
      s(tail, res ::: f(tail, Nil).map(h :: _))
  }

}
