package graffiti

object FlatMapPra {
  def main(args: Array[String]): Unit = {

    val z = List.range(1, 3) flatMap {
      i =>
        List(i) map {
          j => j * 2
        }
    }

    val y = List.range(1, 3) flatMap {
      i => List(i * 2)
    }

    println(z)
    println(y)

    val a =
      List.range(1, 5) flatMap {
        i =>
          List.range(1, i) map {
            j => (i, j)
          }
      }

    val b =
      for {
        i <- List.range(1, 5) // flatMap
        j <- List.range(1, i) // map
      } yield (i, j)

    println(a)
    println(b)


    val c =
      for {
        a <- List.range(1, 4)
        b <- List.range(1, 4)
        c <- List.range(1, 4) // もっとも変化が早い
      } yield (a, b, c)

    println(c)
  }

  // 複数のジェネレータ(p <- e) がある場合,
  // 最後のジェネレータが map, それ以外が flatMap に展開
}
