package weatherdata._2

/**
 * Created by MarcopTo on 05/10/2015.
 */
case class DayData(data : String) {

  private val dataArr:Array[String] = data.trim().split("\\s+")



  lazy val  day:Int = dataArr(0).toInt
  lazy val  maxTemp:Int = dataArr(1).toInt
  lazy val  minTemp:Int = dataArr(2).toInt

}
