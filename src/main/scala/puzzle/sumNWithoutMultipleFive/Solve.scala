package puzzle.sumNWithoutMultipleFive

object Solve {

  def sumNWithoutMultipleFive(n: Int): Int = (1 to n).filter(_ % 5 != 0).sum

  def sumNWithoutMultipleFive_(n: Int): Int = {

    val sum: Int = (1 + n) * n / 2
    val fives: Int = n / 5
    val fivesSum: Int = ((1 + fives) * 5) * (n / 5) / 2

    sum - fivesSum

  }

}
