package readers

import org.apache.poi.ss.usermodel.Row
import com.anchor.model
import com.anchor.model.FinancialProgressType
import util.Utils._

/**
  * Created by mesfinmebrate on 06/09/2016.
  */
object FinancialTracking {

  private object SheetColumns {
    val id = 0
    val dayId = 1
    val currentAmount = 2
    val goalAmount = 3
    val paidIn = 4
    val paidOut = 5
    val progress = 6
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