package hello

// no "public" keyword, public by default
// no "static" keyword, put things in an object instead
object Hello {
  // def gets evaluated every time we refer to it...
//  def ninetyNine = 9 + 90
  // val is evaluated exactly once
  // Stylistically public declarations in objects and classes should
  // be explicitly typed..
  val ninetyNine: Int = 9 + 90

  def main(args: Array[String]): Unit = {
    // other languages: Type identifier
    // Pascal: identfier: Type
    // Scala: as pascal ;)
    // type is often (frequently) optional, can be inferred...
    // val creates an immutable value / variable -- preferred in functional style
    // anArray is a reference variable...
    val anArray: Array[String] = new Array(3) //Array("Fred", "Jim", "Sheila")
    anArray(1) = "A String"
    // can have mutable variables with var
    // also illustrates type inference
    var changeMe = "Hello"
    changeMe = "Goodbye"

    println(anArray(1))
    println("Hello world")
  }
}

object ReallyOdd {
  def main(args: Array[String]): Unit = {
    println("More worlds to say hello to")
  }
}
