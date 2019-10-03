package graffiti

import org.scalatest.FunSpec

class CartesianProductSpec extends FunSpec {

  describe("Recursive cartesian product") {

    describe("product and productFor") {

      describe("base case") {

        it("return Empty while given is Empty") {
          assert(CartesianProduct.Recursive.product(Nil) === Nil)
          assert(CartesianProduct.Recursive.productFor(Nil) === Nil)
        }

        it("return list of list-wrapped flatten elements while given has only a single element") {
          val given = List(List('a, 'b, 'c))
          val expected = List(List('a), List('b), List('c))
          assert(CartesianProduct.Recursive.product(given) === expected)
          assert(CartesianProduct.Recursive.productFor(given) === expected)
        }

      }

      describe("standard case") {

        it("return a product by concat recursively while given has more than one elements") {
          val given = List(List('a, 'b, 'c), List(1, 2, 3))
          val expected = List(
            List('a, 1), List('a, 2), List('a, 3),
            List('b, 1), List('b, 2), List('b, 3),
            List('c, 1), List('c, 2), List('c, 3)
          )
          assert(CartesianProduct.Recursive.product(given) === expected)
          assert(CartesianProduct.Recursive.productFor(given) === expected)
        }

      }

    }

    describe("productMerge") {

      describe("Left join like") {

        it("returns a pair of list with merge") {
          val given = List(
            List(List('a, 'b), List('a, 'B), List('A, 'b), List('A, 'B)),
            List('c, 'C)
          )
          val expected = List(
            List(List('a, 'b), 'c),
            List(List('a, 'b), 'C),
            List(List('a, 'B), 'c),
            List(List('a, 'B), 'C),
            List(List('A, 'b), 'c),
            List(List('A, 'b), 'C),
            List(List('A, 'B), 'c),
            List(List('A, 'B), 'C))
          assert(CartesianProduct.Recursive.productMerge(given) === expected)
        }

      }

    }

  }

  describe("Non-Recursive cartesian product") {

    describe("product") {

      it("return a product by reusing exists accumulated results") {
        val given = List(List('a, 'b, 'c), List(1, 2, 3))
        val expected = List(
          List('a, 1), List('a, 2), List('a, 3),
          List('b, 1), List('b, 2), List('b, 3),
          List('c, 1), List('c, 2), List('c, 3)
        )
        assert(CartesianProduct.NonRecursive.product(given) === expected)
      }

      it("return a list of Empty while given is Empty") {
        assert(List(Nil) === CartesianProduct.NonRecursive.product(Nil))
      }

      it("return a product by concat to Nil while given has only a single element") {
        val given = List(List('a, 'b, 'c))
        val expected = List(List('a), List('b), List('c))
        assert(CartesianProduct.NonRecursive.product(given) === expected)
      }

    }

    describe("product2") {

      describe("generate pairs linearly") {

        it("return a pair of list that only accept two elements") {
          val a = List(('a, 'b), ('a, 'B), ('A, 'b), ('A, 'B))
          val b = List('c, 'C)
          val expected = List(
            (('a, 'b), 'c),
            (('a, 'b), 'C),
            (('a, 'B), 'c),
            (('a, 'B), 'C),
            (('A, 'b), 'c),
            (('A, 'b), 'C),
            (('A, 'B), 'c),
            (('A, 'B), 'C)
          )
          assert(CartesianProduct.NonRecursive.product2(a, b) === expected)
        }

      }

    }

  }

}
