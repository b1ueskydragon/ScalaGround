package leetcode.p0003

import leetcode.p0003.Solution.isPalindrome
import org.scalatest.FunSpec

class IsPalindromeSpec extends FunSpec {

  describe("isPalindrome") {

    it("should return false if x is negative integer") {
      assert(!isPalindrome(-121))
    }

    it("should return false if x is not a palindrome") {
      assert(!isPalindrome(678))
      assert(!isPalindrome(1010))
    }

    it("should return true if x is palindrome") {
      assert(isPalindrome(121))
      assert(isPalindrome(888))
      assert(isPalindrome(1001))
      assert(isPalindrome(98000089))
      assert(isPalindrome(980000089))
    }

  }
}
