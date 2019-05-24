package quiz

object Pra06_01 {
  def main(args: Array[String]): Unit = {
    // 変数 primes に100以下の素数の集合を代入せよ.
    val primes = (2 to 100).filter(isPrime).toSet
    println(primes)

    // 100以下の2つの素数の和で表せる数の集合を変数 primes2 に代入せよ.
    val primes2 = for (i <- primes; j <- primes) yield i + j
    val primes2_ = primes.flatMap(i => primes.map(j => i + j))
    println(primes2)

    // 100以下の偶数で，2つの素数の和で表せない数の集合を求めよ．
    val res = (2 to 100 by 2).toSet.filterNot(primes2)
    val res_ = (2 to 100 by 2).toSet diff primes2
    println(res)
  }

  private def isPrime(n: Int) = (2 to math.sqrt(n).toInt).forall(n % _ != 0)
}
