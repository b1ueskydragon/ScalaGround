package leetcode.p0130

import leetcode.p0130.Solution01.solve
import org.scalatest.FunSpec

class SurroundedRegionsSpec extends FunSpec {

  describe("should find connected points from the edge to keep as it is") {
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

}
