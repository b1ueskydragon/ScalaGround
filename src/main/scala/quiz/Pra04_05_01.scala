package quiz

// リスト x1, x2, …, xn に対して x1 - x2 - … - xn を求める.
object Pra04_05_01 {
  def main(args: Array[String]): Unit = {
    val smp = List(3, 1, 4)
    println(progression(smp))
    println(progressionFor(smp))

    // arranges
    println(arrange(smp))
    println(arrange01(smp))
  }

  // a - b - c
  def progression(nums: List[Int]): Int = nums.reduceLeft(_ - _)

  def progressionFor(nums: List[Int]): Int = {
    var res = nums.head
    for (idx <- 1 until nums.length) {
      res -= nums(idx)
    }
    res
  }

  //  a - ( b - c)
  def arrange(nums: List[Int]): Int = nums.reduceRight(_ - _)

  // a - a - b - c
  def arrange01(nums: List[Int]): Int = nums.foldLeft(nums.head)(_ - _)
}
