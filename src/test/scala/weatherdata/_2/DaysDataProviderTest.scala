package weatherdata._2

import org.scalatest.{BeforeAndAfter, FunSuite}
import weatherdata.ContentFileReaer

class DaysDataProviderTest extends FunSuite with BeforeAndAfter {

  var contentReader: ContentFileReaer = _
  var dataProvider:DaysDataProvider =_

  before{
     contentReader= new ContentFileReaer("C:\\Users\\marcopto\\IdeaProjects\\TDDScala\\src\\main\\scala\\weatherdata\\weather.dat")
     dataProvider = new DaysDataProvider(contentReader);



  }

  test("test get first day  data from file") {


    val data: Vector[DayData] = dataProvider.getData()

    val firstDay: DayData = data.head

    assertResult(1)(firstDay.day)

  }

  test("test get seocnd day  data from file") {


    val data: Vector[DayData] = dataProvider.getData()

    val secondDay: DayData = data.tail.head

    assertResult(2)(secondDay.day)

  }

  test("test get third day  data from file") {


    val data: Vector[DayData] = dataProvider.getData()

    val secondDay: DayData = data.tail.head

    assertResult(2)(secondDay.day)

  }

  after {}

}