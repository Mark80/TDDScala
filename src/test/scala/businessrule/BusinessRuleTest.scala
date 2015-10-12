package businessrule


import org.scalatest.{BeforeAndAfter, FunSuite}

/**
 * Created by MarcopTo on 13/09/2015.
 */
class BusinessRuleTest extends FunSuite with BeforeAndAfter{


  var paymentService:PaymentService = _


  before{
    paymentService = new PaymentService()

  }



  test("il packing slip prodotto contiene la lista dei prodotti aquistati"){

    val scarpe = new Product("Scarpe da corsa",25)
    val payment = new Payment("Marco",List(scarpe),25)
    val packingSlip = paymentService.receive(payment)

    assertResult(List(scarpe))(packingSlip.getProduct)


  }

  test("ricevo pagamento per due prodotti"){

    val cappotto = new Product("cappotto",100)
    val maglietta = new Product("maglietta",50)
    val payment = new Payment("Marco",List(cappotto,maglietta),150)
    val packingSlip = paymentService.receive(payment)
    assertResult(List(cappotto,maglietta))(packingSlip.getProduct)
  }








}
