package readers

import org.apache.poi.ss.usermodel.Row
import com.anchor.model
import com.anchor.model.StatusType
import util.Utils._

/**
  * Created by mesfinmebrate on 13/09/2016.
  */
object ToDo {

  private object SheetColumns {
    val id = 0
    val portionId = 1
    val description = 2
    val order = 3
    val status = 4
  }

  def apply(row: Row): model.ToDo = {
    import SheetColumns._

    model.ToDo(
      id = getCellId(row, id),
      portionId = getCellId(row, portionId),
      description = getCellString(row, description),
      order = getCellInteger(row, order),
      status = StatusType.withName(getCellString(row, status))
    )
  }
}