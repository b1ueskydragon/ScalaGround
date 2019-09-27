package graffiti

object CartesianProduct {

  object Recursive {
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

    // replace flatMap to yielding an element in each for-comprehension
    def productFor[T](xss: Traversable[Traversable[T]]): Traversable[Traversable[T]] = xss match {
      case Nil => Nil
      case xs :: Nil => xs.map(List(_)) // only an one list
      case xs :: tail => for {
        m <- xs
        n <- productFor(tail)
      } yield Traversable(m) ++ n
    }

  }

  object NonRecursive {
    // Traversable.empty[Traversable[T]] != Traversable(Traversable.empty[T])
    def product[T](xss: Traversable[Traversable[T]]): Traversable[Traversable[T]] =
      xss.foldLeft(Traversable(Traversable.empty[T])) { (acc, xs) =>
        acc.flatMap { h =>
          xs.map(x => h ++ Traversable(x))
        }
      }

    def product2[T](xs: Traversable[T], ys: Traversable[T]): Traversable[(T, T)] = xs.flatMap(x => ys.map((x, _)))
  }


  def main(args: Array[String]): Unit = {
    println(Recursive.product(Nil))

    val alist = List(List('a, 'b, 'c))
    println(Recursive.product(alist))

    val lists = List(List('a, 'b, 'c), List(1, 2, 3))
    println(Recursive.product(lists))
    println(Recursive.productFor(lists))
    println(NonRecursive.product(lists))

    println(NonRecursive.product2(List('y, 'Y), List('z, 'Z)))
  }

}
