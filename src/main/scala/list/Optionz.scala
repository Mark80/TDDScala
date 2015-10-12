package list

/**
 * Created by MarcopTo on 27/08/2015.
 */
sealed trait Optionz[+A] {

  def map[B](f: A => B): Optionz[B]

  def flatMap[B](f: A => Optionz[B]): Optionz[B]

  def getOrElse[B >: A](default: => B): B

  //def orElse[B >: A](ob: => Optionz[B]): Optionz[B]
  def filter(f: A => Boolean): Optionz[A]



}

case class Somez[+A](el: A) extends Optionz[A] {

  override def map[B](f: A => B): Optionz[B] = Somez(f(el))

  override def getOrElse[B >: A](default: => B): B = el

  override def flatMap[B](f: A => Optionz[B]): Optionz[B] = f(el)

  override def filter(f: A => Boolean): Optionz[A] = {

    if (f(el))
      Somez(el)
    else
      Nonez

  }
}

case object Nonez extends Optionz[Nothing] {

  override def map[B](f: Nothing => B): Optionz[B] = Nonez

  override def getOrElse[B](default: => B): B = default

  override def flatMap[B](f: Nothing => Optionz[B]): Optionz[B] = Nonez

  override def filter(f : Nothing => Boolean) = Nonez
}


object Optionz {

  def apply[A](el: A): Optionz[A] = Somez(el)
  def lift[B ,C](f: B => C): Optionz[B] => Optionz[C] = _ map f

}
