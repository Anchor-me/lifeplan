package util

import org.apache.poi.ss.usermodel.Row

/**
  * Created by mesfinmebrate on 06/09/2016.
  */
object Utils {

  def getCellString(row: Row, position: Int): String = {
    row.getCell(position).getStringCellValue
  }

  def getCellLong(row: Row, position: Int): Long = {
    row.getCell(position).getNumericCellValue.toLong
  }

  def getCellDouble(row: Row, position: Int): Double = {
    row.getCell(position).getNumericCellValue
  }
}