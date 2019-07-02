package sm2019

import org.scalatest.FunSpec
import sm2019.Cont._

class ContSpec extends FunSpec {

  describe("unit") {

    it("returns a new Cont that has a function") {
      val a = 99
      assert(unit[String, Int](a).run(_.toString) === "99")
    }

  }

  describe("map") {

    it("is a functional composition") {
      val v = 99

      def f(x: Int) = x + 100

      def k(x: Int) = x.toString

      assert(Cont.unit(v).map(f).run(k) === "199")
    }

  }

}
