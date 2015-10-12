package businessrule

/**
 * Created by MarcopTo on 13/09/2015.
 */
class PaymentService {


  def receive(payment:Payment):PackingSlip = {


    val packingSlip = new PackingSlip(payment.products)
    packingSlip

  }

}
