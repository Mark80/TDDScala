package fizzbuzz._1

import org.scalatest.{BeforeAndAfter, FunSuite}

class FizzBuzzTest extends FunSuite with BeforeAndAfter {

  before {}

  test("fizzbuzz") {
    val fizzBuzz: FizzBuzz = new FizzBuzz(new BaseFizzBuzzStrategy())
    assert("1" === fizzBuzz.next())
    assert("2" === fizzBuzz.next())
    assert("fizz" === fizzBuzz.next())
    assert("4" === fizzBuzz.next())
    assert("buzz" === fizzBuzz.next())
    assert("fizz" === fizzBuzz.next())
    assert("7" === fizzBuzz.next())


  }

  test("milti fizzbuzz") {

    val fizzBuzz: FizzBuzz = new FizzBuzz(new BaseFizzBuzzStrategy())

    assert("fizz" === fizzBuzz.nextNum(3))

  }


  test("15 fizzbuzz") {

    val fizzBuzz: FizzBuzz = new FizzBuzz(new BaseFizzBuzzStrategy())

    assert("fizzbuzz" === fizzBuzz.nextNum(15))

  }

  test("print all number fizz buzz") {

    val printer: ConsolePrinter = new ConsolePrinter(new FizzBuzz(new BaseFizzBuzzStrategy()))

    printer.print()

  }

  test("with seven ") {

    val strategy: Int => String = (index: Int) => index match {

      case i if (i % 15 == 0) => "fizzbuzz"
      case i if (i % 3 == 0) => "fizz"
      case i if (i % 5 == 0) => "buzz"
      case i if (i % 7 == 0) => "wizz"

      case _ => index.toString

    }

    val fizzBuzz: FizzBuzz = new FizzBuzz(strategy)

    assert("wizz" === fizzBuzz.nextNum(7))

  }


  class ConsolePrinter(fizzBuzz: FizzBuzz) {

    def print(): Unit = (1 to 100).foreach(i => fizzBuzz.next())

  }

  class FizzBuzz(strategy: Int => String) {

    var index = 1

    def nextNum(num: Int): String = (1 to num).foldLeft("")((acc, n) => next())

    def next(): String = {
      val result: String = strategy(index)
      index += 1
      result
    }

  }

  class BaseFizzBuzzStrategy() extends FizzBuzzStrategy {


    override def apply(index: Int): String = index match {

      case i if (i % 15 == 0) => "fizzbuzz"
      case i if (i % 3 == 0) => "fizz"
      case i if (i % 5 == 0) => "buzz"
      case _ => index.toString
    }
  }

  trait FizzBuzzStrategy extends (Int => String)

}