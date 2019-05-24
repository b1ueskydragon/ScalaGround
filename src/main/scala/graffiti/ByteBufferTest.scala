package graffiti

/**
  * @see https://en.wikipedia.org/wiki/2,147,483,647
  */
object ByteBufferTest {
  def main(args: Array[String]): Unit = {
    // println("flag:  ", Integer.toBinaryString(9018)) // 14 digits

    // Int.MaxValue * 2 + 1
    // Max value of unsigned int.
    val valueNeg: Option[Long] = Some(-1)

    // Int.MaxValue * 2 + 3
    // Overflowed from unsigned int. Not to consideration.
    val valuePos: Option[Long] = Some(1)

    val valueNone: Option[Long] = None

    println(toUnsignedInt(valueNeg))
    println(toUnsignedInt(valuePos))
    println(toUnsignedInt(valueNone))

    println(4294967295L.toBinaryString)
    println(Int.MaxValue.toBinaryString)
  }

  // value < 0 is not considerate.
  /* TODO: put this in 4byte(size of unsigned int) buffer with consider size constraint.
   *       4byte buffer max value == 2 ^ 31
   *       unsigned int max value == 2 ^ 32
   */
  def toUnsignedInt(value: Option[Long]): Option[Long] = value.map(v => Math.abs(0xffffffffL & v))
}
