/**
 * Created by MarcopTo on 16/07/2015.
 */
object Somma {

  def norm(a: String, b: String): (String, String) = {

    var aN = a
    var bN = b
    if (a.length > b.length) {
      bN = "0" * (a.length - b.length) + bN
    }
    else {
      aN = "0" * (b.length - a.length) + aN

    }

    (aN, bN)

  }

  def sum(a: String, b: String): String = {
    val an = norm(a, b)._1
    val bn = norm(a, b)._2


    var result = ""
    var resto = ""
    if (b == "1") {

      if (an.length > 0 && an.charAt(an.length - 1) == '1') {
        result = "0" + result
        resto = "1"
      } else {
        result = "1" + result
        resto = ""
      }


      var index = 1
      while (an.length > index) {
        val current = an.charAt(an.length - (index+1)).toString
        if (resto == "")
          result = current + result
        else
          result = swap(current) + result
        if(current == "0") {
          resto = ""
        }
        index = index + 1
      }

    } else {
      result = a
    }

    resto + result
  }

  private def swap(c: String): String = if (c == "0") "1" else "0"


}