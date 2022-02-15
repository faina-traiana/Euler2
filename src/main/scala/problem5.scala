import scala.annotation.tailrec

object problem5 {

  /**
   * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

    What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
   * @param args
   */
  def main(args: Array[String]): Unit = {

    val max = 20

    def allNums(v: BigInt): LazyList[BigInt] = v #:: allNums(v + 1)
    val allDivisible = allNums(max)
      .find(isDivisible(_, max))
      .get

    println(allDivisible)

  }

  @tailrec
  def isDivisible(num: BigInt, divisor: BigInt): Boolean = {
    if(num % divisor != 0) return false
    if (divisor == 1) return true

    isDivisible(num, divisor-1)
  }

}
