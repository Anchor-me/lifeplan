package readers

import org.apache.poi.ss.usermodel.Row
import com.anchor.model
import util.Utils._

/**
  * Created by mesfinmebrate on 13/09/2016.
  */
object Week {

  private object SheetColumns {
    val id = 0
    val yearId = 1
    val startDate = 2
    val finishDate = 3
    val threads = 4
    val weaves = 5
    val laserDonut = 6
  }

  def apply(row: Row): model.Week = {
    import SheetColumns._

    model.Week(
      id = getCellId(row, id),
      yearId = getCellId(row, yearId),
      startDate = getCellLong(row, startDate),
      finishDate = getCellLong(row, finishDate),
      threads = getCellArray(row, threads),
      weaves = getCellArray(row, weaves),
      laserDonut = getCellOption(row, laserDonut)
    )
  }
}