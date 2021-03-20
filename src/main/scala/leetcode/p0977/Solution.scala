package leetcode.p0977

object Solution {
  // nums are sorted asc
  def sortedSquares(nums: Array[Int]): Array[Int] = nums match {
    case ary if ary.head >= 0 => ary.map(x => x * x).toArray
    case ary if ary.last < 0 => ary.reverseMap(x => x * x).toArray
    case ary =>
      @scala.annotation.tailrec
      def merge(xs: List[Int], ys: List[Int], merged: List[Int]): List[Int] = {
        (xs, ys) match {
          case (x :: xt, y :: _) if x > y => merge(xt, ys, x :: merged)
          case (_, y :: yt) => merge(xs, yt, y :: merged) // includes xs == Nil case
          case (x :: xt, Nil) => merge(xt, Nil, x :: merged)
          case _ => merged
        }
      }

      val xs = ary.takeWhile(_ < 0).map(x => x * x) // xs are sorted desc
      val ys = ary.dropWhile(_ < 0).reverseMap(x => x * x) // ys are sorted desc

      merge(xs.toList, ys.toList, List.empty[Int]).toArray
  }
}
