package leetcode.p0200

object Solution {
  def numIslands(grid: Array[Array[Char]]): Int = {
    if (grid.isEmpty) return 0
    val rowDim = grid.length
    val colDim = grid(0).length

    def visit(grid: Array[Array[Char]], row: Int, col: Int) {
      // exit cases, and only goes deeper when the spot is '1'.
      if ((row < 0 || col < 0 || row >= rowDim || col >= colDim)
        || grid(row)(col) != '1') return

      grid(row)(col) = '-' // visited
      visit(grid, row + 1, col) // right
      visit(grid, row, col - 1) //down
      visit(grid, row - 1, col) // left
      visit(grid, row, col + 1) // up
    }

    (for {
      row <- 0 until rowDim
      col <- 0 until colDim
      if grid(row)(col) == '1'
    } yield {
      visit(grid, row, col)
      1
    }).sum
  }
}
