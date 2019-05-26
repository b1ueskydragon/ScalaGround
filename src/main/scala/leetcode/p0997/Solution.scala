package leetcode.p0997

object Solution {

  def findJudge(N: Int, trust: Array[Array[Int]]): Int = trust.transpose match {
    case Array() => 1
    case tA => tA.last.toSet diff tA.head.toSet match {
      case group if group.size == 1 && tA.last.count(_ == group.head) == N - 1 => group.head
      case _ => -1
    }
  }
}
