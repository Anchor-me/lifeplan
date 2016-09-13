package readers

import org.apache.poi.ss.usermodel.Row
import com.anchor.model
import com.anchor.model.{BacklogItemType, TimetableType}
import util.Utils._

/**
  * Created by mesfinmebrate on 13/09/2016.
  */
object Timetable {

  private object SheetColumns {
    val id = 1
    val dayId = 2
    val scheduledItems = 3
    val typeOf = 4
  }

  def apply(row: Row): model.Timetable = {
    import SheetColumns._

    model.Timetable(
      id = getCellId(row, id),
      dayId = getCellId(row, dayId),
      scheduledItems = getCellArray(row, scheduledItems),
      typeOf = TimetableType.withName(getCellString(row, typeOf))
    )
  }
}