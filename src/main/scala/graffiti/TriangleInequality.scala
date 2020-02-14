package graffiti

object TriangleInequality {

  private def sum(l: Int*) = l.sum

  private def max(l: Int*) = l.foldLeft(0)((res, x) => if (res > x) res else x)

  // x, y, z | if z is max | x + y > z
  private def isTriangle(x: Int, y: Int, z: Int) = sum(x, y, z) > 2 * max(x, y, z)

  def main(args: Array[String]): Unit = {
    assert(isTriangle(1, 1, 1))
    assert(isTriangle(3, 5, 4))
    assert(isTriangle(2, 2, 2))
    assert(isTriangle(6, 8, 7))
    assert(!isTriangle(2, 10, 2))
    assert(!isTriangle(1, 3, 2))
    assert(!isTriangle(8, 4, 4))
    assert(!isTriangle(100, 10, 10))
  }

}
