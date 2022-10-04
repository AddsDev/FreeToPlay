package dev.adds.freetoplay.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.adds.freetoplay.model.FreeGames
import dev.adds.freetoplay.repo.FreeGamesRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class LatestGamesViewModel : ViewModel() {
    private val LATEST_VIEW_MODEL_TAG =  "LatestGamesViewModel"
    val latestGamesFlow = MutableStateFlow<FreeGames?>(null)

    init {
        viewModelScope.launch {
            kotlin.runCatching {
                FreeGamesRepo.getLatestGames()
            }.onSuccess {
                latestGamesFlow.value = it
            }.onFailure {
                Log.i(LATEST_VIEW_MODEL_TAG, "Latest game flow: ${it.message}")
                latestGamesFlow.value = null
            }
        }
    }
}