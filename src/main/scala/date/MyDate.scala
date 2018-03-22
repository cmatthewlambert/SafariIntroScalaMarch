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
    val (m, y) = if (mo < 3) {(mo + 12, ye - 1)} else {(mo, ye)}
    (d + (13 * (m + 1) / 5) + y + y / 4 - y / 100 + y / 400) % 7
  }


  def main(args: Array[String]): Unit = {
    println(s"name of day 1 ${dayName(1)}")
    println(s"name of day 2 ${DaysOfWeek(2)}")
    println(s"jan 1 2000 was on a ${dayName(dayOfWeek(1, 1, 2000))}")
  }
}
