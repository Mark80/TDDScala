import org.scalatest.{BeforeAndAfter, FunSpec, FunSuite}
import org.scalatest.MustMatchers._
import Somma._

/**
 * Created by MarcopTo on 16/07/2015.
 */
class SommaBinariaTest extends FunSpec with BeforeAndAfter {


  describe("normalizzazione numeri di input") {
    it("test") {

      norm("0", "0") must be(("0", "0"))
      norm("10", "0") must be(("10", "00"))
      norm("10", "110") must be(("010", "110"))
      norm("1011", "110") must be(("1011", "0110"))
    }
  }

  describe("somma binaria") {


    it("la somma 0 e 0") {
      sum("0", "0") must be("0")
    }

    it("la somma tra 0 e 1 ") {
      sum("0", "1") must be("1")
    }

    it("la somma 1 e 0") {
      sum("1", "0") must be("1")
    }

    it("la somma 1 e 1") {
      sum("1", "1") must be("10")
    }

    it("la somma 10 e 0") {
      sum("10", "0") must be("10")
    }

    it("la somma 10 e 1") {
      sum("10", "1") must be("11")
    }

    it("la somma 11 e 1") {
      sum("11", "1") must be("100")
    }

    it("la somma 100 e 1") {
      sum("100", "1") must be("101")
    }

    it("la somma 101 e 0") {
      sum("101", "0") must be("101")
    }

    it("la somma 101 e 1") {
      sum("101", "1") must be("110")
    }

    it("la somma 110 e 1") {
      sum("110", "1") must be("111")
    }

    it("la somma 111 e 1") {
      sum("111", "1") must be("1000")
    }

    it("la somma 1000 e 1") {
      sum("1000", "1") must be("1001")
    }



  }


}
