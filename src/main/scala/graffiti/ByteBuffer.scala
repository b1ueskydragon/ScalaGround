package graffiti

/** @see https://en.wikipedia.org/wiki/2,147,483,647 */
object ByteBuffer {
  /** TODO:
    * put this in 4byte(size of unsigned int) buffer with consider size constraint.
    * 4byte buffer max value == 2 ^ 31
    * unsigned int max value == 2 ^ 32
    *
    * @param value value < 0 is not considerate.
    * @return converted numeric value that before overflowing.
    */
  def toUnsignedInt(value: Option[Long]): Option[Long] = value.map(v => Math.abs(0xffffffffL & v))
}
