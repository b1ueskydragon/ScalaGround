package graffiti

import graffiti.SubSet.generate
import org.scalatest.FunSpec

class SubSetSpec extends FunSpec {

  describe("generate") {

    it("returns 8 subsets in case [a, b, c] with specific order") {
      val expected = List(
        List(),
        List('c),
        List('c, 'b),
        List('c, 'b, 'a),
        List('c, 'a),
        List('b),
        List('b, 'a),
        List('a)
      )
      val actual = generate[Symbol](List('a, 'b, 'c))
      assert(actual === expected)
    }

  }

}
