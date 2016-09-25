package loaders

import java.io.File

import org.apache.poi.ss.usermodel.WorkbookFactory
import com.anchor.model
import readers._
import scala.collection.JavaConversions._
import util.Utils._

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

  val spreadsheet = new File(getClass.getClassLoader.getResource("Life management 2.xlsx").toURI)
  val workbook = WorkbookFactory.create(spreadsheet)

  def loadBacklogItems: Seq[model.BacklogItem] = {
    println("loading backlog items")
    getSheetRows(workbook, backlogItems).map(BacklogItem.apply)
  }

  def loadEpochs: Seq[model.Epoch] = {
    println("loading epochs")
    getSheetRows(workbook, epochs).map(Epoch.apply)
  }

  def loadFinancialTracking: Seq[model.FinancialTracking] = {
    println("loading financial tracking")
    getSheetRows(workbook, financialTracking).map(FinancialTracking.apply)
  }

  def loadGoals: Seq[model.Goal] = {
    println("loading goals")
    getSheetRows(workbook, goals).map(Goal.apply)
  }

  def loadHobbies: Seq[model.Hobby] = {
    println("loading hobbies")
    getSheetRows(workbook, hobbies).map(Hobby.apply)
  }

  def loadLaserDonuts: Seq[model.LaserDonut] = {
    println("loading laser donuts")
    getSheetRows(workbook, laserDonuts).map(LaserDonut.apply)
  }

  def loadPortions: Seq[model.Portion] = {
    println("loading backlog items")
    getSheetRows(workbook, portions).map(Portion.apply)
  }

  def loadReceipts: Seq[model.Receipt] = {
    println("loading portions")
    getSheetRows(workbook, receipts).map(Receipt.apply)
  }

  def loadThemes: Seq[model.Theme] = {
    println("loading backlog items")
    getSheetRows(workbook, themes).map(Theme.apply)
  }

  def loadThreads: Seq[model.Thread] = {
    println("loading threads")
    getSheetRows(workbook, threads).map(Thread.apply)
  }

  def loadToDos: Seq[model.ToDo] = {
    println("loading todos")
    getSheetRows(workbook, todos).map(ToDo.apply)
  }

  def loadWeaves: Seq[model.Weave] = {
    println("loading weaves")
    getSheetRows(workbook, weaves).map(Weave.apply)
  }

  def loadYears: Seq[model.Year] = {
    println("loading years")
    getSheetRows(workbook, years).map(Year.apply)
  }
}