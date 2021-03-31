package leetcode.p0062.folding

object Solution {

  def uniquePaths(m: Int, n: Int): Int = {
    // We don't use indices, hence _
    // Initial accumulate is the first row consisting of 1
    (1 until n).foldLeft(List.fill(m)(1)) { (xs, _) =>
      xs match {
        // head could be an init acc
        case h :: tail => tail.scanLeft(h)((acc, itself) => acc + itself)
        case Nil => Nil
      }
    }.last
  }

}
