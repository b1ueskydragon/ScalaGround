package leetcode.p0130

import scala.collection.immutable.Queue

object Solution01 {
  def solve(board: Array[Array[Char]]): Unit = {
    if (board.isEmpty) return

    val R = board.length
    val C = board(0).length

    // At first, put Edges into the queue (to start from the edge to find edge-connected zone).
    @scala.annotation.tailrec
    def enqueue(edges: Seq[(Int, Int)], q: Queue[(Int, Int)]): Queue[(Int, Int)] =
      if (edges.isEmpty) q
      else enqueue(edges.tail, q.enqueue(edges.head))

    val colEdges = (0 until R).flatMap(r => List(0, C - 1).map(c => (r, c)))
    val rowEdges = (0 until C).flatMap(c => List(0, R - 1).map(r => (r, c)))
    val startPoints = (colEdges ++: rowEdges).filter {
      case (x, y) => board(x)(y) == 'O'
    }
    val initQueue = enqueue(startPoints, Queue())

    val directions = List((0, 1), (1, 0), (0, -1), (-1, 0))

    @scala.annotation.tailrec
    def visit(queue: Queue[(Int, Int)]): Unit = {
      if (queue.isEmpty) return
      val ((x, y), rem) = queue.dequeue

      board(x)(y) = '#'

      // All children are derived from the valid edge point.
      val children = directions.map {
        case (dx, dy) => (x + dx, y + dy)
      }.filter {
        case (r, c) =>
          r >= 0 && c >= 0 && r < R && c < C && board(r)(c) == 'O' // 'O' derived from the edge.
      }

      children.foreach {
        // visited
        case (r, c) => board(r)(c) = '#'
      }

      // Append child if only parent is valid.
      visit(rem.enqueue(children))
    }

    visit(initQueue)

    for {
      r <- 0 until R
      c <- 0 until C
    } yield {
      if (board(r)(c) == '#') board(r)(c) = 'O'
      else board(r)(c) = 'X'
    }
  }
}
