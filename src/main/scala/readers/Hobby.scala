package readers

import org.apache.poi.ss.usermodel.Row
import com.anchor.model
import com.anchor.model.{HobbyType, HobbyFrequency, StatusType}
import util.Utils._

/**
  * Created by mesfinmebrate on 06/09/2016.
  */
object Hobby {

  private object SheetColumns {
    val id = 0
    val goalId = 1
    val summary = 2
    val description = 3
    val typeOf = 4
    val frequency = 5
    val status = 6
  }

  def apply(row: Row): model.Hobby = {
    import SheetColumns._

    model.Hobby(
      id = getCellId(row, id),
      goalId = getCellOption(row, goalId),
      summary = getCellString(row, summary),
      description = getCellString(row, description),
      typeOf = HobbyType.withName(getCellString(row, typeOf)),
      frequency = HobbyFrequency.withName(getCellString(row, frequency)),
      status = StatusType.withName(getCellString(row, status))
    )
  }
}