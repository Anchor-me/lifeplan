package readers

import org.apache.poi.ss.usermodel.Row
import com.anchor.model
import util.Utils._

/**
  * Created by mesfinmebrate on 13/09/2016.
  */
object Week {

  private object SheetColumns {
    val id = 1
    val yearId = 2
    val startDate = 3
    val finishDate = 4
    val threads = 5
    val weaves = 6
    val laserDonut = 7
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