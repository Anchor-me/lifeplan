package readers

import org.apache.poi.ss.usermodel.Row
import com.anchor.model
import com.anchor.model.{GoalStatusType, GraduationType}
import util.Utils._

/**
  * Created by mesfinmebrate on 06/09/2016.
  */
object Goal {

  private object SheetColumns {
    val id = 0
    val themeId = 1
    val backlogItems = 2
    val summary = 3
    val description = 4
    val level = 5
    val priority = 6
    val status = 7
    val graduation = 8
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