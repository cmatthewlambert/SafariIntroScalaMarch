package date

object MyDate {

  object DaysOfWeek extends Enumeration {
    type DaysOfWeek = Value
    val SATURDAY = Value("Saturday")
    val SUNDAY = Value("Sunday")
    val MONDAY = Value("Monday")
    val TUESDAY = Value("Tuesday")
    val WEDNESDAY = Value("Wednesday")
    val THURSDAY = Value("Thursday")
    val FRIDAY = Value("Friday")
  }

  val dayNames = Array(
    "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday")

  def dayName(id: Int): String = {
    println(s"you asked about day $id -- I will return ${dayNames(id)}")
    println(f"the length will be ${dayNames(id).length}%6.3f")
    println(raw"hello\now")
    // last expression in a block is the value of that block
    // blocks *are* expressions...
    /*return*/ dayNames(id)
  }

  // find day of week from day, month, and year
  def dayOfWeek(d: Int, mo: Int, ye: Int): Int = {
    //    val m = if (mo < 3) {mo - 12} else {mo}
    //    val y = if (mo < 3) {ye + 1} else {ye}
    // tuple, declare and assign to tuple "decomposition"
    val (m, y) = if (mo < 3) {
      (mo + 12, ye - 1)
    } else {
      (mo, ye)
    }
    (d + (13 * (m + 1) / 5) + y + y / 4 - y / 100 + y / 400) % 7
  }


  def main(args: Array[String]): Unit = {
    println(s"name of day 1 ${dayName(1)}")
    println(s"name of day 2 ${DaysOfWeek(2)}")
    println(s"jan 1 2000 was on a ${dayName(dayOfWeek(1, 1, 2000))}")
  }

  def apply(d: Int, m: Int, y: Int): MyDate = {
    if (d < 1 || d > 31) throw new IllegalArgumentException("Bad day")
    new MyDate(d, m, y)
  }
}

class MyDate protected(val day: Int, val month: Int, val year: Int) {
  println(s"Making a MyDate with ${day}, ${month}, ${year}")
  if (day < 1 || day > 31) throw new IllegalArgumentException("Bad day")

  override def toString: String = s"MyDate d=$day, m=$month, y=$year"

  override final def equals(obj: Any): Boolean = obj match {
    case other: MyDate => day == other.day &&
      month == other.month &&
      year == other.year
    case _ => false
  }
}

class Holiday(d: Int, m: Int, y: Int, val name: String) extends MyDate(d, m, y) {
  println("Invoking primary Holiday constructor")
  def this(d: Int, m: Int, n: String) = this(d, m, 2018, n)

  override def toString: String = s"Holiday (${super.toString}), name: $name"
}
//class MyDate (d: Int, m: Int, y: Int) {
//  val day: Int = d
//  val month: Int = m
//  val year: Int = y
//}

object UseMyDate {
  def main(args: Array[String]): Unit = {
//    val d1 = MyDate.apply(22, 3, 2018)
    val d1 = MyDate(22, 3, 2018)
    println(s"date has day of ${d1.day}")
//    new MyDate(1, 1, 2001)
    val d2 = new Holiday(1, 5, 2018, "May Day")
    val d3 = new Holiday(1, 5, "May Day again")
    println(s"d3 is $d3")

    val d4 = MyDate(1, 5, 2018)
    println(s"d3 == d4 ${d3 == d4}")
    println(s"d3 eq d4 ${d3.eq(d4)}")
    println(s"d3 eq d4 ${d3 eq d4}")
  }
}

object ListStuff {
  def findFirstOfMonth(l: List[MyDate]): List[MyDate] = l match {
    case List() => List()
    case h :: t =>
      if (h.day == 1) { h :: findFirstOfMonth(t) }
      else {findFirstOfMonth(t)}
  }

  def main(args: Array[String]): Unit = {
//    val ld = List(
//      MyDate(1, 1, 2000),
//      MyDate(1, 3, 2003),
//      MyDate(3, 7, 2012)
//    )
    val ld = MyDate(1, 1, 2000) :: MyDate(1, 3, 2003) :: MyDate(3, 7, 2012) :: Nil

    println(s"Firsts of month ${findFirstOfMonth(ld)}")

    ld.filter((x) => x.day == 1)
    ld.filter(x => x.day == 1)
    ld.filter((x:MyDate) => x.day == 1)
    val nl = ld.filter(_.day == 1)
    println(s"Firsts of month (again) ${nl}")
//    nl.foreach(x => println(x))
//    nl.foreach(println(_))
    nl.foreach(println)

    // https://www.safaribooksonline.com/library/view/functional-programming-for/9780134778235/
  }
}
