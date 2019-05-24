package graffiti

import scala.collection.mutable

object Mutables {
  def main(args: Array[String]): Unit = {
    val lists = List(List(1), List(2), List(3))
    val mlists = mutable.ListBuffer(lists: _*)
    println(mlists)
    mlists ++= List(List(4))
    println(mlists)
  }
}
