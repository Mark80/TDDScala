package prezzo._1

/**
 * Created by MarcopTo on 29/09/2015.
 */
class Carrello() {

  var goods : List[Good] = List.empty[Good]

  def add(good:Good):Unit = goods = good :: goods



  }
