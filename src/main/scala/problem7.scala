object problem7 {

  /**
   * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.

      What is the 10 001st prime number?
   * @param args
   */

  val num = 10001
  def allNums(v: BigInt): LazyList[BigInt] = v #:: allNums(v + 1)

  def main(args: Array[String]): Unit = {

    val result = allNums(2)
      .filter(isPrime)
      .take(num)
      .last

    println(result)
  }


  def isPrime(currentNum: BigInt): Boolean = {

    val minDivisor = allNums(2).takeWhile(_ <= currentNum)
      .find(currentNum % _ == 0)
      .get

    minDivisor == currentNum
  }

}
