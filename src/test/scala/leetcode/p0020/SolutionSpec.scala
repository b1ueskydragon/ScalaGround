package leetcode.p0020

import leetcode.p0020.Solution._
import org.scalatest.FunSpec

class SolutionSpec extends FunSpec {

  describe("isValid") {

    it("case true empty") {
      val s = ""
      assert(isValid(s))
      assert(isValid01(s))
    }

    it("case true 01") {
      val s = "()"
      assert(isValid(s))
      assert(isValid01(s))
    }

    it("case true 02") {
      val s = "()[]{}"
      assert(isValid(s))
      assert(isValid01(s))
    }

    it("case true 03") {
      val s = "{[]}"
      assert(isValid(s))
      assert(isValid01(s))
    }

    it("case false 01") {
      val s = "(]"
      assert(!isValid(s))
      assert(!isValid01(s))
    }

    it("case false 02") {
      val s = "([)]"
      assert(!isValid(s))
      assert(!isValid01(s))
    }

    it("case false 03") {
      val s = "(("
      assert(!isValid(s))
      assert(!isValid01(s))
    }

    it("case false 04") {
      val s = "]"
      assert(!isValid(s))
      assert(!isValid01(s))
    }

    it("case false 05") {
      val s = "]{"
      assert(!isValid(s))
      assert(!isValid01(s))
    }

  }

}
