package readers

import org.apache.poi.ss.usermodel.Row
import com.anchor.model
import util.Utils._

/**
  * Created by mesfinmebrate on 13/09/2016.
  */
object Year {

  private object SheetColumns {
    val id = 0
    val epochId = 1
    val startDate = 2
    val finishDate = 3
    val threads = 4
  }

  def apply(row: Row): model.Year = {
    import SheetColumns._

    model.Year(
      id = getCellId(row, id),
      epochId = getCellId(row, epochId),
      startDate = getCellDate(row, startDate),
      finishDate = getCellDate(row, finishDate)
    )
  }
}