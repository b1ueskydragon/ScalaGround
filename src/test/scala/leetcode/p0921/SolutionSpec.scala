package leetcode.p0921

import leetcode.p0921.Solution._
import org.scalatest.FunSpec

class SolutionSpec extends FunSpec {

  describe("minAddToMakeValid") {

    it("case 1") {
      val parentheses = "())"
      val expected = 1
      assert(minAddToMakeValid(parentheses) === expected)
    }

    it("case 2") {
      val parentheses = "((("
      val expected = 3
      assert(minAddToMakeValid(parentheses) === expected)
    }

    it("case 3") {
      val parentheses = "()"
      val expected = 0
      assert(minAddToMakeValid(parentheses) === expected)
    }

    it("case 4") {
      val parentheses = "()))(("
      val expected = 4
      assert(minAddToMakeValid(parentheses) === expected)
    }

  }

}
