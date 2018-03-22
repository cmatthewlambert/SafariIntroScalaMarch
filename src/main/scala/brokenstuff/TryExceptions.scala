package brokenstuff

import java.io.FileNotFoundException
import java.sql.SQLException

object TryExceptions {
  def main(args: Array[String]): Unit = {
    try {
      if (math.random() > 0.5) {
        throw new SQLException("Haha, that broke!")
      } else {
        throw new FileNotFoundException("Where is it?")
      }
    } catch {
      case x: SQLException => println(s"Caught an SQL exception ${x.getMessage}")
      case x: FileNotFoundException => println(s"Caught a FileNotFound exception ${x.getMessage}")
    }
  }
}
