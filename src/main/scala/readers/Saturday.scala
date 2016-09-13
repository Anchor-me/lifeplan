package readers

import org.apache.poi.ss.usermodel.Row
import com.anchor.model
import util.Utils._

/**
  * Created by mesfinmebrate on 13/09/2016.
  */
object Saturday {

  private object SheetColumns {
    val id = 1
    val weekId = 2
    val date = 3
    val threads = 4
    val portion = 5
    val passiveHobby = 6
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