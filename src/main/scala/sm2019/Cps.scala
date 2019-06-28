package sm2019

/** f is subsequent processing */
object Cps {

  def multipleFive[A](v: Int, f: Int => A): A = f(v * 5)

  def addTwo[A](v: Int, f: Int => A): A = f(v + 2)

  def main(args: Array[String]): Unit = {
    // println is subsequent processing that passed by param
    addTwo(10, multipleFive(_, println)) // 60
  }

}