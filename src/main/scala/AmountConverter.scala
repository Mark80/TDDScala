/**
 * Created by MarcopTo on 31/07/2015.
 */
class AmountConverter {


  private val change = Map(0 -> "zero", 1 -> "uno", 2 -> "due", 3 -> "tre",
    4 -> "quattro", 5 -> "cinque", 6 -> "sei", 7 -> "sette",
    8 -> "otto", 9 -> "nove", 10 -> "dieci", 11 -> "undici",
    12 -> "dodici", 13 -> "tredici", 14 -> "quattordici", 15 -> "quindici",
    16 -> "sedici", 17 -> "diciasette", 18 -> "diciotto", 19 -> "diciannove",
    20 -> "venti", 30 -> "trenta", 40 -> "quaranta", 50 -> "cinquanta", 60 -> "sessanta", 70 -> "settanta",
    80 -> "ottanta", 90 -> "novanta")

  def fromNuberToString(amount: Int): String = {

    var result = ""
    val unita = change(amount % 10)
    if (amount < 21 || unita == "zero")
      result = change(amount)
    else {
      val unita = change(amount % 10)
      val decine = getDecine(unita, amount)
      result = decine + unita

    }

    result + " dollari"

  }

  private def getDecine(unita: String, amount: Int): String = {

    val decine = amount - (amount % 10)

    if (unita == "uno") change(decine).substring(0, change(decine).length - 1) else change(decine)
  }
}
