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
    val id = 1
    val portionId = 2
    val description = 3
    val order = 4
    val status = 5
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