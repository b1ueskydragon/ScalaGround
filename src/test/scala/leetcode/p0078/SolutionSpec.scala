package leetcode.p0078

import org.scalatest.FunSpec
import leetcode.p0078.Solution._

class SolutionSpec extends FunSpec {

  describe("subsets") {

    it("should return order that concat each num right to left in DFS generation") {
      val expected = List(
        List(),
        List(1),
        List(2),
        List(2, 1),
        List(3),
        List(3, 1),
        List(3, 2),
        List(3, 2, 1)
      )
      assert(subsets(Array(1, 2, 3)) === expected)
    }

    it("should return another order in middle recursion") {
      val expected = ??? // List(List(1, 2, 3),  ... , List())
      assert(subsets_(Array(1, 2, 3)) === expected)
    }

  }

}
