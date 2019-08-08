package graffiti.binarySearch.orderAgnostic

import org.scalatest.FunSpec
import graffiti.binarySearch.orderAgnostic.Solution._

class SolutionSpec extends FunSpec {

  val maxAvailable: Int = (Runtime.getRuntime.freeMemory.toInt << 3) + 500000000

  describe("searchKeyIndexFromSortedArray") {

    it("returns proper index of key if it exits in ascent order") {
      val step = 3
      val ary = Range(0, maxAvailable / step, step).toArray
      val key = 4194303
      val expected = 1398101
      assert(expected === searchKeyIndexFromSortedArray(ary, key))
    }

  }

}
