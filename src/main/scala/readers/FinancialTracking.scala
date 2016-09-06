package readers

import org.apache.poi.ss.usermodel.Row
import com.anchor.model
import com.anchor.model.{Id, FinancialProgressType}
import util.Utils._

/**
  * Created by mesfinmebrate on 06/09/2016.
  */
object FinancialTracking {

  private object SheetColumns {
    val id = 1
    val dayId = 2
    val currentAmount = 3
    val goalAmount = 4
    val paidIn = 5
    val paidOut = 6
    val progress = 7
  }

  def apply(row: Row): model.FinancialTracking = {
    import SheetColumns._

    model.FinancialTracking(
      id = getCellId(row, id),
      dayId = getCellId(row, dayId),
      currentAmount = getCellDouble(row, currentAmount),
      goalAmount = getCellDouble(row, goalAmount),
      paidIn = getCellDouble(row, paidIn),
      paidOut = getCellDouble(row, paidOut),
      progress = FinancialProgressType.withName(getCellString(row, progress))
    )
  }
}