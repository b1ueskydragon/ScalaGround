package leetcode.p0860

import leetcode.p0860.Solution._
import org.scalatest.FunSpec

class SolutionSpec extends FunSpec {

  describe("lemonadeChange") {

    it("case true") {
      val bills = Array(5, 5, 5, 5, 10, 5, 10, 10, 10, 20)
      assert(lemonadeChange(bills))
      assert(lemonadeChange_(bills))
    }

    it("case false") {
      val bills = Array(5, 5, 20, 5, 5, 10, 5, 10, 5, 20)
      assert(!lemonadeChange(bills))
      assert(!lemonadeChange_(bills))
    }

  }


}
