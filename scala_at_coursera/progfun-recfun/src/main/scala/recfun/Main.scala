package recfun
import common._
import scala.annotation.tailrec

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (0 == c || r == c) 1
    else pascal(c, r - 1) + pascal(c - 1, r - 1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
     @tailrec
    def checkBalance( leftRacket:Int, chars: List[Char]): Boolean = {
      if (leftRacket < 0) false
      else if (chars.isEmpty) leftRacket == 0
      else if ('(' == chars.head) checkBalance(leftRacket+1, chars.tail)
      else if (')' == chars.head) checkBalance(leftRacket-1, chars.tail)
      else checkBalance(leftRacket, chars.tail)
    }
    checkBalance(0, chars)
    
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if(0 == money ) 1
    else if (0 > money) 0
    else if (coins.isEmpty) 0
    else countChange(money-coins.head, coins) + countChange(money, coins.tail)
  }
}
