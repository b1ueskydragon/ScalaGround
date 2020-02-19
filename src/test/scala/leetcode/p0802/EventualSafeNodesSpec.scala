package leetcode.p0802

import leetcode.p0802.Solution.eventualSafeNodes
import org.scalatest.FunSpec

class EventualSafeNodesSpec extends FunSpec {

  describe("eventualSafeNodes") {

    describe("has not a cycle") {

      it("only go forwards") {
        val graph = Array(Array(1, 2, 3), Array(2, 3), Array(3), Array.empty[Int])
        val expected = List(0, 1, 2, 3)
        assert(eventualSafeNodes(graph) === expected)
      }

    }

    describe("has a cycle") {

      it("has a cycle node") {
        val graph = Array(Array(1, 2, 3), Array(2, 3), Array(3, 4), Array(4, 5), Array(4), Array.empty[Int])
        val expected = List(5)
        assert(eventualSafeNodes(graph) === expected)
      }

      it("some path has both cycle and terminal") {
        val graph = Array(Array(1, 2, 3), Array(1, 2), Array(3), Array(3, 4), Array.empty[Int])
        val expected = List(4)
        assert(eventualSafeNodes(graph) === expected)
      }

    }

  }

}
