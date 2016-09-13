package loaders

import com.ning.http.client.AsyncHttpClientConfig
import play.api.libs.ws.DefaultWSClientConfig
import play.api.libs.ws.ning.{NingAsyncHttpClientConfigBuilder, NingWSClient}

/**
  * Created by mesfinmebrate on 05/09/2016.
  */
object WebService {

  val config = new NingAsyncHttpClientConfigBuilder(DefaultWSClientConfig()).build
  val builder = new AsyncHttpClientConfig.Builder(config)
  val client = new NingWSClient(builder.build)


}