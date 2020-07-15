
package daily

// Given an array of integers,
// Determine whether it contains a Pythagorean triplet.
// a^2 + b^2 = c^2
object PythagoreanTriplet {

  // three-sum problem
  // O(N^2)
  def hasPytriplet(xs: Array[Int]): Boolean = {
    val xxs = xs.map(x => Math.pow(x, 2).toInt).sorted

    // x    <=  y   <= z
    // A(x) <= A(y) <= A(z)
    // [a, b, c, d, e, f]
    //  x           y  z
    @scala.annotation.tailrec
    def loop(x: Int, y: Int, z: Int): Boolean = {
      if (x >= y) false
      else if (xxs(x) + xxs(y) == xxs(z)) true
      else if (xxs(x) + xxs(y) < xxs(z)) loop(x + 1, y, z)
      else loop(x, y - 1, z)
    }

    val last = xs.length - 1
    (2 to last).reverse.exists(z => loop(0, z - 1, z))
  }
}
