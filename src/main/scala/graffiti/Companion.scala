package graffiti

/** The Companion class
  *   - class with same name as singleton object.
  *
  * @param name private-scope param
  */
class Companion private(val name: String)

/** The Companion object ( ∈ Singleton)
  *   - same name and same scope.
  *   - Both class and object must be defined in the same source file.
  */
object Companion {
  def apply(aName: String): Companion = {
    new Companion(aName)
  }
}

/** Test
  */
object Exe {
  def main(args: Array[String]) {
    val companion = Companion("Alex") // invokes Companion.apply
    println(companion.name)
  }
}

// TODO impl unapply()