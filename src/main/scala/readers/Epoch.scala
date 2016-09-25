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
    val id = 0
    val name = 1
    val totem = 2
    val question = 3
  }

  def apply(row: Row): model.Epoch = {
    import SheetColumns._

    model.Epoch(
      id = getCellId(row, id),
      name = getCellString(row, name),
      totem = getCellString(row, totem),
      question = getCellString(row, question)
    )
  }
}