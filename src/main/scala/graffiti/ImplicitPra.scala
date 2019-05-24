package graffiti

class IntToBool(val n: Int) {
  def isOdd: Boolean = n % 2 != 0
}

object ImplicitPra {
  // Implicit conversion.
  implicit def isEven(n: Int): Boolean = n % 2 == 0

  // Implicit conversion (Pimp my library pattern).
  implicit def enIntToBool(n: Int): IntToBool = new IntToBool(n)

  // Pimp my library pattern.
  implicit class Tap[T](self: T) {
    def tap[U](block: T => U): T = {
      block(self) // Discarding value
      self
    }
  }

  def main(args: Array[String]): Unit = {
    if (2) println("Even") // it works.

    println(1) // 1
    println(1.isOdd) // true

    // Debug like
    "penguin".tap(println).reverse.tap(println)
  }
}
