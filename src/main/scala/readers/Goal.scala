package readers

import org.apache.poi.ss.usermodel.Row
import com.anchor.model
import com.anchor.model.{Id, GoalStatusType, GraduationType}
import util.Utils._

/**
  * Created by mesfinmebrate on 06/09/2016.
  */
object Goal {

  private object SheetColumns {
    val id = 1
    val themeId = 2
    val backlogItems = 3
    val summary = 4
    val description = 5
    val level = 6
    val priority = 7
    val status = 8
    val graduation = 9
  }

  def apply(row: Row): model.Goal = {
    import SheetColumns._

    model.Goal(
      id = getCellId(row, id),
      themeId = getCellId(row, themeId),
      backlogItems = getCellArray(row, backlogItems),
      summary = getCellString(row, summary),
      description = getCellString(row, description),
      level = getCellInteger(row, level),
      priority = getCellString(row, priority) == "T",
      status = GoalStatusType.withName(getCellString(row, status)),
      graduation = GraduationType.withName(getCellString(row, graduation))
    )
  }
}