package daily

import org.scalatest.FunSpec
import daily.PythagoreanTriplet.hasPytriplet

class PythagoreanTripletSpec extends FunSpec {

  describe("hasPytriplet") {

    it("should return true if the array includes pythagorean triplet") {
      assert(hasPytriplet(Array(3, 1, 2, 4, 5, 6)))
      assert(hasPytriplet(Array(3, 1, 2, 5, 5, 4, 4)))
    }

    it("should return false if the array doesn't include pythagorean triplet") {
      assert(!hasPytriplet(Array(3, 1, 6, 2, 4)))
      assert(!hasPytriplet(Array(10, 4, 6, 12, 5)))
    }
  }

}
