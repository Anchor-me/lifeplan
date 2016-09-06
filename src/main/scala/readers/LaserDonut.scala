package readers

import org.apache.poi.ss.usermodel.Row
import com.anchor.model
import com.anchor.model.{Id, LaserDonut}
import util.Utils._

/**
  * Created by mesfinmebrate on 06/09/2016.
  */
object LaserDonut {

  private object SheetColumns {
    val id = 1
    val summary = 2
    val description = 3
    val goalId = 4
    val status = 5
    val milestone = 6
    val order = 7
    val typeOf = 8
  }
}

/*
* LaserDonut (id: Id,
                       summary: String,
                       description: String,
                       goalId: Id,
                       status: StatusType.Value,
                       milestone: String,
                       order: Int,
                       typeOf: DonutType.Value)*/