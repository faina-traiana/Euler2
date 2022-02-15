import scala.annotation.tailrec

object problem4 {

  /**
   * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

    Find the largest palindrome made from the product of two 3-digit numbers.
   * @param args
   */
  def main(args: Array[String]): Unit = {

    val allProductsStr = for (
      i <- 100 to 999;
      j <- 100 to 999 if isPalindrome((i*j).toString)
    ) yield (i*j)

    //find max palindrome
    println(
      allProductsStr
        .max
    )

  }

  @tailrec
  def isPalindrome(str: String): Boolean = {

    if (str.length < 2 ) return true

    if (str.head != str.last) return false

    isPalindrome(str.dropRight(1).drop(1))
  }

}
