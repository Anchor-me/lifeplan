package readers

import org.apache.poi.ss.usermodel.Row
import com.anchor.model
import com.anchor.model.{Id, BacklogItemType}
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

/*
* case SpokeType.BacklogItem => Json.toJson(item.asBacklogItem)
  case SpokeType.BufferBlock => Json.toJson(item.asBufferBlock)
  case SpokeType.ConcreteBlock => Json.toJson(item.asConcreteBlock)
  case SpokeType.Epoch => Json.toJson(item.asEpoch)
  case SpokeType.FinancialTracking => Json.toJson(item.asFinancialTracking)
  case SpokeType.Goal => Json.toJson(item.asGoal)
  case SpokeType.Hobby => Json.toJson(item.asHobby)
  case SpokeType.LaserDonut => Json.toJson(item.asLaserDonut)
  case SpokeType.Portion => Json.toJson(item.asPortion)
  case SpokeType.Receipt => Json.toJson(item.asReceipt)
  case SpokeType.Saturday => Json.toJson(item.asSaturday)
  case SpokeType.Sunday => Json.toJson(item.asSunday)
  case SpokeType.Theme => Json.toJson(item.asTheme)
  case SpokeType.Thread => Json.toJson(item.asThread)
  case SpokeType.Timetable => Json.toJson(item.asTimetable)
  case SpokeType.ToDo => Json.toJson(item.asToDo)
  case SpokeType.Weave => Json.toJson(item.asWeave)
  case SpokeType.Week => Json.toJson(item.asWeek)
  case SpokeType.WeekDay => Json.toJson(item.asWeekDay)
  case SpokeType.Year => Json.toJson(item.asYear)*/