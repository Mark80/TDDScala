package tree

import org.scalatest.FunSuite

/**
 * Created by MarcopTo on 21/08/2015.
 */
class SymmetricTTreeest extends FunSuite {

  private val value = "x"

  test("un albero con un nodo è simmetrico "){

    val tree = Node(value)
    assertIsSymmetric(tree)

  }

  test("un albero con 2 nodi non è simmetrico"){
    
    val tree = Node(value,Node(value),End)
    assertIsNotSymmetric(tree)
  
  }

  test("un albero con 3 nodi non è simmetrico"){

    val tree = Node(value,Node(value),Node(value))
    assertIsSymmetric(tree)

  }


  test("un albero con 4 nodi non è simmetrico"){

    val tree = Node(value,Node(value,Node(value),End),Node(value))
    assertIsNotSymmetric(tree)

  }

  test("un albero  n nodi"){

    val tree = Node(value,Node(value,Node(value),End),Node(value,End,Node(value)))
    val mirroe = Tree.mirrorOf(tree)
    println(tree)
    println(mirroe)

    assertIsSymmetric(tree)

  }


  def assertIsSymmetric(tree: Node[String]): Unit = {
    assert(Tree.isSymmetric(tree))
  }


  def assertIsNotSymmetric(tree: Node[String]): Unit = {
    assert(!Tree.isSymmetric(tree))
  }
}
