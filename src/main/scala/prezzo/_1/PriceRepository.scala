package prezzo._1

/**
 * Created by MarcopTo on 29/09/2015.
 */
class PriceRepository {

  def getGoodPrice(item: Good): Double = item match {
      case Milk() => 1.30
      case Bread() => 0.80
      case Apple() => 1.00
      case Soup() => 0.65
    }


}
