package lineCode

/**
 * Created by MarcopTo on 02/10/2015.
 */
class LineCounter(linee: Vector[String]) {


  def count(): Int = {

    var count = 0
    for (linea <- linee) {
      if (isNotComment(linea)) count += 1
    }
    count
  }

  def isNotComment(linea:String):Boolean ={

    isNotMultiLineComment(linea) && isNotSingoleLineComment(linea)
  }

  def isNotMultiLineComment(linea: String): Boolean = {
    !linea.matches("\\/\\*.*\\*\\/")
  }

  def isNotSingoleLineComment(linea: String): Boolean = {
    !linea.startsWith("//")
  }
}
