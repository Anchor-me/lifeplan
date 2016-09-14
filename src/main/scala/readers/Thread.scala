package readers

import org.apache.poi.ss.usermodel.Row
import com.anchor.model
import com.anchor.model.StatusType
import util.Utils._

/**
  * Created by mesfinmebrate on 13/09/2016.
  */
object Thread {

  private object SheetColumns {
    val id = 0
    val goalId = 1
    val summary = 2
    val description = 3
    val status = 4
  }

  def apply(row: Row): model.Thread = {
    import SheetColumns._

    model.Thread(
      id = getCellId(row, id),
      goalId = getCellOption(row, goalId),
      summary = getCellString(row, summary),
      description = getCellString(row, description),
      status = StatusType.withName(getCellString(row, status))
    )
  }
}