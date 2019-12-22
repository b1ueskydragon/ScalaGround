package graffiti

import org.scalatest.FunSpec

class CombinationSpec extends FunSpec {

  describe("combination") {

    describe("there is a function") {

      it("returns a pair that does not has a order and also has same order as built-in one") {
        val ts = List('a, 'b, 'c, 'd, 'e, 'f, 'g)
        val k = 2
        assert(Combination.g(ts, Nil) === ts.combinations(k).toList)
      }

    }

    describe("Let's apply it to general cases") {

      it("returns a combination which has same order as built-in function") {
        val ts = List('a, 'b, 'c, 'd, 'e, 'f, 'g)
        val k = 3

        println(Combination.g(ts.tail, Nil)) // debug
        assert(Combination.f(ts, Nil) === ts.combinations(k).toList)
      }

      it("when happens if k is bigger than 3") {
        val ts = List('a, 'b, 'c, 'd, 'e, 'f, 'g)
        val k = 4
        assert(Combination.s(ts, Nil) === ts.combinations(k).toList)
      }

    }

    describe("Continuation Passing Style") {

      it("invokes function continuously to it's tail") {
        val xs = List('a, 'b, 'c)
        val f: List[Symbol] => List[List[Symbol]] = xs => List(xs.reverse)

        val actual = Combination.cps(xs, Nil)(f)
        val expected = List(xs.reverse) ::: List(xs.tail.reverse) ::: List(xs.tail.tail.reverse)
        assert(actual === expected)
      }

      it("generate a tail continuously") {
        val ts = List('a, 'b, 'c, 'd, 'e, 'f, 'g)
        val k = 4
        val actual = Combination.combination(ts, k)
        val expected = ts.combinations(k).toList
        assert(actual === expected)
      }

    }

  }

}
