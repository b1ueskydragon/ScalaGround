package graffiti

object ClosuresEg {
  val test: Int => Boolean = {
    // x => x % 2 == 0
    (x: Int) => x % 2 == 0
  }
}
