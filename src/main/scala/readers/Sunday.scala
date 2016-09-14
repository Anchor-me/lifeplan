package readers

import org.apache.poi.ss.usermodel.Row
import com.anchor.model
import util.Utils._

/**
  * Created by mesfinmebrate on 13/09/2016.
  */
object Sunday {

  private object SheetColumns {
    val id = 0
    val weekId = 1
    val date = 2
    val threads = 3
    val activeHobby = 4
  }

  def apply(row: Row): model.Sunday = {
    import SheetColumns._

    model.Sunday(
      id = getCellId(row, id),
      weekId = getCellId(row, weekId),
      date = getCellLong(row, date),
      threads = getCellArray(row, threads),
      activeHobby = getCellOption(row, activeHobby)
    )
  }
}