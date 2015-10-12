package linecode

import org.scalatest.FunSuite

class RegexTest extends FunSuite  {



  test("regex test") {

    val comment = "/*"
    val regex = "\\/\\*"
    assert(comment.matches(regex))

  }

  test("test2 "){

    val comment = "*/"
    val regex = "\\*\\/"
    assert(comment.matches(regex))

  }

  test("test3 "){

    val comment = "/*commnet*/"
    val regex = "\\/\\*.*\\*\\/"
    assert(comment.matches(regex))

  }

  test("test3B "){

    val comment = "commnet \n bb"
    val regex = ".*\n.*"
    assert(comment.matches(regex))

  }

  test("test4 "){

    val comment = "/*commnet\n*/"
    val regex = "\\/\\*+.*\n*.*\\*\\/"
    assert(comment.matches(regex))

  }

  test("test5 "){

    val comment = "/*commnet\n marco*/"
    val regex = "\\/\\*+.*\n*.*\\*\\/"
    assert(comment.matches(regex))

  }



  test("test6 "){

    val comment = "/*commnet\n * marco*/"
    val regex = "\\/\\*+.*\n.*\\*\\/"
    assert(comment.matches(regex))

  }

  test("test7 "){

    val comment = "/*commnet\n * marco \n */"
    val regex = "\\/\\*+.*\n.*\\*\\/"
    assert(comment.matches(regex))

  }


}