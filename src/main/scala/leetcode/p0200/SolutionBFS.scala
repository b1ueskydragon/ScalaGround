package leetcode.p0200


import scala.collection.immutable.Queue

object SolutionBFS {
  def numIslands(grid: Array[Array[Char]]): Int = {
    if (grid.isEmpty) return 0

    val rowDim = grid.length
    val colDim = grid(0).length

    // right, down, left, up
    def distance = List((0, 1), (1, 0), (0, -1), (-1, 0))

    @scala.annotation.tailrec
    def visit(queue: Queue[(Int, Int)]) {
      if (queue.isEmpty) return
      val ((row, col), rem) = queue.dequeue // head is parent

      val children = distance.map {
        case (dr, dc) => (row + dr, col + dc)
      }.filter {
        case (r, c) =>
          r >= 0 && c >= 0 && r < rowDim && c < colDim && grid(r)(c) == '1'
      }
      children.foreach {
        case (r, c) => grid(r)(c) = '-' // visited
      }

      visit(rem.enqueue(children))
    }

    (for {
      sx <- 0 until rowDim
      sy <- 0 until colDim
      if grid(sx)(sy) == '1'
    } yield {
      visit(Queue((sx, sy)))
      1
    }).sum
  }
}
