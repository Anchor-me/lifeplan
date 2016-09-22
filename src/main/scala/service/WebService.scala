package service

import com.anchor.model._
import com.anchor.json._
import com.ning.http.client.AsyncHttpClientConfig
import config.Config._
import play.api.libs.ws.DefaultWSClientConfig
import play.api.libs.ws.ning.{NingAsyncHttpClientConfigBuilder, NingWSClient}
import play.api.libs.json.{JsValue, Json}
import scala.concurrent.Await
import scala.concurrent.duration._

/**
  * Created by mesfinmebrate on 05/09/2016.
  */
object WebService {

  val config = new NingAsyncHttpClientConfigBuilder(DefaultWSClientConfig()).build
  val builder = new AsyncHttpClientConfig.Builder(config)
  val ws = new NingWSClient(builder.build)

  def loadItem(item: Spoke): Unit = {
    val resultFuture = ws.url(s"$address/${queryName(item)}/add")
      .withHeaders("Accept" -> "application/json")
      .withHeaders("Content-Type" -> "application/json")
      .post(toJson(item))

    Await.result(resultFuture, 30 seconds)
  }

  def queryName(item: Spoke): String = {
    item match {
      case backlogItem: BacklogItem => "backlogitem"
      case bufferBlock: BufferBlock => "bufferblock"
      case concreteBlock: ConcreteBlock => "concreteblock"
      case epoch: Epoch => "epoch"
      case financialTracking: FinancialTracking =>"financialtracking"
      case goal: Goal => "goal"
      case hobby: Hobby => "hobby"
      case laserDonut: LaserDonut => "laserdonut"
      case portion: Portion => "portion"
      case receipt: Receipt => "receipt"
      case saturday: Saturday => "saturday"
      case sunday: Sunday => "sunday"
      case theme: Theme => "theme"
      case thread: Thread => "thread"
      case timetable: Timetable => "timetable"
      case todo: ToDo => "todo"
      case weave: Weave => "weave"
      case week: Week => "week"
      case weekDay: WeekDay => "weekday"
      case year: Year => "year"
    }
  }

  def toJson(item: Spoke): JsValue = {
    item match {
      case backlogItem: BacklogItem => Json.toJson(backlogItem)
      case bufferBlock: BufferBlock => Json.toJson(bufferBlock)
      case concreteBlock: ConcreteBlock => Json.toJson(concreteBlock)
      case epoch: Epoch => Json.toJson(epoch)
      case financialTracking: FinancialTracking => Json.toJson(financialTracking)
      case goal: Goal => Json.toJson(goal)
      case hobby: Hobby => Json.toJson(hobby)
      case laserDonut: LaserDonut => Json.toJson(laserDonut)
      case portion: Portion => Json.toJson(portion)
      case receipt: Receipt => Json.toJson(receipt)
      case saturday: Saturday => Json.toJson(saturday)
      case sunday: Sunday => Json.toJson(sunday)
      case theme: Theme => Json.toJson(theme)
      case thread: Thread => Json.toJson(thread)
      case timetable: Timetable => Json.toJson(timetable)
      case todo: ToDo => Json.toJson(todo)
      case weave: Weave => Json.toJson(weave)
      case week: Week => Json.toJson(week)
      case weekDay: WeekDay => Json.toJson(weekDay)
      case year: Year => Json.toJson(year)
    }
  }
}