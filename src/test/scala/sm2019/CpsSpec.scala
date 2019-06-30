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

}
