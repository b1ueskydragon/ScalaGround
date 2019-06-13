package leetcode.p0832

import leetcode.p0832.Solution._
import org.scalatest._

class SolutionSpec extends FunSpec with Matchers {

  describe("flipAndInvertImage") {

    it("should return flip and inverted rows when given R3 matrix") {

      val input = Array(Array(1, 1, 0), Array(1, 0, 1), Array(0, 0, 0))

      val expected = Array(Array(1, 0, 0), Array(0, 1, 0), Array(1, 1, 1))
      val actual = flipAndInvertImage(input)

      assert(expected === actual)

    }

    it("should return flip and inverted rows when given R4 matrix") {

      val input = Array(Array(1, 1, 0, 0), Array(1, 0, 0, 1), Array(0, 1, 1, 1), Array(1, 0, 1, 0))

      val expected = Array(Array(1, 1, 0, 0), Array(0, 1, 1, 0), Array(0, 0, 0, 1), Array(1, 0, 1, 0))
      val actual = flipAndInvertImage(input)

      assert(expected === actual)

    }

  }

}