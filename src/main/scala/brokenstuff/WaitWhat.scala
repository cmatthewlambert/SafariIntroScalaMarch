package brokenstuff

object WaitWhat {
  def wrapThis[T](x: => T): Unit = {
    try {
      lazy val xVal = x
      if (math.random() > 0.5) {
        println(s"the value of x is $xVal")
        println(s"the value of x is $xVal")
        println(s"the value of x is $xVal")
      } else println("Can't be bothered...")
    } catch {
      case x: Throwable => println("That blew up!")
    }
  }

  def main(args: Array[String]): Unit = {
    wrapThis{
      if (math.random() > 0.5) throw new IllegalArgumentException
      println("Survived")
      99
    }
    println("done...")
  }

}
