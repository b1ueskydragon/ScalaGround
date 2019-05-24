package graffiti.additive.nonImplicit

import graffiti.additive.Additive
import graffiti.additive.nonImplicit.Additives._

object Main {
  /* without implicit parameter */
  def sum00[A](lst: List[A])(m: Additive[A]): A = lst.foldLeft(m.zero)((x, y) => m.plus(x, y))

  def main(args: Array[String]): Unit = {

    println("without implicit parameter")

    println(sum00(List(1, 2, 3))(IntAdditive))
    println(sum00(List("A", "B", "C"))(StringAdditive))
  }
}