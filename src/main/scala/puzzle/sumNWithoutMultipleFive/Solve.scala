package puzzle.sumNWithoutMultipleFive

object Solve {

  def sumNWithoutMultipleFive(n: Int): Int = (1 to n).filter(_ % 5 != 0).sum

  def sumNWithoutMultipleFive_(n: Int): Int = (1 + n) * n / 2 - (1 + n / 5) * 5 * (n / 5) / 2

}
