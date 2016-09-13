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
    val id = 1
    val goalId = 2
    val summary = 3
    val description = 4
    val milestone = 5
    val typeOf = 6
    val status = 7
    val order = 8
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