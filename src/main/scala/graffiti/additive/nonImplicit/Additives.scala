package graffiti.additive.nonImplicit

import graffiti.additive.Additive

object Additives {

  object IntAdditive extends Additive[Int] {
    def plus(a: Int, b: Int): Int = a + b

    def zero: Int = 0
  }

  object StringAdditive extends Additive[String] {
    def plus(a: String, b: String): String = a + b

    def zero: String = ""
  }

}


