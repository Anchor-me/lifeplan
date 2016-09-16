package util

import com.anchor.model.Id
import org.apache.poi.ss.usermodel.{Cell, Row, Sheet, Workbook}

import scala.collection.JavaConversions._

/**
  * Created by mesfinmebrate on 06/09/2016.
  */
object Utils {

  def getCellId(row: Row, position: Int): Id = {
    Id(getCellString(row, position))
  }

  def getCellString(row: Row, position: Int): String = {
    row.getCell(position) match {
      case cell: Cell => cell.getStringCellValue
      case null => ""
    }
  }

  def getCellLong(row: Row, position: Int): Long = {
    row.getCell(position).getNumericCellValue.toLong
  }

  def getCellDouble(row: Row, position: Int): Double = {
    row.getCell(position).getNumericCellValue
  }

  def getCellInteger(row: Row, position: Int): Int = {
    row.getCell(position).getNumericCellValue.toInt
  }

  def getCellArray(row: Row, position: Int): Seq[Id] = {
    getCellString(row, position).split(", ").map(Id.apply)
  }

  def getCellOption(row: Row, position: Int): Option[Id] = {
    val value = getCellString(row, position)

    value.trim.size match {
      case 0 => None
      case _ => Some(Id(value))
    }
  }

  def getSheetRows(workbook: Workbook, name: String): Seq[Row] = {
    workbook.getSheet(name).rowIterator.toSeq.tail.filterNot(isEmpty)
  }

  def isEmpty(row: Row): Boolean = {
    row.cellIterator.forall(cell => cell == null || cell.getStringCellValue.trim.isEmpty)
  }
}