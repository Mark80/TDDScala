import org.scalatest.{MustMatchers, BeforeAndAfter, FunSpec}

/**
 * Created by MarcopTo on 31/07/2015.
 */
class StringMoneyTest extends FunSpec with BeforeAndAfter with MustMatchers {


  private[this] val converter = new AmountConverter()


  describe("Converto una quanti soldi da numerico a stringa") {


    it("0 $") {

      "zero dollari" must be(amountInString(0))
    }

    it("1 $") {


      "uno dollari" must be(amountInString(1))
    }


    it("2 $") {


      "due dollari" must be(amountInString(2))
    }

    it("3 $") {


      "tre dollari" must be(amountInString(3))
    }


    it("4 $") {


      "quattro dollari" must be(amountInString(4))
    }


    it("11 $") {


      "undici dollari" must be(amountInString(11))
    }

    it("22 $") {


      "ventidue dollari" must be(amountInString(22))
    }

    it("26 $") {


      "ventisei dollari" must be(amountInString(26))
    }

    it("21 $") {


      "ventuno dollari" must be(amountInString(21))
    }

    it("30 $") {

      "trenta dollari" must be(amountInString(30))
    }


    it("31 $") {

      "trentuno dollari" must be(amountInString(31))
    }

    it("36 $") {

      "trentasei dollari" must be(amountInString(36))
    }

    it("40 $") {

      "quaranta dollari" must be(amountInString(40))
    }

    it("41 $") {

      "quarantuno dollari" must be(amountInString(41))
    }

    it("83 $") {

      amountInString(83) must be("ottantatre dollari")

    }


  }

  private def amountInString(amount: Int): String = converter.fromNuberToString(amount)

}
