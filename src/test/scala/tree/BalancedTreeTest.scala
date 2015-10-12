package tree

import org.scalatest.FunSuite

/**
 * Created by MarcopTo on 19/08/2015.
 */
class BalancedTreeTest extends FunSuite {

  import Tree._

  private val x: String = "x"


  test("One node tree") {

    assertTreesBalanced(List(Node(x, End, End)), cBalanced(1, x))

  }


  test("2 node") {

    val expected = List(Node(x, Node(x), End), Node(x, End, Node(x)))

    assertTreesBalanced(expected, cBalanced(2, x))

  }

  test("3 node") {

    val expected = List(Node(x, Node(x), Node(x)))

    assertTreesBalanced(expected, cBalanced(3, x))

  }

  test("4 node") {

    val result = cBalanced(4, x)

    assert(result.size == 4)

  }

  test("6 node") {

    val result = cBalanced(6, x)

    assert(result.size == 4)

  }

  test("7 node") {

    val result = cBalanced(7, x)
    assert(result.size == 1)

  }

  test("8 node") {

    val result = cBalanced(8, x)
    assert(result.size == 8)

  }

  test("9 node") {

    val result = cBalanced(9, x)

    println(result)

    assert(result.size == 16)

  }




  def assertTreesBalanced[T](expected: List[Tree[T]], res: List[Tree[T]]): Unit = {

    assert(expected == res && res.foldLeft(true)((acc: Boolean, tree: Tree[T]) => acc && isBalanced(tree)))


  }


  private def isBalanced[T](tree: Tree[T]): Boolean = tree match {


    case node: Node[T] => isBalanced(node.left) && isBalanced(node.right) && (numberofNode(node.left) - numberofNode(node.right)) <= 1
    case End => true
  }


  private def numberofNode[T](tree: Tree[T]): Int = {

    tree match {

      case Node(_, l, r) => 1 + numberofNode(l) + numberofNode(r)
      case End => 0

    }

  }


}
