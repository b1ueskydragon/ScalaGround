package leetcode.p0720

import leetcode.p0720.Solution._
import org.scalatest.{FunSpec, Matchers}

class SolutionSpec extends FunSpec with Matchers {

  describe("longestWord") {

    it("sample case") {
      val words = Array("w", "wo", "wor", "worl", "world")
      val expected = "world"
      assert(expected === longestWord(words))
    }

    it("smallest lexicographical case") {
      val words = Array("a", "banana", "app", "appl", "ap", "apply", "apple")
      val expected = "apple"
      assert(expected === longestWord(words))
    }

    it("smallest lexicographical in broken prefix case") {
      val words = Array("w", "wor", "world", "wol", "wo")
      val expected = "wol"
      assert(expected === longestWord(words))
    }

  }

}
