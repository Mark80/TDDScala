package sudoku

import org.scalatest.{BeforeAndAfter, FunSuite}

import Sudoku._

/**
 * Created by MarcopTo on 26/08/2015.
 */
class SudokuTest extends FunSuite with BeforeAndAfter {


  before {
    gridRow = fillGridCompletedRows()
  }


  private var gridRow: Grid = _

  type Row = Array[Int]
  type Grid = Array[Row]

  test(" una riga è completa se contiene tutti i numeri da 1 a 9") {

    val row: Row = Array(1, 2, 3, 4, 5, 6, 7, 8, 9)
    assert(isCompleted(row))
    val row2: Row = Array(2, 2, 3, 4, 5, 6, 7, 8, 9)
    assert(!isCompleted(row2))

  }


  test(" una sudoku per essere risolto ogni riga deve contenere tutti i numeri da 1 a 9") {

    assert(isRowsCompleted(gridRow))
    gridRow(8) = Array(1, 2, 3, 4, 5, 6, 7, 8, 5)
    assert(!isRowsCompleted(gridRow))

  }

  test("un sudoku per essere risolto ogni riga deve contenere tutti i numeri da 1 a 9 ") {

    assert(!isColumnCompleted(0, gridRow))
    assert(!isColumnCompleted(0, fillGridCompletedColumn()))

  }

  test("test settoe") {

    val settore = getSettore(1, gridRow).toList


    assert(gridRow(0)(0) == 1)
    assert(gridRow(0)(1) == 2)
    assert(gridRow(0)(2) == 3)
    assert(gridRow(1)(0) == 1)

    assertResult(List(1, 2, 3, 1, 2, 3, 1, 2, 3))(settore)

  }

  test("un sudoku per essere risolto ogni settore deve contenere tutti i numeri da 1 a 9 ") {

    var settore: Array[Int] = getSettore(1, gridRow)
    assert(!isCompleted(settore))
    gridRow(0) = Array(1, 2, 3, 4, 5, 6, 7, 8, 5)
    gridRow(1) = Array(4, 5, 6, 4, 5, 6, 7, 8, 5)
    gridRow(2) = Array(7, 8, 9, 4, 5, 6, 7, 8, 5)
    settore = getSettore(1,gridRow)
    assert(isCompleted(settore))
  }


  private def getSettore(num: Int, grid: Grid): Array[Int] = {

    val settore: Array[Int] = Array.ofDim(9)
    var index = 0
    for (i <- 0 to 2) {
      for (j <- 0 to 2) {
        settore(index) = grid(num - 1 + i)(num - 1 + j)
        index = index + 1
      }
    }
    settore
  }

  private def fillGridCompletedRows(): Grid = {
    val grid: Array[Array[Int]] = Array.ofDim(9, 9)
    for (i <- 0 to 8) {
      grid(i) = Array(1, 2, 3, 4, 5, 6, 7, 8, 9)
    }
    grid
  }

  private def fillGridCompletedColumn(): Grid = {

    val grid: Array[Array[Int]] = Array.ofDim(9, 9)
    for (i <- 0 to 8) {
      for (j <- 0 to 8) {
        grid(i)(j) = j
      }
    }
    grid


  }

}
