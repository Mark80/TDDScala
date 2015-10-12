import org.scalatest.{BeforeAndAfter, FunSuite}

class MasterMindTest extends FunSuite with BeforeAndAfter {

  before {}

  private val B ="B"
  private val N ="N"

  test("test") {

    val board:MasterMind = new MasterMind(Array[String](B,B,B,B))
    val input = Array[String](B,B,B,B)
    assertResult(Array(N,N,N,N))(board.check(input))

  }


  class MasterMind(sequenza:Array[String]){
    def check(input: Array[String]): Array[String] = new Array[String](4)


  }

  after {}

}