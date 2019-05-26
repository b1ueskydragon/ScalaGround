package leetcode.p0997

object Solution {

  def findJudge(N: Int, trust: Array[Array[Int]]): Int = trust.transpose match {
    case Array() => 1
    case tA => (1 + N) * N / 2 - tA.head.toSet.sum match { // diff
      case judge if tA.last.count(_ == judge) == N - 1 => judge
      case _ => -1
    }
  }

  def findJudge_(N: Int, trust: Array[Array[Int]]): Int =
    trust.map(_ (0)).distinct match {
      case citizen if citizen.length == N - 1 =>
        (1 + N) * N / 2 - citizen.sum match { // diff
          case judge if trust.count(_ (1) == judge) == N - 1 => judge
          case _ => -1
        }
      case _ => -1
    }
  
}
