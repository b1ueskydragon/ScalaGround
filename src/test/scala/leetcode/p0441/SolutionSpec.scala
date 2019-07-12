package leetcode.p0441

import org.scalatest.FunSpec
import leetcode.p0441.Solution._

class SolutionSpec extends FunSpec {

  describe("arrangeCoins") {

    it("returns a final step that completed if there are not enough coins") {
      assert(arrangeCoins(5) === 2)
      assert(arrangeCoins(8) === 3)
      assert(arrangeCoins(1804289383) === 60070)
    }

    it("returns final step that completed if there are n enough coins") {
      assert(arrangeCoins(3) === 2)
      assert(arrangeCoins(6) === 3)
      assert(arrangeCoins(10) === 4)
    }

  }

}
