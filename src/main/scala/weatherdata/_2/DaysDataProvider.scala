package weatherdata._2

import weatherdata.ContentFileReaer

/**
 * Created by MarcopTo on 05/10/2015.
 */
class DaysDataProvider(contentReader: ContentFileReaer) {

  def getData(): Vector[DayData] = {

    var daysData: Vector[DayData] = Vector.empty[DayData]

    var check = true
    while (check) {
      val data: String = contentReader.getNextLine().replace("*","")
      if (isLastLine(data)) {
        check = false
      } else {
        val day: DayData = new DayData(data)
        daysData = daysData :+ day
      }
    }

    daysData

  }

  private def isLastLine(data: String): Boolean = {
    data.contains("mo")
  }
}
