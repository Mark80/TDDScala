

/**
 * Created by MarcopTo on 17/08/2015.
 */
object Flatter {

  def flatten(array: Array[Any]): Array[Any] = {
    if (array == null) null
    else
      flatList(array.toList).toArray
  }


  private def flatList(list: List[Any]): List[Any] = list.flatMap(
    x => x match {
      case arr: Array[_] => flatList(arr.toList)
      case _ => List(x)
    }
  )






}
