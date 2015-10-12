package prices._2

import org.scalatest.{BeforeAndAfter, FunSuite}

import scala.collection.immutable.Iterable

class PriceTest extends FunSuite with BeforeAndAfter {

  var carrello: CarrelloSpesa = _

  val cassa = new Cassa()

  type Offerta = Vector[Item] => Double

  before {

    carrello = new CarrelloSpesa()


  }

  test("posso calcolare il prezzo totale della spesa con un prodotto") {

    carrello.add(new Soup())
    assertResult(0.65)(cassa.costOf(carrello))

  }

  test("posso calcolare il prezzo totale della spesa con due prodotti uguali ") {


    carrello.add(new Soup())
    carrello.add(new Soup())
    assertResult(1.30)(cassa.costOf(carrello))

  }

  test("posso calcolare il prezzo totale della spesa con 3  ") {


    carrello.add(new Soup())
    carrello.add(new Soup())
    carrello.add(new Milk())

    assertResult(2.60)(cassa.costOf(carrello))

  }


  test("compro le mele con uno sconto de l0 %") {

    carrello.add(new Apples())
    carrello.add(new Apples())
    carrello.add(new Milk())


    val offers: Offerta = {

      items => {
        items.foldLeft(0.0)((acc, item) => acc + {
          item match {
            case Apples(_) => item.price * 0.9
            case _ => item.price
          }
        }
        )
      }

    }

    val cassaOffers = new Cassa(offers)
    assertResult(3.1)(cassaOffers.costOf(carrello))


  }


  test("se compro 2 zuppe prendo il pane a meta prezzo") {

    carrello.add(new Soup())
    carrello.add(new Soup())
    carrello.add(new Bread())
    carrello.add(new Apples())


    val offers: Offerta = {

      items => {

        val groupItem: Map[Item, Vector[Item]] = items.groupBy(item => item)
        val prices: Iterable[Double] = groupItem.map(item => item._1 match {
          case Apples(_) => 0.9 * item._2.size
          case i: Bread if ((groupItem.get(new Soup()).get.size) >= 2) => (i.price) / 2 * item._2.size
          case i => i.price * item._2.size
        })


        prices.sum

      }

    }

    val cassaOffers = new Cassa(offers)
    assertResult(2.6)(cassaOffers.costOf(carrello))


  }


  after {}

}


class CarrelloSpesa() {

  private var items: Vector[Item] = Vector.empty[Item]

  def add(item: Item): Unit = items = items :+ item

  def listIfItem: Vector[Item] = items

}

class Cassa(offers: Vector[Item] => Double = (items) => items.map(item => item.price).sum) {

  def costOf(carrello: CarrelloSpesa): Double = offers(carrello.listIfItem)


}

trait Item {

  def price: Double

}

case class Soup(price: Double = 0.65) extends Item

case class Bread(price: Double = 0.80) extends Item

case class Milk(price: Double = 1.30) extends Item

case class Apples(price: Double = 1.0) extends Item