package brokenstuff

import java.io.FileNotFoundException
import java.sql.SQLException

import scala.util.{Failure, Success, Try}

object TryTry {

  def doStuff: Try[String] = Try(if (math.random() > 0.5) {
    throw new SQLException("Haha, that broke!")
  } else {
    "Hey, it worked"
  })

  def main(args: Array[String]): Unit = {
    val res = doStuff
    println(s"returned is: ${res}")
    res match {
      case Success(x) => println(s"It worked, I got the value $x")
      case Failure(x) => x match {
        case y: SQLException => println(s"It broke and complained that ${x.getMessage}")
        case y: FileNotFoundException => println("Surprise!")
      }
    }
  }
}
