package sm2019

import org.scalatest.FunSpec
import sm2019.Cps._

class CpsSpec extends FunSpec {

  describe("addTwo") {

    it("returns a function result that took a value added two, after take an integer value and a function") {
      val v = 10
      val f = (x: Int) => x.toString
      assert(addTwo(v, f) === "12")
    }

  }

  describe("multipleFive") {

    it("returns a function result that took a value multiplied five, after take an integer value and a function") {
      val v = 10
      val f = (_: Int).toString
      assert(multipleFive(v, f) === "50")
    }

  }

  describe("subsequent processing") {

    it("returns a function result that took a value added two, after take an `multipleFive` processing") {
      val v = 10
      val f: Int => String = _.toString
      assert(addTwo(v, multipleFive(_, f)) === "60")
    }

    it("could be defined by Cont") {
      val v = 10

      val cont = for {
        m <- Cont.unit(v)
        n <- Cont(addTwo[String](m, _: Int => String))
        l <- Cont(multipleFive[String](n, _: Int => String))
      } yield l

      assert(cont.run(_.toString) === "60")
    }

    it("could be defined by flatMap") {
      val v = 10

      val cont = Cont.unit(v).flatMap { m =>
        Cont(addTwo[String](m, _: Int => String)).flatMap { n =>
          Cont(multipleFive[String](n, _: Int => String))
        }
      }

      assert(cont.run(_.toString) === "60")
    }

  }

}
