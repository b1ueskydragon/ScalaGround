package graffiti.hanois

import graffiti.hanois.Hanoi.{hanoi, hanoiList}
import org.scalatest.FunSpec

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

  describe("hanoiList") {
    it("returns an list that appended in order H(n-1), H(1), H(n-1)") {
      val disks = 3
      val expected = List(
        "left -> middle",
        "left -> right",
        "middle -> right",
        "left -> middle",
        "right -> left",
        "right -> middle",
        "left -> middle"
      )
      assert(hanoiList(disks, "left", "middle", "right") === expected)
    }
  }

}
