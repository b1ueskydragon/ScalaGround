package leetcode.p0200

object Solution {
  def numIslands(grid: Array[Array[Char]]): Int = {
    if (grid.isEmpty) return 0

    val rowDim = grid.length
    val colDim = grid(0).length

    def visit(grid: Array[Array[Char]], row: Int, col: Int) {
      // exit case
      if (row < 0 || col < 0 || row >= rowDim || col >= colDim) return
      // only goes deeper when the spot is '1'
      if (grid(row)(col) != '1') return

      grid(row)(col) = '-' // visited
      visit(grid, row + 1, col) // right
      visit(grid, row, col - 1) //down
      visit(grid, row - 1, col) // left
      visit(grid, row, col + 1) // up
    }

    var count = 0
    grid.zipWithIndex.foreach(x => {
      val rowNum = x._2
      x._1.zipWithIndex.foreach(y => {
        val colNum = y._2
        if (grid(rowNum)(colNum) == '1') {
          visit(grid, rowNum, colNum)
          count += 1
        }
      })
    })

    count

  }
}
