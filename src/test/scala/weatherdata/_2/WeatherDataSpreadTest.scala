package weatherdata._2

import org.scalatest.{BeforeAndAfter, FunSuite}
import weatherdata.ContentFileReaer

class WeatherDataSpreadTest extends FunSuite with BeforeAndAfter {

  val getter = new MinDaySpreadGetter();


  before {}

  test(" in un file con una sola linea il giorno è quello") {
    val dayData = new DayData("   1  88    59    74          53.8       0.00 F       280  9.6 270  17  1.6  93 23 1004.5")
    assertResult(1)(getter.getMinSpreadDay(Vector(dayData)))
  }

  test(" due giorni ") {
    val dayData1 = new DayData("   1  88    59    74          53.8       0.00 F       280  9.6 270  17  1.6  93 23 1004.5")
    val dayData2 = new DayData("   2  79    63    71          46.5       0.00         330  8.7 340  23  3.3  70 28 1004.5")

    assertResult(2)(getter.getMinSpreadDay(Vector(dayData1,dayData2)))
  }

  test(" tre giorni ") {
    val dayData1 = new DayData("   1  88    59    74          53.8       0.00 F       280  9.6 270  17  1.6  93 23 1004.5")
    val dayData2 = new DayData("   2  79    63    71          46.5       0.00         330  8.7 340  23  3.3  70 28 1004.5")
    val dayData3 = new DayData("   3  79    70    71          46.5       0.00         330  8.7 340  23  3.3  70 28 1004.5")

    assertResult(3)(getter.getMinSpreadDay(Vector(dayData1,dayData2,dayData3)))
  }

  test("test finale ") {

    val contentProvider = new ContentFileReaer("C:\\Users\\marcopto\\IdeaProjects\\TDDScala\\src\\main\\scala\\weatherdata\\weather.dat")
    val dataProvider = new DaysDataProvider(contentProvider)
    val spreadGetter = new MinDaySpreadGetter()

    val result = spreadGetter.getMinSpreadDay(dataProvider.getData())

    assertResult(14)(result)



  }

  after {}

}


