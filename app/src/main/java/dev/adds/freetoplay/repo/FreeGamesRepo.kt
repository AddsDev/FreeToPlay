package dev.adds.freetoplay.repo

import dev.adds.freetoplay.model.FreeGames
import dev.adds.freetoplay.network.KtorClient
import io.ktor.client.call.*
import io.ktor.client.request.*

object FreeGamesRepo {

    private const val BASE_URL = "https://www.freetogame.com/api/games"

    suspend fun getLatestGames(): FreeGames {
        return KtorClient.httpClient.use {
            it.get("$BASE_URL?sort-by=release-date").body()
        }
    }
}