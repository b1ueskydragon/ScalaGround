package leetcode.p0441

import leetcode.p0441.Solution._
import org.scalatest.FunSpec

class SolutionSpec extends FunSpec {

  describe("arrangeCoins") {

    it("returns a final step that completed if there are not enough coins") {
      assert(arrangeCoins(5) === 2)
      assert(arrangeCoins(8) === 3)
      assert(arrangeCoins(1804289383) === 60070)

      assert(arrangeCoins_(5) === 2)
      assert(arrangeCoins_(8) === 3)
      assert(arrangeCoins_(1804289383) === 60070)
    }

    it("returns final step that completed if there are n enough coins") {
      assert(arrangeCoins(3) === 2)
      assert(arrangeCoins(6) === 3)
      assert(arrangeCoins(10) === 4)

      assert(arrangeCoins_(3) === 2)
      assert(arrangeCoins_(6) === 3)
      assert(arrangeCoins_(10) === 4)
    }

  }

}
