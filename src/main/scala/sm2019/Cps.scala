package sm2019

/** k is subsequent processing */
object Cps {

  def multipleFive[A](v: Int, k: Int => A): A = k(v * 5)

  def addTwo[A](v: Int, k: Int => A): A = k(v + 2)

}
