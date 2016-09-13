package readers

import org.apache.poi.ss.usermodel.Row
import com.anchor.model
import com.anchor.model.StatusType
import util.Utils._

/**
  * Created by mesfinmebrate on 13/09/2016.
  */
object Portion {

  private object SheetColumns {
    val id = 1
    val laserDonutId = 2
    val summary = 3
    val status = 4
    val order = 5
  }

  def apply(row: Row): model.Portion = {
    import SheetColumns._

    model.Portion(
      id = getCellId(row, id),
      laserDonutId = getCellId(row, laserDonutId),
      summary = getCellString(row, summary),
      status = StatusType.withName(getCellString(row, status)),
      order = getCellInteger(row, order)
    )
  }
}