object problem1 {
  def main(args: Array[String]): Unit = {

    val lastNum = 1000

    val sumArray = for (e <- 1 until lastNum if dividesBy(e)) yield e

    println(sumArray.sum)
  }

  def dividesBy(num: Int): Boolean =
    num % 3 == 0 || num % 5 == 0
}