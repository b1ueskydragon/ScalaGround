package leetcode.p0090

import org.scalatest.FunSpec
import leetcode.p0090.Solution._

class SolutionSpec extends FunSpec {

  describe("subsetsWithDup") {

    it("returns 6 subsets without duplication in case [1, 2, 2]") {
      val nums = Array(1, 2, 2)
      val expected = List(
        List(),
        List(1),
        List(2),
        List(2, 1),
        List(2, 2),
        List(2, 2, 1)
      )
      assert(subsetsWithDup(nums) === expected)
    }

    it("returns same result without duplication in case [2, 1, 2]") {
      val nums = Array(2, 1, 2)
      val expected = List(
        List(),
        List(1),
        List(2),
        List(2, 1),
        List(2, 2),
        List(2, 2, 1)
      )
      assert(subsetsWithDup(nums) === expected)
    }

  }

}
