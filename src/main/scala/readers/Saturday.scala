package readers

import org.apache.poi.ss.usermodel.Row
import com.anchor.model
import util.Utils._

/**
  * Created by mesfinmebrate on 13/09/2016.
  */
object Saturday {

  private object SheetColumns {
    val id = 0
    val weekId = 1
    val date = 2
    val threads = 3
    val portion = 4
    val passiveHobby = 5
  }

  def apply(row: Row): model.Saturday = {
    import SheetColumns._

    model.Saturday(
      id = getCellId(row, id),
      weekId = getCellId(row, weekId),
      date = getCellLong(row, date),
      threads = getCellArray(row, threads),
      portion = getCellOption(row, portion),
      passiveHobby = getCellOption(row, passiveHobby)
    )
  }
}