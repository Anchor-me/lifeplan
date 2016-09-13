package readers

import org.apache.poi.ss.usermodel.Row
import com.anchor.model
import util.Utils._

/**
  * Created by mesfinmebrate on 13/09/2016.
  */
object Receipt {

  private object SheetColumns {
    val id = 1
    val trackingId = 2
    val purchasedItem = 3
    val expenditure = 4
    val nameOfEstablishment = 5
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