package tennis._1

/**
 * Created by MarcopTo on 07/10/2015.
 */
class Umbier(handSet: HandSet) {

  def wonPoint(point: String):Unit = {

   if(point == "player-1") handSet.buttonPlayer1
    else handSet.buttonPlayer2


  }

}
