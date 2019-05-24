package graffiti

import java.io.FileNotFoundException
import java.nio.file.{Files, Path, Paths}

import scala.io.Source
import scala.util.Try

class LazyPra {
  lazy val foo = Source.fromFile("./bar.txt").getLines
}

object LazyPraApp {

  private def invokeFoo(lazyPra: LazyPra, fooFile: Path): Try[Iterator[String]] = Try {
    if (Files.exists(fooFile)) Files.delete(fooFile)

    lazyPra.foo // There is no bar.txt yet => exception
  }

  def main(args: Array[String]): Unit = {

    val lazyPra = new LazyPra // Make Class instance at first
    val fooFile = Paths.get("./bar.txt")

    invokeFoo(lazyPra, fooFile).recover({
      case _: FileNotFoundException =>
        Files.createFile(fooFile) // Now I created empty fooFile.

        lazyPra.foo

        println("There it is")
        Files.delete(fooFile)
    })
  }
}
