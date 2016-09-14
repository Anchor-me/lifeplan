package readers

import org.apache.poi.ss.usermodel.Row
import com.anchor.model
import util.Utils._

/**
  * Created by mesfinmebrate on 13/09/2016.
  */
object Receipt {

  private object SheetColumns {
    val id = 0
    val trackingId = 1
    val purchasedItem = 2
    val expenditure = 3
    val nameOfEstablishment = 4
  }

  def apply(row: Row): model.Receipt = {
    import SheetColumns._

    model.Receipt(
      id = getCellId(row, id),
      trackingId = getCellId(row, trackingId),
      purchasedItem = getCellString(row, purchasedItem),
      expenditure = getCellDouble(row, expenditure),
      nameOfEstablishment = getCellString(row, nameOfEstablishment)
    )
  }
}