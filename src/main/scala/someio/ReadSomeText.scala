package someio

import scala.io.Source
import scala.util.{Failure, Success, Try}

object ReadSomeText {
  def main(args: Array[String]): Unit = {
    val iter = Try {
      Source.fromFile("DataX.txt")
    } match {
      case Success(s) => s.getLines()
      case Failure(t) => {
        println("That broke, no file")
        Iterator("NOTHING")
      }
    }

    while (iter.hasNext) {
      println(s"> ${iter.next}")
    }
  }
}
