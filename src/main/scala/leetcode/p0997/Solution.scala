package leetcode.p0997

object Solution {

  def findJudge(N: Int, trust: Array[Array[Int]]): Int = trust.transpose match {
    case Array() => 1
    case tA => (1 + N) * N / 2 - tA.head.toSet.sum match {
      case judge if tA.last.count(_ == judge) == N - 1 => judge
      case _ => -1
    }
  }

}
