package tree

sealed abstract class Tree[+T]

case class Node[+T](value: T, val left: Tree[T], val right: Tree[T]) extends Tree[T] {
  override def toString = "T(" + value.toString + " " + left.toString + " " + right.toString + ")"
}

case object End extends Tree[Nothing] {
  override def toString = " End"
}

object Node {
  def apply[T](value: T): Node[T] = Node(value, End, End)
}


object Tree {
  def isSymmetric(tree: Node[String]): Boolean = tree match {

    case Node(_, Node(_, _, _), End) => false
    case Node(_, End, Node(_, _, _)) => false
    case Node(_, left, right) => left  == mirrorOf(right)


  }

   def mirrorOf[T](tree:Tree[T]):Tree[T] = tree match {

    case End =>End
    case Node(a, Node(_,End,End),End) =>  Node(a,End,Node(a,End,End))
    case Node(a,End,Node(_,End,End)) => Node(a,Node(a,End,End),End)
    case Node(a, l,r) => Node(a,mirrorOf(r),mirrorOf(l))


  }


  def cBalanced[T](n: Int, value: T): List[Tree[T]] = {

    n match {

      case n if (n <= 0) => List(End)
      case n if (n % 2 == 0) => cBalanced(n / 2, value).flatMap(left => cBalanced((n - 1) / 2, value).flatMap(right => List(Node(value, left, right), Node(value, right, left))))
      case n if (n % 2 == 1) => cBalanced((n - 1) / 2, value).flatMap(left => cBalanced((n - 1) / 2, value).map(right => Node(value, left, right)))

    }
  }


}

