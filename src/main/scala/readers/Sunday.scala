package readers

import org.apache.poi.ss.usermodel.Row
import com.anchor.model
import util.Utils._

/**
  * Created by mesfinmebrate on 13/09/2016.
  */
object Sunday {

  private object SheetColumns {
    val id = 1
    val weekId = 2
    val date = 3
    val threads = 4
    val activeHobby = 5
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