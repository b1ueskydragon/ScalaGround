package graffiti

/**
  * Only for debugging Vector.scala - Trie structure includes array children
  */
object HiVector {
  def main(args: Array[String]): Unit = {
    // TODO: Debug trie process when `append` and `find prefix`
  }

  private def generate() {
    /* Possible range: Vector#gotoPos */

    val myVecty0: Vector[Int] = (0 to 31).toVector // Math.pow(32, 1).toInt == 1 << 5
    val myVecty1: Vector[Int] = (0 to 32).toVector // Math.pow(32, 2).toInt == 1 << 10
    val myVecty2: Vector[Int] = (0 to 1024).toVector // Math.pow(32, 3).toInt == 1 << 15
    val myVecty3: Vector[Int] = (0 to 32768).toVector // Math.pow(32, 4).toInt == 1 << 20
    val myVecty4: Vector[Int] = (0 to 1048576).toVector // Math.pow(32, 5).toInt == 1 << 25

    val myVecty5: Vector[Int] = (0 to 33554432).toVector // Math.pow(32, 6).toInt == 1 << 25

    val myListy5: List[Int] = (0 to 33554432).toList // same as above list ver.

    // Exceed 1 << 30
    val myVecty6: Vector[Int] = (0 to 1073741824).toVector
  }


  private def speed() {
    /* Create node(element) - Vector is faster than List */

    val start = System.currentTimeMillis()
    (1 to 1000).foreach {
      // (0 to 33554432).toList
      (0 to 33554432).toVector
    }
    println(System.currentTimeMillis() - start)
  }
}
