package leetcode.p0279

object Solution {
  def numSquares(n: Int): Int = {
    val edges = (1 to Math.pow(n, 0.5).toInt).map(i => i * i)

    // lev0  0
    // lev1  1           4           9 ...
    // lev2  1 5 10..   (5) 8 13..  (10) 13 18 ...
    @scala.annotation.tailrec
    def bfs(level: Int, parents: Set[Int]): Int = {
      val children = parents.flatMap { parent =>
        edges.map(_ + parent).filter(_ <= n)
      }
      if (children.contains(n)) level
      else bfs(level + 1, parents ++ children)
    }

    if (n == 0) 0 else bfs(1, Set(0))
  }
}
