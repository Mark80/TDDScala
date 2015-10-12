package tennis._1

/**
 * Created by MarcopTo on 07/10/2015.
 */
class ScoreBoard(player1:String,player2:String) {


  private val scoresNames: Array[String] = Array("love", "15", "30", "40")

  private var pointsPlayer_1 = 0
  private var pointsPlayer_2 = 0


  def refreshScore(point: String): Unit = {
    if (NoBodyHasWin) {
      if (point == "player-1") pointsPlayer_1 += 1
      else
        pointsPlayer_2 += 1
    }
  }


  private def NoBodyHasWin: Boolean = !(player1Win || player2Win)

  def getScore(): String = {

    if (player1Win) {
      "Win for player "+player1
    } else if (player2Win) {
      "Win for player "+player2
    } else if (eitherHaveLeast40Points && haveSamepoints) {
      "Deuce"
    } else if (advantagePlayer1) {
      "Advantage player "+player1
    } else if (advantagePlayer2) {
      "Advantage player "+player2
    } else
      currentScore

  }


  private def currentScore: String = scoresNames(pointsPlayer_1) + "-" + scoresNames(pointsPlayer_2)

  private def advantagePlayer2: Boolean = pointsPlayer_2 >= 4 && pointsPlayer_2 - pointsPlayer_1 == 1

  private def advantagePlayer1: Boolean = pointsPlayer_1 >= 4 && pointsPlayer_1 - pointsPlayer_2 == 1

  private def player1Win: Boolean = pointsPlayer_1 >= 4 && pointsPlayer_1 - pointsPlayer_2 > 1

  private def player2Win: Boolean = pointsPlayer_2 >= 4 && pointsPlayer_2 - pointsPlayer_1 > 1

  private def eitherHaveLeast40Points: Boolean = (pointsPlayer_1 >= 3 && pointsPlayer_2 >= 3)

  private def haveSamepoints: Boolean = pointsPlayer_1 == pointsPlayer_2

}
