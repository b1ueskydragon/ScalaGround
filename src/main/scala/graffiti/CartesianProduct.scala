package graffiti

object CartesianProduct {

  object Recursive {
    /** product ( { {a, A}, {b, B}, {c, C} } )
      *
      * product ( {a, A} :: product ( { {b, B}, {c, C} } ) )
      */
    def product[T](xss: Traversable[Traversable[T]]): Traversable[Traversable[T]] = xss match {
      case Nil => Nil
      case xs :: Nil => xs.map(List(_)) // only an one list
      case xs :: tail => xs.flatMap(x => product(tail).map(Traversable(x) ++ _))
    }

    // replace flatMap to yielding an element in each for-comprehension
    def productFor[T](xss: Traversable[Traversable[T]]): Traversable[Traversable[T]] = xss match {
      case Nil => Nil
      case xs :: Nil => xs.map(List(_)) // only an one list
      case xs :: tail => for {
        m <- xs
        n <- productFor(tail)
      } yield Traversable(m) ++ n
    }

    def productMerge[T](xss: Traversable[Traversable[T]]): Traversable[Traversable[T]] = xss match {
      case Nil => Traversable.empty[Traversable[T]]
      case xs :: ys :: Nil => xs.flatMap(x => ys.map(y => Traversable(x, y)))
      case xs :: tail => Traversable(xs) ++ productMerge(tail) // TODO flatten
    }

  }

  object NonRecursive {
    /** product ( { {a, A}, {b, B} } )
      *
      * a -- map --> { {a, b}, {a, B} }
      * ↑
      * we could get a flatten head element (a) with flatMap.
      *
      * xs.map := h ++ x
      *
      * h | h ∈ a plain type of result already generated(accumulated)
      * x | x ∈ xs
      * xs | xs ∈ xxs
      *
      * `Traversable.empty[Traversable[T]]` != `Traversable(Traversable.empty[T])`
      */
    def product[T](xss: Traversable[Traversable[T]]): Traversable[Traversable[T]] =
      xss.foldLeft(Traversable(Traversable.empty[T])) { (acc, xs) =>
        acc.flatMap { h =>
          xs.map(x => h ++ Traversable(x))
        }
      }

    def product2[T](xs: Traversable[T], ys: Traversable[T]): Traversable[(T, T)] = xs.flatMap(x => ys.map((x, _)))

  }

}
