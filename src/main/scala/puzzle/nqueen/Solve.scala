package puzzle.nqueen

object Solve {

  private def inCheck(q1: (Int, Int), q2: (Int, Int)) = {
    q1._1 == q2._1 || // same row
        q1._2 == q2._2 || // same column
        (q1._1 - q2._1).abs == (q1._2 - q2._2).abs // same diagonal
  }

  private def isSafe(queen: (Int, Int), queens: List[(Int, Int)]) =
    queens.forall(q => !inCheck(queen, q))

  /**
    * @param n n queens, n x n board
    * @return List of (row, column)
    */
  def place(n: Int): List[List[(Int, Int)]] = {
    /** functional thinking
      * queens in 1 to k-1 are placed correctly already.
      *
      * @param k current row (k < n)
      * @return
      */
    def _place(k: Int): List[List[(Int, Int)]] = {
      if (k == 0) return List(List()) // bottom of the stack (exit case)

      for { // standard case
        queens <- _place(k - 1)
        column <- 1 to n
        queen = (k, column)

        if isSafe(queen, queens)
      } yield queen :: queens
    }

    _place(n)
  }

  def main(args: Array[String]): Unit = {
    println(place(4))
  }

}
