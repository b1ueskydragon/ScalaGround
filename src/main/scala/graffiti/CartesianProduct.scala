package graffiti

object CartesianProduct {

  /**
    * product ( { {a, A}, {b, B}, {c, C} } )
    *
    * product ( {a, A} :: product ( { {b, B}, {c, C} } ) )
    */
  def product[T](xss: Traversable[Traversable[T]]): Traversable[Traversable[T]] = xss match {
    case Nil => Nil
    case xs :: Nil => xs.map(List(_)) // only an one list
    case xs :: tail => xs.flatMap(x => product(tail).map(Traversable(x) ++ _))
  }

  // recursive; replace flatMap to yielding an element in each for-comprehension
  def product_[T](xss: Traversable[Traversable[T]]): Traversable[Traversable[T]] = xss match {
    case Nil => Nil
    case xs :: Nil => xs.map(List(_)) // only an one list
    case xs :: tail => for {
      m <- xs
      n <- product_(tail)
    } yield Traversable(m) ++ n
  }

  // non-recursive
  // Traversable.empty[Traversable[T]] != Traversable(Traversable.empty[T])
  def product___[T](xss: Traversable[Traversable[T]]): Traversable[Traversable[T]] =
    xss.foldLeft(Traversable(Traversable.empty[T])) { (acc, xs) =>
      acc.flatMap { h =>
        xs.map(x => h ++ Traversable(x))
      }
    }

  def product2[T](xs: Traversable[T], ys: Traversable[T]): Traversable[(T, T)] = xs.flatMap(x => ys.map((x, _)))

  def main(args: Array[String]): Unit = {
    println(product(Nil))
    val alist = List(List('a, 'b, 'c))
    println(product(alist))

    val lists = List(List('a, 'b, 'c), List(1, 2, 3))
    println(product(lists))
    println(product_(lists))
    println(product___(lists))

    println(product2(List('y, 'Y), List('z, 'Z)))
  }

}
