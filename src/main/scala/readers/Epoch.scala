package readers

import org.apache.poi.ss.usermodel.Row
import com.anchor.model
import com.anchor.model.Id
import util.Utils._

/**
  * Created by mesfinmebrate on 06/09/2016.
  */
object Epoch {

  private object SheetColumns {
    val id = 1,
    val name = 2,
  }

  def apply(row: Row): model.Epoch = {
    import SheetColumns._

    model.Epoch(
      id = getCellId(row, id),
      name = getCellString(row, name)
    )
  }
}