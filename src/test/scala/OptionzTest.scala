import list.{Somez, Nonez, Optionz}
import org.scalatest.FunSuite
import  list.Optionz._
/**
 * Created by MarcopTo on 27/08/2015.
 */
class OptionzTest extends FunSuite {


  test("test map method") {

    val opz: Optionz[Int] = Optionz(3)
    assertResult(Optionz(4))(opz.map(x => x + 1))

  }

  test("getOrElse") {

    val some = Optionz(3)
    assertResult(3)(some.getOrElse(5))
    val none = Nonez
    assertResult(5)(none.getOrElse(5))

  }


  test("flatMap"){

    val some = Optionz(3)
    assertResult(Somez(5))(some.flatMap( x => Somez(x+2)))

  }


  test("lift"){

    val f : String => Int = x => x.length
    val liftedF: Optionz[String] => Optionz[Int] = lift(f)

  }

}
