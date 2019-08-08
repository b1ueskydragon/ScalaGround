package graffiti.binarySearch.orderAgnostic

object Solution {
  def searchKeyIndexFromSortedArray(ary: Array[Int], key: Int): Int = {
    @scala.annotation.tailrec
    def search(low: Int, high: Int, as: Array[Int]): Int = {
      val middle = low + (high - low) / 2
      val midVal = as(middle)
      if (midVal == key) middle else if (midVal > key) search(low, middle - 1, as) else search(middle + 1, high, as)
    }

    search(0, ary.length - 1, ary)
  }

}
