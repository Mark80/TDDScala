import java.io.{InputStreamReader, BufferedReader, FileInputStream}

/**
 * Created by MarcopTo on 28/08/2015.
 */
object Main {

  def main(args: Array[String]) {
    import java.io.FileOutputStream

    val writer = new FileOutputStream("C:\\Users\\marcopto\\IdeaProjects\\TDDScala\\testo")

    writer.write('r')
    writer.flush()
    writer.close()

    val reader = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\marcopto\\IdeaProjects\\TDDScala\\testo")))
    val str = reader.readLine()



  }

}
