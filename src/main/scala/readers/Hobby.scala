package readers

import org.apache.poi.ss.usermodel.Row
import com.anchor.model
import com.anchor.model.{Id, HobbyType, HobbyFrequency, StatusType}
import util.Utils._

/**
  * Created by mesfinmebrate on 06/09/2016.
  */
object Hobby {

  private object SheetColumns {
    val id = 1
    val goalId = 2
    val summary = 3
    val description = 4
    val typeOf = 5
    val frequency = 6
    val status = 7
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