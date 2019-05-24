package graffiti

object HelloWorld {
  def main(args: Array[String]): Unit = {
    printargs(Array("Scala", "is", "Fun"))
  }

  def printargs(args: Array[String]): Unit = {
    var i = 0
    while (i < args.length) {
      println(args(i))
      i += 1
    }
  }
}
