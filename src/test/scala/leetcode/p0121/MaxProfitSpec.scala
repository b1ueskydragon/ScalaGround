package leetcode.p0121

import org.scalatest.FunSpec

class MaxProfitSpec extends FunSpec {

  describe("maxProfit") {

    it("should return zero in empty case") {
      assert(Solution.maxProfit(Array.empty[Int]) === 0)
    }

    it("should return zero in descending sorted case") {
      assert(Solution.maxProfit(Array(6, 5, 4, 3, 2, 1)) === 0)
    }

    it("should return max diff in sorted case") {
      assert(Solution.maxProfit(Array(1, 2, 3, 4, 5)) === 4)
    }

    it("should return max diff in random case") {
      val xs = Vector(3, 6, 5, 9, 6, 1, 0, 0, 4, 8, 5)
      assert(Solution.maxProfit(xs.toArray) === 8)
    }

  }

}
