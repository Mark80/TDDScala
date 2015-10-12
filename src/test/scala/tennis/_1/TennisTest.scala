package tennis._1

import org.scalatest.{BeforeAndAfter, FunSuite}

class TennisTest extends FunSuite with BeforeAndAfter {

  var scoreboard: ScoreBoard = _
  var umbier: Umbier = _
  var handset: HandSet = _

  before {

    scoreboard = new ScoreBoard(player1 = "1",player2 = "2")
    handset = new HandSet(scoreboard)
    umbier = new Umbier(handset)
  }

  test("initial  score is love-love") {

    assert("love-love" === scoreboard.getScore())

  }

  test("if umbier press button player 1 the score is 15-love") {


    umbier.wonPoint("player-1")
    assert("15-love" === scoreboard.getScore())

  }

  test("if umbier press button player 1 and player 2 the score is 15-15") {

    umbier.wonPoint("player-1")
    umbier.wonPoint("player-2")
    assert("15-15" === scoreboard.getScore())

  }

  test("if umbier press button player 1 twice and player 2 ones the score is 15-15") {

    umbier.wonPoint("player-1")
    umbier.wonPoint("player-1")
    umbier.wonPoint("player-2")
    assert("30-15" === scoreboard.getScore())

  }

  test("if umbier press button player 1 2 and player 2 the score is 15-15") {

    umbier.wonPoint("player-1")
    umbier.wonPoint("player-1")
    umbier.wonPoint("player-2")
    umbier.wonPoint("player-2")
    assert("30-30" === scoreboard.getScore())

  }

  test("3 point player 1") {

    umbier.wonPoint("player-1")
    umbier.wonPoint("player-1")
    umbier.wonPoint("player-1")
    assert("40-love" === scoreboard.getScore())

  }

  test("3 point for player 1 and player 2") {

    umbier.wonPoint("player-1")
    umbier.wonPoint("player-1")
    umbier.wonPoint("player-1")
    umbier.wonPoint("player-2")
    umbier.wonPoint("player-2")
    umbier.wonPoint("player-2")
    assert("Deuce" === scoreboard.getScore())

  }

  test("win player 2") {

    umbier.wonPoint("player-2")
    umbier.wonPoint("player-2")
    umbier.wonPoint("player-2")
    umbier.wonPoint("player-2")
    assert("Win for player 2" === scoreboard.getScore())

  }

  test("win player 1") {

    umbier.wonPoint("player-1")
    umbier.wonPoint("player-1")
    umbier.wonPoint("player-1")
    umbier.wonPoint("player-1")
    assert("Win for player 1" === scoreboard.getScore())

  }

  test("advantage player 1") {

    umbier.wonPoint("player-1")
    umbier.wonPoint("player-2")
    umbier.wonPoint("player-1")
    umbier.wonPoint("player-2")
    umbier.wonPoint("player-1")
    umbier.wonPoint("player-2")
    umbier.wonPoint("player-1")
    assert("Advantage player 1" === scoreboard.getScore())

  }



  test("advantage player 2") {

    umbier.wonPoint("player-1")
    umbier.wonPoint("player-2")
    umbier.wonPoint("player-1")
    umbier.wonPoint("player-2")
    umbier.wonPoint("player-1")
    umbier.wonPoint("player-2")
    umbier.wonPoint("player-2")
    assert("Advantage player 2" === scoreboard.getScore())

  }

  test("second advantage player 1") {

    umbier.wonPoint("player-1")
    umbier.wonPoint("player-2")
    umbier.wonPoint("player-1")
    umbier.wonPoint("player-2")
    umbier.wonPoint("player-1")
    umbier.wonPoint("player-2")
    umbier.wonPoint("player-1")
    umbier.wonPoint("player-2")

    assert("Deuce" === scoreboard.getScore())

  }

  test("third advantage player 1") {

    umbier.wonPoint("player-1")
    umbier.wonPoint("player-2")
    umbier.wonPoint("player-1")
    umbier.wonPoint("player-2")
    umbier.wonPoint("player-1")
    umbier.wonPoint("player-2")
    umbier.wonPoint("player-1")
    umbier.wonPoint("player-2")
    umbier.wonPoint("player-1")

    assert("Advantage player 1" === scoreboard.getScore())

  }

  test("second win player 1") {

    umbier.wonPoint("player-1")
    umbier.wonPoint("player-2")
    umbier.wonPoint("player-1")
    umbier.wonPoint("player-2")
    umbier.wonPoint("player-1")
    umbier.wonPoint("player-2")
    umbier.wonPoint("player-1")
    umbier.wonPoint("player-2")
    umbier.wonPoint("player-1")
    umbier.wonPoint("player-1")


    assert("Win for player 1" === scoreboard.getScore())

  }

  test("secon win player 2") {

    umbier.wonPoint("player-1")
    umbier.wonPoint("player-2")
    umbier.wonPoint("player-1")
    umbier.wonPoint("player-2")
    umbier.wonPoint("player-1")
    umbier.wonPoint("player-2")
    umbier.wonPoint("player-2")
    umbier.wonPoint("player-2")

    assert("Win for player 2" === scoreboard.getScore())

  }

  test("yet win player 1") {

    umbier.wonPoint("player-1")
    umbier.wonPoint("player-1")
    umbier.wonPoint("player-1")
    umbier.wonPoint("player-1")
    umbier.wonPoint("player-2")
    umbier.wonPoint("player-2")
    umbier.wonPoint("player-2")
    umbier.wonPoint("player-2")
    assert("Win for player 1" === scoreboard.getScore())

  }


  after {}

}