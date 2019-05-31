package puzzle.sumNWithoutMultipleFive

object Solve {

  def sumNWithoutMultipleFive(n: Int): Int = (1 to n).filter(_ % 5 != 0).sum

  /** sum N                               = (n + 1) * n / 2
    *
    * count of multiple of fives (k)      = n / 5
    *
    * sum of multiple of fives            = 5 + 10 + 15 ... + (k * 5)
    * bind by five                        = 5 * (1 + 2 + 3 ... + k)
    * it could be                         = 5 * ((1 + k) * k / 2)
    * k represented by n / 5              = 5 * ((1 + (n / 5)) * (n / 5) / 2)
    *
    * sum N - sum multiple of fives fives = (n + 1) * n / 2 - 5 * ((1 + (n / 5)) * (n / 5) / 2)
    *
    * @param n N
    */
  def sumNWithoutMultipleFive_(n: Int): Int = (1 + n) * n / 2 - (1 + n / 5) * 5 * (n / 5) / 2

}
