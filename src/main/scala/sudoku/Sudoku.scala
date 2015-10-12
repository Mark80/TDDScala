package sudoku

/**
 * Created by MarcopTo on 26/08/2015.
 */
class Sudoku {

  def isResolved() = false


}


object Sudoku {

  def isSolved(grid :Array[Array[Int]]) : Boolean = isRowsCompleted(grid) && isColumnsCompleted(grid)

  def isCompleted(row: Array[Int]): Boolean = (1 to 9).foldLeft(true)((acc, x) => acc && row.contains(x))

  def isRowsCompleted(grid: Array[Array[Int]]): Boolean = (0 to 8).foldLeft(true)((acc, x) => acc && isCompleted(grid(x)))

  def isColumnCompleted(col :Int ,grid: Array[Array[Int]]): Boolean = isCompleted(((0 to 8).map(index => grid(index)(col)).toArray))

  def isColumnsCompleted(grid: Array[Array[Int]]): Boolean = (0 to 8).foldLeft(true)((acc, x) => acc && isColumnCompleted(x,grid))

}
