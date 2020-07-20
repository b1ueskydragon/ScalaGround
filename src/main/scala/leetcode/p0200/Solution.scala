package leetcode.p0200

object Solution {
  def numIslands(grid: Array[Array[Char]]): Int = {
    if (grid.isEmpty) return 0
    val rowDim = grid.length
    val colDim = grid(0).length

    val distance = List((0, 1), (1, 0), (0, -1), (-1, 0))

    def visit(row: Int, col: Int): Int =
      if ((row < 0 || col < 0 || row >= rowDim || col >= colDim) || grid(row)(col) != '1') 0
      else {
        distance.foreach { case (dx, dy) =>
          grid(row)(col) = '-'
          visit(row + dx, col + dy)
        }
        1
      }

    (for {
      row <- 0 until rowDim
      col <- 0 until colDim
      if grid(row)(col) == '1'
    } yield {
      visit(row, col)
    }).sum
  }
}
