package dailyOne.P88

import java.math.BigInteger

// TODO Refactor to functional
class Division {
  def division(a: BigInteger, b: BigInteger): BigInteger = {
    var q = BigInteger.ZERO
    var sq = BigInteger.ONE
    var tmpa = a
    var tmpb = b
    while (tmpa.compareTo(tmpb) >= 0) {
      tmpb = tmpb.shiftLeft(1)
      if (tmpa.compareTo(tmpb) >= 0) {
        sq = sq.shiftLeft(1)
      } else {
        tmpb = tmpb.shiftRight(1)
        tmpa = tmpa.subtract(tmpb)
        q = q.add(sq)
        sq = BigInteger.ONE
        tmpb = b
      }
    }
    q
  }

  def main(args: Array[String]): Unit = {

    val sc = new java.util.Scanner(System.in)
    val a = sc.nextLine() // 14285699999999857143
    val b = sc.nextLine() // 7
    sc.close()

    val biga = new BigInteger(a)
    val bigb = new BigInteger(b)

    println(division(biga, bigb) == biga.divide(bigb))
  }
}
