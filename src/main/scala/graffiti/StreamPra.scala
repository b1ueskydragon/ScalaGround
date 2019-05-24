package graffiti

/**
  * Lazy evaluation of scala Stream.
  */
object StreamPra {
  def main(args: Array[String]): Unit = {

    def fibFrom(a: Int, b: Int): Stream[Int] = {
      a #:: fibFrom(b, a + b)
    }

    val fibs = fibFrom(1, 1).take(7).toList
    println(fibs)
  }

}
