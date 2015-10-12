package weatherdata._1

import org.mockito.Mockito.{mock => mockitoMock, when}
import org.scalatest.mock.MockitoSugar
import org.scalatest.{BeforeAndAfter, FunSuite}
import weatherdata.ContentFileReaer

/**
 * Created by MarcopTo on 08/09/2015.
 */
class WeatherDataSpreadTest extends FunSuite with BeforeAndAfter with MockitoSugar {

  var contentMock: ContentFileReaer = _
  var dataReader:WeatherDataReader = _

  before {

    contentMock = mock[ContentFileReaer]
    when(contentMock.getLine(1)).thenReturn("   1  88    59    74          53.8       0.00 F       280  9.6 270  17  1.6  93 23 1004.5")
    when(contentMock.getLine(2)).thenReturn("   2  79    63    71          46.5       0.00         330  8.7 340  23  3.3  70 28 1004.5")
    when(contentMock.getLine(3)).thenReturn("  3  81    57    69     51.7     0.00 T       260  9.1 270  29* 5.2  90 34 1012.5")
    when(contentMock.getLine(4)).thenReturn("  4  90    77    84          67.5       0.00 H       350  8.5 010  14  6.9  74 48 1018.2")
    when(contentMock.getLine(5)).thenReturn("  5  90    80    84          67.5       0.00 H       350  8.5 010  14  6.9  74 48 1018.2")
    when(contentMock.getLine(6)).thenReturn("   6  89    59    74          53.8       0.00 F       280  9.6 270  17  1.6  93 23 1004.5")
    when(contentMock.getLine(7)).thenReturn("   7  76    63    71          46.5       0.00         330  8.7 340  23  3.3  70 28 1004.5")
    when(contentMock.getLine(8)).thenReturn("  8  86    57    69     51.7     0.00 T       260  9.1 270  29* 5.2  90 34 1012.5")

    when(contentMock.getLine(9)).thenReturn("  9  90    B    84          67.5       0.00 H       350  8.5 010  14  6.9  74 48 1018.2")


    dataReader = new WeatherDataReaderStub(contentMock)

  }


  test("get temperatures spread of first line") {

    assertResult(29)(dataReader.spreadOnLine(1))

  }


  test("get temperatures spread of second line") {


    assertResult(16)(dataReader.spreadOnLine(2))

  }

  test("get temperatures spread of line 17") {

    assertResult(24)(dataReader.spreadOnLine(3))

  }

  test("get temperatures spread of line 24") {

    assertResult(13)(dataReader.spreadOnLine(4))

  }

  test("get temperatures spread of line 50") {

    assertResult(10)(dataReader.spreadOnLine(5))

  }

  test("get temperatures min  spread ") {

    assertResult(10)(dataReader.getMinimumSpread())

  }

  test("get temperatures with error") {

    intercept[TemperatureFormatException] {
      dataReader.spreadOnLine(9)
    }

  }



   private class WeatherDataReaderStub(contetMock:ContentFileReaer) extends WeatherDataReader(contetMock){

     override lazy val fileSize = 8

  }

}
