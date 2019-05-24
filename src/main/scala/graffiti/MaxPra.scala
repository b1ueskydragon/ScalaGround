package graffiti

object MaxPra {

  def main(args: Array[String]): Unit = {
    println(max(3, 5))
  }

  def max(x: Int, y: Int) = if (x>y) x else y

}
