package linecode

import lineCode.LineCounter
import org.scalatest.{BeforeAndAfter, FunSuite}

class LineCodeTest extends FunSuite with BeforeAndAfter {

  before {}

  test("un test vuoto ha zero linee") {

    val lineCounter : LineCounter = new LineCounter(Vector.empty[String])
    assert(0 === lineCounter.count())


  }

  test("una testo con un commento ha zero linne di codice"){

    val commet :String = "//commnet"
    val lineCounter : LineCounter = new LineCounter(Vector(commet))
    assert(0 === lineCounter.count())
  }


  test("una testo con un commento e una dichiarazione di class ha una linea di codice"){

    val commet :String = "//commnet"
    val code : String = "class A {}"
    val lineCounter : LineCounter = new LineCounter(Vector(commet,code))
    assert(1 === lineCounter.count())

  }

  test("una testo con 2 commenti ha zero  linee di codice"){

    val commet1 :String = "//commnet1"
    val comment2 : String = "//comment2"
    val lineCounter : LineCounter = new LineCounter(Vector(commet1,comment2))
    assertResult(0)(lineCounter.count())

  }

  test("una testo con 1 commento /*comment*/ ha zero  linee di codice"){

    val commet :String = "/*comment*/"
    val commet2 :String = "//commnet1"
    val lineCounter : LineCounter = new LineCounter(Vector(commet,commet2))
    assertResult(0)(lineCounter.count())

  }

  test("una testo con 2 commenti e una class "){

    val commet :String = "/*comment*/"
    val commet2 :String = "//commnet1"
    val code : String = "class A {"
    val code2 :String = "}"
    val lineCounter : LineCounter = new LineCounter(Vector(commet,code,commet2,code2))
    assertResult(2)(lineCounter.count())

  }

  test("multiline comment"){

    val row1 = "/*"
    val row2 = "*"
    val row3 = "*/"
    val lineCounter : LineCounter = new LineCounter(Vector(row1,row2,row3))
    assertResult(0)(lineCounter.count())
  }

}