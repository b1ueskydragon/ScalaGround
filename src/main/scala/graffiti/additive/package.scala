import graffiti.additive.Additive

/**
  * implicit cannot be used at the package level.
  *
  * You need to put your implicit objects inside another object
  * that you can then import where you need the implicits.
  *
  * One could also use a package object.
  */
package object additives {

  // Haskell の用語だと Additive を型クラス,
  // StringAdditive と IntAdditive を Additive 型クラスのインスタンスと呼びます.

  implicit object IntAdditive extends Additive[Int] {
    def plus(a: Int, b: Int): Int = a + b

    def zero: Int = 0
  }

  implicit object StringAdditive extends Additive[String] {
    def plus(a: String, b: String): String = a + b

    def zero: String = ""
  }

}
