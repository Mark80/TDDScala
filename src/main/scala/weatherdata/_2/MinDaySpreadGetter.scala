package weatherdata._2

/**
 * Created by MarcopTo on 05/10/2015.
 */
class MinDaySpreadGetter {


  def getMinSpreadDay(dayData: Vector[DayData]): Int = {
    val result: DayData = dayData.foldLeft(dayData(0))((acc, day) => getMin(acc,day))
    result.day
  }

  private def getMin(day1: DayData, day2: DayData) = if (getDaySpread(day1) < getDaySpread(day2))
      day1
    else
      day2

  private def getDaySpread(dayData: DayData): Int = dayData.maxTemp - dayData.minTemp

}
