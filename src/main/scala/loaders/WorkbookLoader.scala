package loaders

import java.io.File

import org.apache.poi.ss.usermodel.WorkbookFactory
import com.anchor.model
import readers._
import scala.collection.JavaConversions._

/**
  * Created by mesfinmebrate on 14/09/2016.
  */

object Sheets extends Enumeration {
  val epochs = "Epochs"
  val years = "Years"
  val weeks = "Weeks"
  val weekDays = "Week days"
  val saturdays = "Saturdays"
  val sundays = "Sundays"
  val backlogItems = "Backlog items"
  val themes = "Themes"
  val goals = "Goals"
  val threads = "Threads"
  val weaves = "Weaves"
  val laserDonuts = "Laser donuts"
  val portions = "Portions"
  val todos = "To-dos"
  val hobbies = "Hobbies"
  val financialTracking = "Financial tracking"
  val receipts = "Receipts"
  val timetable = "Timetable"
}

object WorkbookLoader {

  import Sheets._

  val spreadsheet = new File(getClass.getResource("Life management.xlsx").toURI)
  val workbook = WorkbookFactory.create(spreadsheet)

  def loadBacklogItem: Seq[model.BacklogItem] = {
    println("loading backlog items")
    workbook.getSheet(backlogItems).rowIterator.map(BacklogItem.apply).toSeq
  }

  def loadEpochs: Seq[model.Epoch] = {
    println("loading epochs")
    workbook.getSheet(epochs).rowIterator.map(Epoch.apply).toSeq
  }

  def loadFinancialTracking: Seq[model.FinancialTracking] = {
    println("loading financial tracking")
    workbook.getSheet(financialTracking).rowIterator.map(FinancialTracking.apply).toSeq
  }

  def loadGoals: Seq[model.Goal] = {
    println("loading goals")
    workbook.getSheet(goals).rowIterator.map(Goal.apply).toSeq
  }

  def loadHobbies: Seq[model.Hobby] = {
    println("loading hobbies")
    workbook.getSheet(hobbies).rowIterator.map(Hobby.apply).toSeq
  }

  def loadLaserDonuts: Seq[model.LaserDonut] = {
    println("loading laser donuts")
    workbook.getSheet(laserDonuts).rowIterator.map(LaserDonut.apply).toSeq
  }

  def loadPortions: Seq[model.Portion] = {
    println("loading backlog items")
    workbook.getSheet(portions).rowIterator.map(Portion.apply).toSeq
  }

  def loadReceipts: Seq[model.Receipt] = {
    println("loading portions")
    workbook.getSheet(receipts).rowIterator.map(Receipt.apply).toSeq
  }

  def loadSaturdays: Seq[model.Saturday] = {
    println("loading saturdays")
    workbook.getSheet(saturdays).rowIterator.map(Saturday.apply).toSeq
  }

  def loadSundays: Seq[model.Sunday] = {
    println("loading sundays")
    workbook.getSheet(sundays).rowIterator.map(Sunday.apply).toSeq
  }

  def loadThemes: Seq[model.Theme] = {
    println("loading backlog items")
    workbook.getSheet(themes).rowIterator.map(Theme.apply).toSeq
  }

  def loadThreads: Seq[model.Thread] = {
    println("loading threads")
    workbook.getSheet(threads).rowIterator.map(Thread.apply).toSeq
  }

  def loadTimetables: Seq[model.Timetable] = {
    println("loading timetables")
    workbook.getSheet(timetable).rowIterator.map(Timetable.apply).toSeq
  }

  def loadToDos: Seq[model.ToDo] = {
    println("loading todos")
    workbook.getSheet(todos).rowIterator.map(ToDo.apply).toSeq
  }

  def loadWeaves: Seq[model.Weave] = {
    println("loading weaves")
    workbook.getSheet(weaves).rowIterator.map(Weave.apply).toSeq
  }

  def loadWeeks: Seq[model.Week] = {
    println("loading weeks")
    workbook.getSheet(weeks).rowIterator.map(Week.apply).toSeq
  }

  def loadWeekDays: Seq[model.WeekDay] = {
    println("loading week days")
    workbook.getSheet(weekDays).rowIterator.map(WeekDay.apply).toSeq
  }

  def loadYears: Seq[model.Year] = {
    println("loading years")
    workbook.getSheet(years).rowIterator.map(Year.apply).toSeq
  }
}