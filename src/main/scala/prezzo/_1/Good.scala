package prezzo._1

/**
 * Created by MarcopTo on 29/09/2015.
 */
sealed trait Good {}

case class Milk() extends Good
case class Bread() extends Good
case class Soup() extends Good
case class Apple() extends Good
