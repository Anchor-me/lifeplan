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
    val id = 1
    val goalId = 2
    val summary = 3
    val description = 4
    val typeOf = 5
    val status = 6
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