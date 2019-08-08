package graffiti.binarySearch.orderAgnostic

object Solution {
  def searchKeyIndexFromSortedArray(ary: Array[Int], key: Int): Int = {
    @scala.annotation.tailrec
    def search(low: Int, high: Int, as: Array[Int]): Option[Int] = {
      if (low > high) return None

      val middle = low + (high - low) / 2
      val midVal = as(middle)
      if (midVal == key) Some(middle) else if (midVal > key) search(low, middle - 1, as) else search(middle + 1, high, as)
    }

    search(0, ary.length - 1, ary).getOrElse(-1)
  }

}
