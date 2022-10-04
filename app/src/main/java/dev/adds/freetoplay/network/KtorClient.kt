package dev.adds.freetoplay.network

import com.google.gson.Gson
import com.readystatesoftware.chuck.ChuckInterceptor
import io.github.aakira.napier.Napier
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.gson.*


object KtorClient {
    private const val KTOR_TAG: String = "Ktor-Log"

    val httpClient = HttpClient {
        install(ContentNegotiation) {

            gson {
                Gson().newBuilder()
                    .setPrettyPrinting()
                    .setLenient()
                    .create()
            }
            Logging {
                level = LogLevel.HEADERS
                logger = object : Logger {
                    override fun log(message: String) {
                        Napier.v("HTTP Client", null, message)
                    }
                }
                filter {
                    it.url.host.contains("freetogame")
                }
            }
            /*HttpClient(Android) {
                engine {
                    connectTimeout = 100_00
                    socketTimeout = 100_00
                }
            }*/
            //For OkHttp
            //https://ktor.io/docs/eap/http-client-engines.html#okhttp
            HttpClient(OkHttp){
                engine {
                    config {
                        followRedirects(true)
                    }
                    /*addInterceptor(ChuckInterceptor(context))
                    addNetworkInterceptor(interceptor)

                    preconfigured = okHttpClientInstance*/
                }
            }
            defaultRequest {
                contentType(ContentType.Application.Json)
                accept(ContentType.Application.Json)
            }
        }
    }
}