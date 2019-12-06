package graffiti

object SubSet {

  def generate[T](ts: List[T]): List[List[T]] = {
    /** Generate the power set.
      *
      * T = S ∪ {x} ( T = S ++ {x} )
      * P(T) = P(S) ∪ { p ∈ P(S) | p ∪ {x} }
      *
      * @param xs   group T
      * @param subs subsets
      * @return ps subsets
      */
    @scala.annotation.tailrec
    def rec(xs: List[T], subs: List[List[T]]): List[List[T]] =
      if (xs.isEmpty) subs else rec(xs.tail, subs ::: subs.map(xs.head :: _))

    rec(ts, List(Nil))
  }

}
