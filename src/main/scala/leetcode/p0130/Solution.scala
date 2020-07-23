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
    def visitFrom(queue: Queue[(Int, Int)], connected: List[(Int, Int)]): List[(Int, Int)] = {
      if (queue.isEmpty) return connected
      val ((x, y), rem) = queue.dequeue
      val children = directions.map { case (dx, dy) => (x + dx, y + dy) }
        .filter { case (r, c) => r >= 0 && c >= 0 && r < R && c < C && !visited(r)(c) && board(r)(c) == 'O' }
      children.foreach { case (r, c) =>
        visited(r)(c) = true
      }
      visitFrom(rem.enqueue(children), connected ::: children)
    }

    for {
      r <- 0 until R
      c <- 0 until C
      if !visited(r)(c) && board(r)(c) == 'O'
    } yield {
      val res = visitFrom(Queue((r, c)), List((r, c))) // look all valid path from the start r, c at first.
      if (!res.exists { case (x, y) => x == 0 || y == 0 || x == R - 1 || y == C - 1 }) {
        res.foreach {
          case (i, j) => board(i)(j) = 'X'
        }
      }
    }
  }
}
