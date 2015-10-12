package prezzo._1

/**
 * Created by MarcopTo on 29/09/2015.
 */
class Cassa(priceRepository: PriceRepository,offers:Offers) {

  def this(priceRepository: PriceRepository) = this(priceRepository,null)

  def total(carrello:Carrello): Double = carrello.goods.foldLeft(0.0)((acc ,good) => acc + priceRepository.getGoodPrice(good))

  def subTotal(carrello:Carrello): Double = carrello.goods.foldLeft(0.0)((acc ,good) => acc + priceRepository.getGoodPrice(good))


}
