package graffiti

import org.scalatest.FunSpec
import graffiti.Hanoi.hanoi

class HanoiSpec extends FunSpec {

  describe("hanoi") {

    it("returns an list that buffed correct order of moving") {
      val disks = 3
      val expected = Array(
        "left -> middle",
        "left -> right",
        "middle -> right",
        "left -> middle",
        "right -> left",
        "right -> middle",
        "left -> middle"
      )
      assert(hanoi(disks) === expected)
    }

  }

}
