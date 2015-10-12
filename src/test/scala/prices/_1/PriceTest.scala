package prices._1

import org.scalatest.{BeforeAndAfter, FunSuite}
import prezzo._1._

/**
 * Created by MarcopTo on 29/09/2015.
 */
class PriceTest extends FunSuite with BeforeAndAfter{

  private var carrello:Carrello = _
  private var cassa :Cassa = _

  before {

    val prices = new PriceRepository()
    cassa = new Cassa(prices)
    carrello = new Carrello()

  }

  test("un carrelo vuoto ha costo zero"){


    assertResult(0)(cassa.subTotal(carrello))
    assertResult(0)(cassa.total(carrello));

  }

  test("un carrelo con una latte "){


    carrello.add(new Milk())

    assertResult(1.30)(cassa.subTotal(carrello))
    assertResult(1.30)(cassa.total(carrello));

  }

  test("un carrelo con 2 cartoni di  latte "){


    carrello.add(new Milk())
    carrello.add(new Milk())

    assertResult(2.60)(cassa.subTotal(carrello))
    assertResult(2.60)(cassa.total(carrello));

  }

  test("un carrelo con  latte e pane "){


    carrello.add(new Milk())
    carrello.add(new Bread())

    assertResult(2.10)(cassa.subTotal(carrello))
    assertResult(2.10)(cassa.total(carrello));

  }

  test("add all type of goods  to basket "){

    carrello.add(new Milk())
    carrello.add(new Bread())
    carrello.add(new Soup())
    carrello.add(new Apple())

    assertResult(3.75)(cassa.subTotal(carrello))
    assertResult(3.75)(cassa.total(carrello));

  }


  test("add Apple with offers"){

    val prices = new PriceRepository()
    val offers = new Offers()
    val cassaOffers = new Cassa(prices,offers)

    carrello.add(new Milk())
    assertResult(1.30)(cassaOffers.subTotal(carrello))
    assertResult(1.17)(cassaOffers.total(carrello));

  }




}
