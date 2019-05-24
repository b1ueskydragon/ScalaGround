package leetcode.p0832

object Solution {

  def flipAndInvertImage(xs: Array[Array[Int]]): Array[Array[Int]] =
    xs.map { row =>
      row.foldLeft(Array.empty[Int])((acc, x) => (x ^ 1) +: acc)
    }

}
