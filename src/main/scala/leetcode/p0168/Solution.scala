package leetcode.p0168

object Solution {
  def convertToTitle(columnNumber: Int): String = {
    @scala.annotation.tailrec
    def rec(columnNumber: Int, base: String): String = {
      if (columnNumber == 0) {
        return base
      }
      rec((columnNumber - 1) / 26, s"${((columnNumber - 1) % 26 + 65).toChar}$base")
    }

    rec(columnNumber, "")
  }
}
