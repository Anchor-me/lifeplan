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
      case epoch: Epoch => "epoch"
      case financialTracking: FinancialTracking =>"financialtracking"
      case goal: Goal => "goal"
      case hobby: Hobby => "hobby"
      case laserDonut: LaserDonut => "laserdonut"
      case portion: Portion => "portion"
      case receipt: Receipt => "receipt"
      case theme: Theme => "theme"
      case thread: Thread => "thread"
      case todo: ToDo => "todo"
      case weave: Weave => "weave"
      case year: Year => "year"
    }
  }

  def toJson(item: Spoke): JsValue = {
    item match {
      case backlogItem: BacklogItem => Json.toJson(backlogItem)
      case epoch: Epoch => Json.toJson(epoch)
      case financialTracking: FinancialTracking => Json.toJson(financialTracking)
      case goal: Goal => Json.toJson(goal)
      case hobby: Hobby => Json.toJson(hobby)
      case laserDonut: LaserDonut => Json.toJson(laserDonut)
      case portion: Portion => Json.toJson(portion)
      case receipt: Receipt => Json.toJson(receipt)
      case theme: Theme => Json.toJson(theme)
      case thread: Thread => Json.toJson(thread)
      case todo: ToDo => Json.toJson(todo)
      case weave: Weave => Json.toJson(weave)
      case year: Year => Json.toJson(year)
    }
  }
}