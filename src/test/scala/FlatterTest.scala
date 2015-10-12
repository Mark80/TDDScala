import org.scalatest.FunSuite

/**
 * Created by MarcopTo on 17/08/2015.
 */

import Flatter._

class FlatterTest extends FunSuite {


  test("flat simple array") {

    val arr: Array[Any] = Array(1, 2, 3, 4, 5)
    assertEqualsArray(Array(1, 2, 3, 4, 5), flatten(arr))

  }

  test("array with sub array") {

    val arr = Array(1, 2, 3, Array(4))
    assertEqualsArray(Array(1, 2, 3, 4), flatten(arr))
  }

  test("array with sub  array 2") {

    val arr = Array(1, 2, 3, Array(4, 67, 9))
    assertEqualsArray(Array(1, 2, 3, 4, 67, 9), flatten(arr))
  }

  test("array with sub sub array ") {

    val arr = Array(1, 2, 3, Array(4, 67, Array(9)))
    assertEqualsArray(Array(1, 2, 3, 4, 67, 9), flatten(arr))
  }

  test("array with sub sub sub array ") {

    val arr = Array(1, 2, 3, Array(4, 67, Array(9, Array(10))), 11, 39)
    assertEqualsArray(Array(1, 2, 3, 4, 67, 9, 10, 11, 39), flatten(arr))
  }

  test("array with sub sub array and null value") {

    val arr = Array(1, null, 3, Array(4, 67, Array(9)))
    assertEqualsArray(Array(1, null, 3, 4, 67, 9), flatten(arr))
  }

  test("array with sub sub array and string") {

    val arr = Array(1, "eccomi", 3, Array(4, 67, Array(9)))
    assertEqualsArray(Array(1, "eccomi", 3, 4, 67, 9), flatten(arr))
  }


  private[this] def assertEqualsArray(atteso: Array[Any], res: Array[Any]): Unit = {

    var result = true

    for (i <- 0 until atteso.length)
      result = result && (atteso(i) == res(i))

    assert(result)

  }


}
