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
    val id = 1
    val goalId = 2
    val summary = 3
    val description = 4
    val status = 5
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