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
    val initQueue = enqueue(colEdges ++: rowEdges, Queue())

    val directions = List((0, 1), (1, 0), (0, -1), (-1, 0))

    @scala.annotation.tailrec
    def visit(queue: Queue[(Int, Int)]): Unit = {
      if (queue.isEmpty) return
      val ((x, y), rem) = queue.dequeue
      // Append child if only parent is valid.
      if (x >= 0 && y >= 0 && x < R && y < C && board(x)(y) == 'O') {
        board(x)(y) = '#' // 'O' derived from edge.
        // All children are derived from the valid edge point.
        visit(rem.enqueue(directions.map { case (dx, dy) => (x + dx, y + dy) }))
      } else visit(rem) // if not valid, just pop.
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
