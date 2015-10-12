package weatherdata._1

import org.scalatest.{BeforeAndAfter, FunSuite}
import weatherdata.ContentFileReaer

/**
 * Created by MarcopTo on 21/09/2015.
 */
class WetherDataValueTest  extends FunSuite with BeforeAndAfter {

  var reader: WeatherDataReader = _

  before {
    val contentReader: ContentFileReaer = new ContentFileReaer("C:\\Users\\marcopto\\IdeaProjects\\TDDScala\\src\\main\\scala\\weatherdata\\weather.dat")
    reader = new WeatherDataReader(contentReader)


  }

  test("read first value of the first line") {


    assertResult(1)(reader.getValue(1)(1))

  }


  test("read second value of first line") {

    assertResult(88)(reader.getValue(1)(2))

  }

  test("read third value of third line") {

    assertResult(55)(reader.getValue(3)(3))

  }

  test("read third value of 20 line") {

    assertResult(57)(reader.getValue(20)(3))

  }


}
