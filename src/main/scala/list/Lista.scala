package list

/**
 * Created by MarcopTo on 26/08/2015.
 */
sealed trait Lista[+T] {

  def init(): Lista[T]

  def replaceHead[U >: T](newValue: U): Lista[U]

  def dropWhile(function: (T) => Boolean): Lista[T]

  def tail: Lista[T]

  def drop(n: Int): Lista[T]

  def ++[U >: T](other: Lista[U]): Lista[U]

}

case class Node[+T](val head: T, val rest: Lista[T]) extends Lista[T] {

  def tail: Lista[T] = rest

  def drop(n: Int): Lista[T] = {

    if (n == 1)
      tail
    else
      tail.drop(n - 1)

  }

  override def dropWhile(f: (T) => Boolean): Lista[T] = {

    if (f(head))
      tail.dropWhile(f)
    else
      this

  }

  override def replaceHead[U >: T](newValue: U): Lista[U] = new Node[U](newValue, tail)


  override def init(): Lista[T] = this match {

    case Node(_, Empty) => Empty
    case Node(x, xs) => Node(x, tail.init())

  }

  override def ++[U >: T](other: Lista[U]): Lista[U] = Node(head, rest ++ other)


}

case object Empty extends Lista[Nothing] {

  def tail = throw new NoSuchElementException

  def drop(n: Int) = throw new NoSuchElementException

  override def dropWhile(function: (Nothing) => Boolean): Lista[Nothing] = Empty

  override def replaceHead[U](newValue: U): Node[U] = new Node(newValue, Empty)

  override def init(): Lista[Nothing] = Empty

  override def ++[U >: Nothing](other: Lista[U]): Lista[U] = other
}

object Lista {

  def apply[T](a: T*): Lista[T] =
    if (a.isEmpty)
      Empty
    else
      Node(a.head, apply(a.tail: _*))


  def sum(list: Lista[Int]): Int = list match {

    case Empty => 0
    case Node(head, tail) => head + sum(tail)


  }


}

