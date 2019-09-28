package graffiti

import org.scalatest.FunSpec

class CartesianProductSpec extends FunSpec {

  describe("Recursive cartesian product") {

    describe("base case") {

      it("return Empty while given is Empty") {
        assert(Nil === CartesianProduct.Recursive.product(Nil))
        assert(Nil === CartesianProduct.Recursive.productFor(Nil))
      }

      it("return list of list-wrapped flatten elements while given has only a single element") {
        val given = List(List('a, 'b, 'c))
        val expected = List(List('a), List('b), List('c))
        assert(expected === CartesianProduct.Recursive.product(given))
        assert(expected === CartesianProduct.Recursive.productFor(given))
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
        assert(expected === CartesianProduct.Recursive.product(given))
        assert(expected === CartesianProduct.Recursive.productFor(given))
      }

    }

  }


  describe("Non-Recursive cartesian product") {

    it("return a product by reusing exists accumulated results") {
      val given = List(List('a, 'b, 'c), List(1, 2, 3))
      val expected = List(
        List('a, 1), List('a, 2), List('a, 3),
        List('b, 1), List('b, 2), List('b, 3),
        List('c, 1), List('c, 2), List('c, 3)
      )
      assert(expected === CartesianProduct.NonRecursive.product(given))
    }

    it("return a list of Empty while given is Empty") {
      assert(List(Nil) === CartesianProduct.NonRecursive.product(Nil))
    }

    it("return a product by concat to Nil while given has only a single element") {
      val given = List(List('a, 'b, 'c))
      val expected = List(List('a), List('b), List('c))
      assert(expected === CartesianProduct.NonRecursive.product(given))
    }

    it("Here is a pair of list that only accept two elements") {
      val a = List('y, 'Y)
      val b = List('z, 'Z)
      val expected = List(('y, 'z), ('y, 'Z), ('Y, 'z), ('Y, 'Z))
      assert(expected === CartesianProduct.NonRecursive.product2(a, b))
    }

  }

}
