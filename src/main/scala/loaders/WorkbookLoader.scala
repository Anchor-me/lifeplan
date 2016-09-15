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

  val spreadsheet = new File(getClass.getClassLoader.getResource("Life management.xlsx").toURI)
  val workbook = WorkbookFactory.create(spreadsheet)

  def loadBacklogItem: Seq[model.BacklogItem] = {
    println("loading backlog items")
    workbook.getSheet(backlogItems).rowIterator.toSeq.tail.map(BacklogItem.apply)
  }

  def loadEpochs: Seq[model.Epoch] = {
    println("loading epochs")
    workbook.getSheet(epochs).rowIterator.toSeq.tail.map(Epoch.apply)
  }

  def loadFinancialTracking: Seq[model.FinancialTracking] = {
    println("loading financial tracking")
    workbook.getSheet(financialTracking).rowIterator.toSeq.tail.map(FinancialTracking.apply)
  }

  def loadGoals: Seq[model.Goal] = {
    println("loading goals")
    workbook.getSheet(goals).rowIterator.toSeq.tail.map(Goal.apply)
  }

  def loadHobbies: Seq[model.Hobby] = {
    println("loading hobbies")
    workbook.getSheet(hobbies).rowIterator.toSeq.tail.map(Hobby.apply)
  }

  def loadLaserDonuts: Seq[model.LaserDonut] = {
    println("loading laser donuts")
    workbook.getSheet(laserDonuts).rowIterator.toSeq.tail.map(LaserDonut.apply)
  }

  def loadPortions: Seq[model.Portion] = {
    println("loading backlog items")
    workbook.getSheet(portions).rowIterator.toSeq.tail.map(Portion.apply)
  }

  def loadReceipts: Seq[model.Receipt] = {
    println("loading portions")
    workbook.getSheet(receipts).rowIterator.toSeq.tail.map(Receipt.apply)
  }

  def loadSaturdays: Seq[model.Saturday] = {
    println("loading saturdays")
    workbook.getSheet(saturdays).rowIterator.toSeq.tail.map(Saturday.apply)
  }

  def loadSundays: Seq[model.Sunday] = {
    println("loading sundays")
    workbook.getSheet(sundays).rowIterator.toSeq.tail.map(Sunday.apply)
  }

  def loadThemes: Seq[model.Theme] = {
    println("loading backlog items")
    workbook.getSheet(themes).rowIterator.toSeq.tail.map(Theme.apply)
  }

  def loadThreads: Seq[model.Thread] = {
    println("loading threads")
    workbook.getSheet(threads).rowIterator.toSeq.tail.map(Thread.apply)
  }

  def loadTimetables: Seq[model.Timetable] = {
    println("loading timetables")
    workbook.getSheet(timetable).rowIterator.toSeq.tail.map(Timetable.apply)
  }

  def loadToDos: Seq[model.ToDo] = {
    println("loading todos")
    workbook.getSheet(todos).rowIterator.toSeq.tail.map(ToDo.apply)
  }

  def loadWeaves: Seq[model.Weave] = {
    println("loading weaves")
    workbook.getSheet(weaves).rowIterator.toSeq.tail.map(Weave.apply)
  }

  def loadWeeks: Seq[model.Week] = {
    println("loading weeks")
    workbook.getSheet(weeks).rowIterator.toSeq.tail.map(Week.apply)
  }

  def loadWeekDays: Seq[model.WeekDay] = {
    println("loading week days")
    workbook.getSheet(weekDays).rowIterator.toSeq.tail.map(WeekDay.apply)
  }

  def loadYears: Seq[model.Year] = {
    println("loading years")
    workbook.getSheet(years).rowIterator.toSeq.tail.map(Year.apply)
  }
}