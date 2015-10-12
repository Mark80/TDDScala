import list.Lista
import org.scalatest.FunSuite

/**
 * Created by MarcopTo on 26/08/2015.
 */
class ListaTest extends FunSuite{


  test("test methods"){

    val lista:Lista[Int] = Lista(1,2,3,4)

    assertResult(Lista(2,3,4))(lista.tail)
    assertResult(Lista(2,3,4))(lista.drop(1))
    assertResult(Lista(3,4))(lista.drop(2))

    assertResult(Lista(3,4))(lista.dropWhile( _ < 3 ))

    assertResult(Lista(0,2,3,4))(lista.replaceHead(0))
    assertResult(Lista(12,2,3,4))(lista.replaceHead(12))

    assertResult(Lista(1,2,3))(lista.init())

    assertResult(Lista(1,2,3,4,5,6,7,8,9))(lista ++ Lista(5,6,7,8,9))

  }

}
