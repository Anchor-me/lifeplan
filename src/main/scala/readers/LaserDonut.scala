package readers

import org.apache.poi.ss.usermodel.Row
import com.anchor.model
import com.anchor.model.{DonutType, StatusType}
import util.Utils._

/**
  * Created by mesfinmebrate on 06/09/2016.
  */
object LaserDonut {

  private object SheetColumns {
    val id = 0
    val goalId = 1
    val summary = 2
    val description = 3
    val milestone = 4
    val typeOf = 5
    val status = 6
    val order = 7
  }

  def apply(row: Row): model.LaserDonut = {
    import SheetColumns._

    model.LaserDonut(
      id = getCellId(row, id),
      goalId = getCellId(row, goalId),
      summary = getCellString(row, summary),
      description = getCellString(row, description),
      milestone = getCellString(row, milestone),
      typeOf = DonutType.withName(getCellString(row, typeOf)),
      status = StatusType.withName(getCellString(row, status)),
      order = getCellInteger(row, order)
    )
  }
}