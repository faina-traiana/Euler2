import scala.annotation.tailrec

object problem3 {

  val primeCash = scala.collection.mutable.SortedSet[BigInt](1,2,3,5,7)
  val num = BigInt("600851475143")

  /**
   * The prime factors of 13195 are 5, 7, 13 and 29.

    What is the largest prime factor of the number 600851475143 ?
   * @param args
   */
  def main(args: Array[String]): Unit = {

    updatePrimeFactors(num)

    println(primeCash.max)

  }

  @tailrec
  def updatePrimeFactors(currentNum: BigInt): Unit = {

    println("entering updatePrimeFactors")

    if (primeCash.contains(currentNum))  return

    println(s"evaluating $currentNum")

    def allNums(v: BigInt): LazyList[BigInt] = v #:: allNums(v + 1)
    val minDivisor = allNums(2).takeWhile(_ <= currentNum)
        .find(currentNum % _ == 0)
       .get


    if (minDivisor == currentNum) {
      println(s"Adding to cash: $currentNum")
      primeCash +=currentNum
      return
    }

    updatePrimeFactors(currentNum/minDivisor)

  }

}
