package readers

import org.apache.poi.ss.usermodel.Row
import com.anchor.model
import util.Utils._

/**
  * Created by mesfinmebrate on 13/09/2016.
  */
object Theme {

  private object SheetColumns {
    val id = 1
    val yearId = 2
    val name = 3
  }

  def apply(row: Row): model.Theme = {
    import SheetColumns._

    model.Theme(
      id = getCellId(row, id),
      yearId = getCellId(row, yearId),
      name = getCellString(row, name)
    )
  }
}