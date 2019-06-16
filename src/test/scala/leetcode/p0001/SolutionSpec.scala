package leetcode.p0001

import leetcode.p0001.Solution._
import org.scalatest.{FunSpec, Matchers}

class SolutionSpec extends FunSpec with Matchers {

  describe("twoSum") {

    it("return indices of the two numbers such that they add up to a specific target") {
      val nums = Array(2, 7, 11, 15)
      val target = 9
      val expected = Array(0, 1)
      assert(expected === twoSum(nums, target))
    }

    it("should return if negate included") {
      val nums = Array(7, 11, 15, -2)
      val target = 9
      val expected = Array(1, 3)
      assert(expected === twoSum(nums, target))
    }

    it("should return if nums contains a half value of target") {
      val nums = Array(3, 2, 4)
      val target = 6
      val expected = Array(1, 2)
      assert(expected === twoSum(nums, target))
    }

    it("should return if nums only contains a half value of target") {
      val nums = Array(0, 3, 3)
      val target = 6
      val expected = Array(1, 2)
      assert(expected === twoSum(nums, target))
    }

  }

}
