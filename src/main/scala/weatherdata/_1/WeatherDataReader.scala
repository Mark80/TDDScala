package weatherdata._1

import weatherdata.ContentFileReaer

/**
 * Created by MarcopTo on 08/09/2015.
 */
case class WeatherDataReader(reader: ContentFileReaer) {

  private val maxTempColummn: Int = 2

  private val minTempColumn: Int = 3

  def getMinimumSpread(): Int = (2 to fileSize).foldLeft(spreadOnLine(1))((minSpread, line) => {
    val currentSpread = spreadOnLine(line)
    if (currentSpread < minSpread) currentSpread
    else
      minSpread
  })


  private[weatherdata] lazy val fileSize: Int = {

    var index = 0
    var controllo = true
    while (controllo) {
      val row: String = reader.getLine(index + 1)
      val value: String = getColumnsValues(row)(0)
      if (value == "mo") {
        controllo = false
      }
      else {
        index += 1
      }
    }
    index
  }


  private[weatherdata] def spreadOnLine(lineNumber: Int): Int = {

   getValue(lineNumber)(maxTempColummn) - getValue(lineNumber)(minTempColumn)
  }


  private[weatherdata] def getValue(numRow: Int)(numColumn: Int): Int = {

    val row: String = reader.getLine(numRow)
    val values: Array[String] = getColumnsValues(row)
    try {
      removeSplecialCharacters(values(numColumn - 1)).toInt
    }catch {
      case ex:NumberFormatException => throw new TemperatureFormatException()
    }

  }

  private def removeSplecialCharacters(value: String): String = value.replace("*", "")

  private def getColumnsValues(lineString: String): Array[String] = lineString.trim.split("\\s+")



}
