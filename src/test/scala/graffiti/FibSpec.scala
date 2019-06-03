package graffiti

import org.scalatest.{FunSpec, Matchers}
import graffiti.Fib._

class FibSpec extends FunSpec with Matchers {

  describe("fib") {

    it("should return 1 when n is 0 or 1") {
      assert(fib(0) === 1)
      assert(fib(1) === 1)

      assert(fibTail(0) === 1)
      assert(fibTail(1) === 1)
    }

    it("should return Fn = Fn-1 + Fn-2 recursively when n > 0") {
      assert(fib(3) === fib(1) + fib(2))
      assert(fib(3) === 3)
    }

    it("should be tail recursion") {
      assert(fib(3) === fibTail(3))
    }

  }

}
