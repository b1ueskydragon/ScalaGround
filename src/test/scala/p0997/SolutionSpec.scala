package p0997

import leetcode.p0997.Solution.findJudge
import org.scalatest.{FunSpec, Matchers}

class SolutionSpec extends FunSpec with Matchers {

  describe("findJudge") {

    it("should return judge if there only one people") {
      val N = 1
      val trust = Array.empty[Array[Int]]

      val expected = 1
      val actual = findJudge(N, trust)

      assert(expected == actual)
    }

    it("should return right hand side value if there only two people") {
      val N = 2
      val trust = Array(Array(1, 2))

      val expected = 2
      val actual = findJudge(N, trust)

      assert(expected == actual)
    }

    it("should return a judge if judge trusted by everyone except judge itself AND judge trust nobody") {
      val N = 3
      val trust = Array(Array(1, 3), Array(2, 3), Array(2, 1), Array(1, 2))

      val expected = 3
      val actual = findJudge(N, trust)

      assert(expected == actual)
    }

    it("should return a judge if judge trusted by everyone except judge itself AND judge trust nobody in 4 people") {
      val N = 4
      val trust = Array(Array(1, 3), Array(1, 4), Array(2, 3), Array(2, 4), Array(4, 3))

      val expected = 3
      val actual = findJudge(N, trust)

      assert(expected == actual)
    }

    it("should NOT return a judge if judge trusted by not everyone") {
      val N = 4
      val trust = Array(Array(1, 3), Array(1, 4), Array(2, 3), Array(2, 4))

      val expected = -1
      val actual = findJudge(N, trust)

      assert(expected == actual)
    }

    it("should NOT return a judge if judge trusted by everyone except judge itself BUT judge trust someone") {
      val N = 3
      val trust = Array(Array(1, 3), Array(2, 3), Array(3, 1))

      val expected = -1
      val actual = findJudge(N, trust)

      assert(expected == actual)
    }

    it("should NOT return a judge if there is not enough trust") {
      val N = 3
      val trust = Array(Array(1, 2), Array(2, 3))

      val expected = -1
      val actual = findJudge(N, trust)

      assert(expected == actual)
    }

  }

}
