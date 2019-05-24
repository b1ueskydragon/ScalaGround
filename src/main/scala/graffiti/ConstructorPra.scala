package graffiti

/**
  * コンストラクタの引数について
  *
  * @param a none: private
  * @param b val: read only
  * @param c var: r/w
  */
class ConTest(a: Int, val b: Int, var c: Int) {
  def getA = a
}

object Constructorrrr {
  def main(args: Array[String]): Unit = {
    val conTest = new ConTest(111, 222, 333)

    /* READ */
    // conTest.a // cannot resolve symbol a
    println(conTest.b)
    println(conTest.c)

    /* RE-WRITE */
    // conTest.b = 444
    conTest.c = 555
    println(conTest.c)
  }
}
