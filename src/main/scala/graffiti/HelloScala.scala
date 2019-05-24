package graffiti

object HelloScala {
  def main (args: Array[String]) {
    println(createGreeting(args))
    println(createGreeting(Array("inagon")))
  }
  def createGreeting (args: Array[String]) = {
    args.headOption match {
      case Some(name) => "Hello " + name + " !"
      case None => "Hello Scala !"
    }
  }
}
// 参考 http://yuki-tkd.hateblo.jp/entry/2015/05/17/005007