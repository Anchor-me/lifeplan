package readers

import org.apache.poi.ss.usermodel.Row
import com.anchor.model
import util.Utils._

/**
  * Created by mesfinmebrate on 13/09/2016.
  */
object WeekDay {

  private object SheetColumns {
    val id = 1
    val weekId = 2
    val date = 3
    val threads = 4
    val weaves = 5
    val portion = 6
  }

  def apply(row: Row): model.WeekDay = {
    import SheetColumns._

    model.WeekDay(
      id = getCellId(row, id),
      weekId = getCellId(row, weekId),
      date = getCellLong(row, date),
      threads = getCellArray(row, threads),
      weaves = getCellArray(row, weaves),
      portion = getCellOption(row, portion)
    )
  }
}