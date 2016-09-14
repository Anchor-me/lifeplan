package readers

import org.apache.poi.ss.usermodel.Row
import com.anchor.model
import com.anchor.model.{StatusType, WeaveType}
import util.Utils._

/**
  * Created by mesfinmebrate on 13/09/2016.
  */
object Weave {

  private object SheetColumns {
    val id = 0
    val goalId = 1
    val summary = 2
    val description = 3
    val typeOf = 4
    val status = 5
  }

  def apply(row: Row): model.Weave = {
    import SheetColumns._

    model.Weave(
      id = getCellId(row, id),
      goalId = getCellOption(row, goalId),
      summary = getCellString(row, summary),
      description = getCellString(row, description),
      typeOf = WeaveType.withName(getCellString(row, typeOf)),
      status = StatusType.withName(getCellString(row, status))
    )
  }
}