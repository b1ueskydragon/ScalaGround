package graffiti

import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration


object Future101 {

  def toFNum(n: Int): Future[Int] = Future(n)

  def toFStr(n: Int): Future[String] = Future {
    if (n < 10) "I returned " + n // success
    else throw new IllegalArgumentException // fail
  }

  // TODO Future.fold

  def main(args: Array[String]): Unit = {

    val successRes: Future[String] = for {
      numA <- toFNum(9)
      numB <- toFNum(8)
      strA <- toFStr(numA) // success
      strB <- toFStr(numB) // success
    } yield strA + " and " + strB

    val res: String = Await.result(successRes, Duration.Inf)
    println(res)

    val failRes: Future[String] = for {
      numA <- toFNum(11)
      numB <- toFNum(8)
      strA <- toFStr(numA) // fail
      strB <- toFStr(numB) // no-op
    } yield strA + " and " + strB

    val res01: String = Await.result(failRes, Duration.Inf)
    println(res01)

  }

}
