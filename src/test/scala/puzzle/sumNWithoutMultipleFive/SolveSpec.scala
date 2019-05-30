package puzzle.sumNWithoutMultipleFive

import org.scalatest.{FunSpec, Matchers}
import puzzle.sumNWithoutMultipleFive.Solve._

class SolveSpec extends FunSpec with Matchers {

  describe("sumNWithoutMultipleFive") {

    it("should return sum N without multiple of five") {
      val n = 101

      val linearAdd = sumNWithoutMultipleFive(n)
      val minusFromEntire = sumNWithoutMultipleFive_(n)

      assert(linearAdd === minusFromEntire)
    }

  }

}
