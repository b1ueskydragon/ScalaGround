package leetcode.p0997

object Solution {

  def findJudge(N: Int, trust: Array[Array[Int]]): Int = trust.transpose match {
    case Array() => 1
    case tA => (1 + N) * N / 2 - tA(0).toSet.sum match { // diff
      case judge if tA(1).count(_ == judge) == N - 1 => judge
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

  def findJudge__(N: Int, trust: Array[Array[Int]]): Int = {
    val citizen = trust.groupBy(_ (0)).mapValues(_.length)
    val trusted = trust.groupBy(_ (1)).mapValues(_.length)

    //(for {
    //  i <- 1 to N
    //  if citizen.getOrElse(i, 0) == 0 && trusted.getOrElse(i, 0) == N - 1
    //} yield i).headOption.getOrElse(-1)
    
    (1 to N).find(i => citizen.getOrElse(i, 0) == 0 && trusted.getOrElse(i, 0) == N - 1).getOrElse(-1)
  }

}
