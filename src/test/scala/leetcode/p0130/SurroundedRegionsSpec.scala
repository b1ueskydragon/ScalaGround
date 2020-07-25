package leetcode.p0130

import leetcode.p0130.Solution01.solve
import org.scalatest.FunSpec

class SurroundedRegionsSpec extends FunSpec {

  describe("should find connected points from the edge to keep as it is") {
    it("3 x 3 no derived points from edges") {
      val board = Array(
        Array('X', 'X', 'X'),
        Array('X', 'O', 'X'),
        Array('X', 'X', 'X')
      )

      val after = Array(
        Array('X', 'X', 'X'),
        Array('X', 'X', 'X'),
        Array('X', 'X', 'X')
      )
      solve(board) // in-place
      assert(board === after)
    }

    it("4 x 4 connected case") {
      val board = Array(
        Array('X', 'X', 'X', 'X'),
        Array('X', 'X', 'O', 'X'),
        Array('X', 'X', 'O', 'X'),
        Array('X', 'O', 'O', 'O')
      )

      val before = board

      solve(board) // in-place
      assert(board === before)
    }

    it("5 x 5 complicated case") {
      val board = Array(
        Array('O', 'X', 'X', 'O', 'X'),
        Array('X', 'O', 'O', 'X', 'O'),
        Array('X', 'O', 'X', 'O', 'X'),
        Array('O', 'X', 'O', 'O', 'O'),
        Array('X', 'X', 'O', 'X', 'O')
      )

      val after = Array(
        Array('O', 'X', 'X', 'O', 'X'),
        Array('X', 'X', 'X', 'X', 'O'),
        Array('X', 'X', 'X', 'O', 'X'),
        Array('O', 'X', 'O', 'O', 'O'),
        Array('X', 'X', 'O', 'X', 'O')
      )

      solve(board) // in-place
      assert(board === after)
    }
  }

}
