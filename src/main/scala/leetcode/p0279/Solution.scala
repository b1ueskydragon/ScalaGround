package leetcode.p0279

import scala.collection.immutable.Queue

object Solution {
  def numSquares(n: Int): Int = {
    val edges = (1 to Math.pow(n, 0.5).toInt).map(i => i * i)
    val checked = Array.fill(n + 1)(false)

    // lev0  0
    // lev1  1           4           9 ...
    // lev2  2 5 10..   (5) 8 13..  (10) 13 18 ...
    @scala.annotation.tailrec
    def bfs(queue: Queue[(Int, Int)]): Int = {
      val ((level, parent), rem) = queue.dequeue

      val children = edges.map(_ + parent)
        .filter(leaf => leaf <= n && !checked(leaf))
        .map((level + 1, _))

      children.foreach {
        case (_, leaf) => checked(leaf) = true
      }

      if (children.exists(_._2 == n)) level
      else bfs(rem.enqueue(children))
    }

    if (n == 0) 0 else bfs(Queue((1, 0)))
  }
}
