package sm2019

import org.scalatest.FunSpec
import sm2019.Cont._

class ContSpec extends FunSpec {

  describe("unit") {

    it("returns new Instance of Cont itself") {
      val a = 99
      assert(unit[String, Int](a).isInstanceOf[Cont[String, Int]])
    }

  }

}
