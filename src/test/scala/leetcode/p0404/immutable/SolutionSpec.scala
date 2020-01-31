package leetcode.p0404.immutable

import org.scalatest.FunSpec

class SolutionSpec extends FunSpec {

  describe("sumOfLeftLeaves") {

    it("should return 0 if root is empty") {
      assert(SumOfLeftLeaves(Empty()) === 0)
    }

    it("should return 0 if root is single node") {
      assert(SumOfLeftLeaves(Leaf(1)) === 0)
    }

    it("should only accumulate leaves those have not children") {

      val root =
        Branch(
          1,
          Branch(
            2,
            Empty(),
            Leaf(4)
          ),
          Branch(
            3,
            Branch(
              5,
              Branch(
                7,
                Leaf(11),
                Empty()
              ),
              Branch(
                8,
                Leaf(12),
                Empty()
              )
            ),
            Branch(
              6,
              Leaf(9),
              Leaf(10)
            )
          )
        )

      assert(SumOfLeftLeaves(root) === 32)
    }

    it("should return a proper value if root has zigzag nodes") {
      val root =
        Branch(
          5,
          Empty(),
          Branch(
            6,
            Branch(
              7,
              Empty(),
              Branch(
                8,
                Leaf(9),
                Empty()
              )
            ),
            Empty()
          ),
        )
      assert(SumOfLeftLeaves(root) === 9)
    }

  }

}
