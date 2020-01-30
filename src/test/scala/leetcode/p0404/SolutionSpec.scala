package leetcode.p0404

import leetcode.p0404.Solution.sumOfLeftLeaves
import org.scalatest.FunSpec

class SolutionSpec extends FunSpec {

  describe("sumOfLeftLeaves") {

    it("should return 0 if root is empty") {
      assert(sumOfLeftLeaves(null) === 0)
    }

    it("should return 0 if root is single node") {
      assert(sumOfLeftLeaves(TreeNode(1)) === 0)
    }

    it("should only accumulate leaves those have not children") {
      val root = TreeNode(1)
      root.left = TreeNode(2)
      root.right = TreeNode(3)
      root.left.right = TreeNode(4)
      root.right.left = TreeNode(5)
      root.right.right = TreeNode(6)
      root.right.left.left = TreeNode(7)
      root.right.left.right = TreeNode(8)
      root.right.right.left = TreeNode(9)
      root.right.right.right = TreeNode(10)
      root.right.left.left.left = TreeNode(11)
      root.right.left.right.left = TreeNode(12)
      assert(sumOfLeftLeaves(root) === 32)
    }

    it("should return a proper value if root has zigzag nodes") {
      val root = TreeNode(5)
      root.right = TreeNode(6)
      root.right.left = TreeNode(7)
      root.right.left.right = TreeNode(8)
      root.right.left.right.left = TreeNode(9)

      assert(sumOfLeftLeaves(root) === 9)
    }
    
  }

}
