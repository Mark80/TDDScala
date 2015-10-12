import java.io._

import org.scalatest.{BeforeAndAfter, FunSuite}

/**
 * Created by MarcopTo on 28/08/2015.
 */
class IOTest extends FunSuite with BeforeAndAfter {

  private var writer: PrintWriter = _

  private var reader: BufferedReader = _


  before {
    new File("C:\\Users\\marcopto\\IdeaProjects\\TDDScala\\testo").createNewFile()
    writer = new PrintWriter("C:\\Users\\marcopto\\IdeaProjects\\TDDScala\\testo")
    reader = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\marcopto\\IdeaProjects\\TDDScala\\testo")))
  }

  after {
    writer.close()
    reader.close()
    new File("C:\\Users\\marcopto\\IdeaProjects\\TDDScala\\testo").delete()
  }



  test("io test") {

    writer.print("r")
    writer.flush()
    assertResult("r")(reader.readLine())

  }

}
