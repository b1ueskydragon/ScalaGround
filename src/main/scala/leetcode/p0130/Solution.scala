package leetcode.p0130

import scala.collection.immutable.Queue

object Solution {
  def solve(board: Array[Array[Char]]): Unit = {
    if (board.isEmpty) return

    val R = board.length
    val C = board(0).length
    val directions = List((0, 1), (1, 0), (0, -1), (-1, 0))
    val visited = Array.fill(R, C)(false)

    @scala.annotation.tailrec
    def visitFrom(queue: Queue[(Int, Int)], connected: Set[(Int, Int)]) {
      if (queue.isEmpty) {
        if (!connected.exists { case (r, c) => r == 0 || c == 0 || r == R - 1 || c == C - 1 })
          connected.foreach { case (r, c) => board(r)(c) = 'X' }
        return
      }
      val ((x, y), rem) = queue.dequeue
      val children = directions.map { case (dx, dy) => (x + dx, y + dy) }
        .filter { case (r, c) => r >= 0 && c >= 0 && r < R && c < C && !visited(r)(c) && board(r)(c) == 'O' }
      children.foreach { case (r, c) =>
        visited(r)(c) = true
      }
      visitFrom(rem.enqueue(children), connected ++ children.toSet)
    }

    for {
      r <- 0 until R
      c <- 0 until C
      if !visited(r)(c) && board(r)(c) == 'O' && !(r == 0 || c == 0 || r == R - 1 || c == C - 1)
    } yield {
      visitFrom(Queue((r, c)), Set((r, c))) // look all valid path from the start r, c at first.
    }
  }
}
