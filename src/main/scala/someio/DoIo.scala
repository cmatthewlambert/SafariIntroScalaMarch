package handystuff {

  object Implicits {
    implicit val banana: String = "Extra brown sugar";
  }

}

package morestuff {

  object Implicits {
    implicit val sugar = "Granulated white sugar"
  }

}

package someio {

  object DoIo {
    def interesting(implicit x: String): Unit = println(s"(implicit) x is $x")

    def interesting(x: String, y: Int): Unit = println(s"x is $x, y is $y")

    def interesting(x: Int)(y: Int = 33): Unit = println(s"x is $x, y is $y")

    def main(args: Array[String]): Unit = {
      {
        import handystuff.Implicits.banana
        interesting("Fred")
        //      implicit val bananaSplit: String = "Lots of whipped cream"
        interesting
      }

      interesting({
        println("Oh!")
        3
      })()
      interesting {
        println("Really")
        5
      } {
        10
      }

      interesting(y = 23, x = "Hello")

      {
        import morestuff.Implicits.sugar
        interesting
      }
    }
  }

}
