package weatherdata

import java.io.{BufferedReader, FileReader}

/**
 * Created by MarcopTo on 21/09/2015.
 */
class ContentFileReaer(path: String, offset: Int = 1) {
  def getNextLine() = {

    val line = getLine(index)
    index += 1
    line

  }


  private var index : Int = 1


  def getLine(riga: Int): String = {
    var reader:BufferedReader = null
      try {
      reader = new BufferedReader(new FileReader(path))
      moveReaderToRow(riga, reader)
      reader.readLine()
    }finally {
      reader.close()
    }
  }

  private def moveReaderToRow(riga: Int, reader: BufferedReader): Unit = (0 until  riga + offset).foreach( i => reader.readLine())

}
