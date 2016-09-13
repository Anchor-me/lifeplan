package readers

import org.apache.poi.ss.usermodel.Row
import com.anchor.model
import util.Utils._

/**
  * Created by mesfinmebrate on 13/09/2016.
  */
object Year {

  private object SheetColumns {
    val id = 1
    val epochId = 2
    val startDate = 3
    val finishDate = 4
    val threads = 5
  }

  def apply(row: Row): model.Year = {
    import SheetColumns._

    model.Year(
      id = getCellId(row, id),
      epochId = getCellId(row, epochId),
      startDate = getCellLong(row, startDate),
      finishDate = getCellLong(row, finishDate),
      threads = getCellArray(row, threads)
    )
  }
}