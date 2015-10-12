package tennis._1

/**
 * Created by MarcopTo on 07/10/2015.
 */
class HandSet(scoreBoard: ScoreBoard) {

  def buttonPlayer1 :Unit  = scoreBoard.refreshScore("player-1")
  def buttonPlayer2 :Unit  = scoreBoard.refreshScore("player-2")

}
