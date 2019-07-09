package leetcode.p0008

import leetcode.p0008.Solution._
import org.scalatest.FunSpec

class SolutionSpec extends FunSpec {

  describe("myAtoi") {

    it("returns a head integer if string is an sentence that split by whitespace") {
      val str = "4193 with words"
      assert(myAtoi(str) === 4193)
      assert(myAtoi_(str) === 4193)
    }

    it("returns 0 if head of string is not a number") {
      val str = "words and 987"
      assert(myAtoi(str) === 0)
      assert(myAtoi_(str) === 0)
    }

    it("returns 0 if empty string") {
      assert(myAtoi("") === 0)
      assert(myAtoi("  ") === 0)

      assert(myAtoi_("") === 0)
      assert(myAtoi_("  ") === 0)
    }

    it("returns a trimmed integer if string has only whitespace, minus sign and integer") {
      val str = "   -42"
      assert(myAtoi(str) === -42)
      assert(myAtoi_(str) === -42)
    }

    it("returns a min value of integer if number is lower than min value") {
      val str = "-91283472332"
      assert(myAtoi(str) === Int.MinValue)
      assert(myAtoi_(str) === Int.MinValue)
    }

    it("returns 0 if string has valid sign and number at first") {
      val str = "+4-2"
      assert(myAtoi(str) === 4)
      assert(myAtoi_(str) === 4)
    }

    it("returns 0 if string has valid sign but not valid string") {
      val str =  "-+1"
      assert(myAtoi(str) === 0)
      assert(myAtoi_(str) === 0)
    }

    it("returns 0 if string has only a sign") {
      val str = "+"
      assert(myAtoi(str) === 0)
      assert(myAtoi_(str) === 0)
    }

    it("returns a max value of integer if number is even larger than long") {
      val str = "20000000000000000000"
      assert(myAtoi(str) === Int.MaxValue)
      assert(myAtoi_(str) === Int.MaxValue)
    }

  }

}
