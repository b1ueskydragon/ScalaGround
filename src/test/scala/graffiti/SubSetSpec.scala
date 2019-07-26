package graffiti

import graffiti.SubSet.generate
import org.scalatest.FunSpec

class SubSetSpec extends FunSpec {

  describe("generate") {

    it("returns 8 subsets in case [a, b, c] with specific order") {
      val expected = List(
        List(),
        List('a),
        List('b),
        List('b, 'a),
        List('c),
        List('c, 'a),
        List('c, 'b),
        List('c, 'b, 'a)
      )
      val actual = generate(List('a, 'b, 'c))
      assert(actual === expected)
    }

  }

}
