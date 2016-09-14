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
    val id = 0
    val laserDonutId = 1
    val summary = 2
    val status = 3
    val order = 4
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