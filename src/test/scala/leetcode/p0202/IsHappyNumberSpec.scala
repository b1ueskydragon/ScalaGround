package leetcode.p0202

import leetcode.p0202.Solution.isHappy
import leetcode.p0202.Solution01.{isHappy => isHappyCycle}

import org.scalatest.FunSpec

class IsHappyNumberSpec extends FunSpec {

  describe("isHappy") {

    it("returns true if number is Happy Number") {
      assert(isHappy(31))
      assert(isHappy(9000001))
      assert(isHappy(19))
      assert(isHappy(1))

      assert(isHappyCycle(31))
      assert(isHappyCycle(9000001))
      assert(isHappyCycle(19))
      assert(isHappyCycle(1))
    }

    it("returns false if number is Happy Number") {
      assert(!isHappy(Int.MaxValue))
      assert(!isHappy(0))
      assert(!isHappy(123))
      assert(!isHappy(999999))

      assert(!isHappyCycle(Int.MaxValue))
      assert(!isHappyCycle(0))
      assert(!isHappyCycle(123))
      assert(!isHappyCycle(999999))
    }

  }

}
