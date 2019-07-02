package sm2019

import sm2019.Cps._

object MyApp extends App {

  val v = 10

  addTwo(v, multipleFive(_, println))

  val cont = for {
    m <- Cont.unit(v)
    n <- Cont(addTwo[Unit](m, _: Int => Unit))
    l <- Cont(multipleFive[Unit](n, _: Int => Unit))
  } yield l
  cont.run(println)

}
