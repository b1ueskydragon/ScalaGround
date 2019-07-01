package sm2019

/** k is subsequent processing */
object Cps {

  def multipleFive[A](v: Int, k: Int => A): A = k(v * 5)

  def addTwo[A](v: Int, k: Int => A): A = k(v + 2)

}

object Main extends App {

  import Cps._

  val v = 10

  addTwo(v, multipleFive(_, println))

  val cont = for {
    m <- Cont.unit(v)
    n <- Cont(addTwo[Unit](m, _: Int => Unit))
    l <- Cont(multipleFive[Unit](n, _: Int => Unit))
  } yield l
  cont.run(println)

}