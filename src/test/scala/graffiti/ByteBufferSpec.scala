package graffiti

import graffiti.ByteBuffer.toUnsignedInt
import org.scalatest.FunSpec

class ByteBufferSpec extends FunSpec {

  describe("toBinaryString and length of digits") {
    it("`4294967295` has bit more than `Int.MaxValue`") {
      val maxValueOfUnsignedInt = 4294967295L // cannot be expressed in Int (32 bit).
      assert(maxValueOfUnsignedInt.toBinaryString === "11111111111111111111111111111111")
      assert(Int.MaxValue.toBinaryString === "1111111111111111111111111111111")

      assert(maxValueOfUnsignedInt.toBinaryString.length === 32)
      assert(Int.MaxValue.toBinaryString.length === 31)
    }

    it("Integer flag `9018` could be expressed in 14 digits") {
      val flag = Integer.toBinaryString(9018)
      assert(flag.length === 14)
      assert(flag === "10001100111010")
    }
  }

  describe("toUnsignedInt") {
    it("should convert numeric value to before overflowing") {
      val valueNeg = Some(-1L)

      // cannot be expressed in Int (32 bit).
      val maxValueOfUnsignedInt = Int.MaxValue * 2L + 1L

      assert(maxValueOfUnsignedInt === 4294967295L)
      assert(toUnsignedInt(valueNeg).get === maxValueOfUnsignedInt)
    }

    it("should not consider the value which is overflowed from unsigned int") {
      // `Int.MaxValue * 2 + 3` could be expressed in `1`
      val valuePos = Some(1L)

      // cannot be expressed in Int (32 bit).
      val overflowedFromUnsignedInt = Int.MaxValue * 2L + 3L

      assert(overflowedFromUnsignedInt === 4294967297L)
      assert(toUnsignedInt(valuePos).get === 1L)
    }

    it("should return None if value is None") {
      assert(toUnsignedInt(None: Option[Long]) === None)
    }
  }

}
