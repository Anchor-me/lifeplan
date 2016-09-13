package readers

import org.apache.poi.ss.usermodel.Row
import com.anchor.model
import com.anchor.model.BacklogItemType
import util.Utils._

/**
  * Created by mesfinmebrate on 05/09/2016.
  */
object BacklogItem {

  private object SheetColumns {
    val id = 1
    val yearId = 2
    val summary = 3
    val description = 4
    val typeOf = 5
  }

  def apply(row: Row): model.BacklogItem = {
    import SheetColumns._

    model.BacklogItem(
      id = getCellId(row, id),
      yearId = getCellId(row, yearId),
      summary = getCellString(row, summary),
      description = getCellString(row, description),
      typeOf = BacklogItemType.withName(getCellString(row, typeOf))
    )
  }
}