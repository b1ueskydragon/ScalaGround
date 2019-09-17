package leetcode.p0784

import org.scalatest.FunSpec
import leetcode.p0784.Solution._

class SolutionSpec extends FunSpec {

  describe("product") {
    describe("should return direct products of lists") {
      it("in case has only one element") {
        val expected = List(List('a), List('A))
        val actual = product(List(List('a, 'A)))
        assert(expected === actual)
      }
    }
  }
}
